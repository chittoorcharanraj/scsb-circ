package org.recap.camel.requestinitialdataload.processor;

import com.amazonaws.services.s3.AmazonS3;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.recap.PropertyKeyConstants;
import org.recap.ScsbCommonConstants;
import org.recap.ScsbConstants;
import org.recap.camel.requestinitialdataload.RequestDataLoadCSVRecord;
import org.recap.model.jpa.ItemEntity;
import org.recap.model.report.RequestInitialLoadBarcodesInLAS;
import org.recap.service.requestdataload.RequestDataLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

/**
 * Created by hemalathas on 3/5/17.
 */
@Slf4j
@Service
@Scope("prototype")
public class RequestInitialDataLoadProcessor {


    @Autowired
    private RequestDataLoadService requestDataLoadService;

    @Value("${" + PropertyKeyConstants.REQUEST_INITIAL_LOAD_FILEPATH + "}")
    private String requestInitialLoadFilePath;

    @Value("${" + PropertyKeyConstants.SCSB_SOLR_DOC_URL + "}")
    private String scsbSolrClientUrl;

    @Value("${" + PropertyKeyConstants.IS_SOLR_INDEX_REQ_FOR_REQUEST_INITIAL_LOAD + "}")
    private boolean isSolrIndexRequired;

    @Autowired
    RestTemplate restTemplate;

    private String institutionCode;

    @Autowired
    private CamelContext camelContext;

    @Autowired
    AmazonS3 awsS3Client;

    @Autowired
    ProducerTemplate producerTemplate;

    /**
     * Instantiates a new request initial data load processor.
     *
     * @param institutionCode the institution code
     */
    public RequestInitialDataLoadProcessor(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    private Set<String> barcodeSet = new HashSet<>();
    private int totalCount = 0;

    /**
     * To load the request initial data in scsb.
     *
     * @param exchange the exchange
     * @throws ParseException the parse exception
     */
    public void processInput(Exchange exchange) throws ParseException {
        List<RequestDataLoadCSVRecord> completeRequestDataLoadCSVRecordList = (List<RequestDataLoadCSVRecord>)exchange.getIn().getBody();
        List<List<RequestDataLoadCSVRecord>> partitionedList = Lists.partition(completeRequestDataLoadCSVRecordList, 10);
        List<ItemEntity> barcodesToIndex=new ArrayList<>();
        List<ItemEntity> barcodesAvailableInLAS=new ArrayList<>();
        int count=0;
        for (List<RequestDataLoadCSVRecord> requestDataLoadCSVRecordList : partitionedList) {
            try {
                Map<String, Object> barcodesMap = requestDataLoadService.process(requestDataLoadCSVRecordList,barcodeSet);
                Set<String> barcodesNotInSCSB = (Set<String>) barcodesMap.get(ScsbConstants.BARCODE_NOT_FOUND_IN_SCSB);
                List<ItemEntity> itemEntityList = (List<ItemEntity>) barcodesMap.get(ScsbConstants.REQUEST_INITIAL_BARCODES_AVAILABLE_IN_LAS);
                List<ItemEntity> itemsToIndex = (List<ItemEntity>) barcodesMap.get(ScsbConstants.REQUEST_INITIAL_BARCODES_TO_INDEX);
                barcodesAvailableInLAS.addAll(itemEntityList);
                barcodesToIndex.addAll(itemsToIndex);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMMyyyy");
                Path filePath = Paths.get(requestInitialLoadFilePath+ScsbCommonConstants.PATH_SEPARATOR+institutionCode+ScsbCommonConstants.PATH_SEPARATOR+ ScsbConstants.REQUEST_INITIAL_FILE_NAME+institutionCode+simpleDateFormat.format(new Date())+".csv");
                if (!filePath.toFile().exists()) {
                    Files.createDirectories(filePath.getParent());
                    Files.createFile(filePath);
                    log.info("Request Initial Load File Created--->{}",filePath);
                }
                if(count == 0){
                    Set<String> headerSet = new HashSet<>();
                    headerSet.add(ScsbConstants.REQUEST_INITIAL_LOAD_HEADER);
                    Files.write(filePath,headerSet, StandardOpenOption.APPEND);
                }
                Files.write(filePath,barcodesNotInSCSB, StandardOpenOption.APPEND);
                count++;
            }
            catch (Exception e){
                barcodeSet.clear();
                totalCount=0;
                log.error(ScsbCommonConstants.LOG_ERROR,e);
            }
            barcodeSet.clear();
            totalCount = totalCount + requestDataLoadCSVRecordList.size();
            log.info("Total count from las report---->{}",totalCount);
            totalCount = 0;
            String xmlFileName = exchange.getIn().getHeader("CamelAwsS3Key").toString();
            String bucketName = exchange.getIn().getHeader("CamelAwsS3BucketName").toString();
            if (awsS3Client.doesObjectExist(bucketName, xmlFileName)) {
                String basepath = xmlFileName.substring(0, xmlFileName.lastIndexOf('/'));
                basepath = basepath.substring(0, basepath.lastIndexOf('/'));
                String fileName = xmlFileName.substring(xmlFileName.lastIndexOf('/'));
                awsS3Client.copyObject(bucketName, xmlFileName, bucketName, basepath + "/.done-" + institutionCode + fileName);
                awsS3Client.deleteObject(bucketName, xmlFileName);
            }
        }
        startFileSystemRoutesForAccessionReconciliation(barcodesAvailableInLAS);
        if(isSolrIndexRequired) {
            List<Integer> bibIdsToIndex = barcodesToIndex.stream()
                    .flatMap(itemEntity -> itemEntity.getBibliographicEntities().stream().map(bibliographicEntity -> bibliographicEntity.getId()).collect(toCollection(ArrayList::new)).stream())
                    .distinct()
                    .collect(Collectors.toCollection(ArrayList::new));
            restTemplate.postForObject(scsbSolrClientUrl + "/solrIndexer/indexByBibliographicId", bibIdsToIndex, String.class);
        }
    }

    private void startFileSystemRoutesForAccessionReconciliation(List<ItemEntity> barcodesAvailableInLAS) {
        Map<String, Map<String, List<ItemEntity>>> institutionWiseImsLocBarcodes = barcodesAvailableInLAS.stream().collect(Collectors.groupingBy(itemEntity -> itemEntity.getInstitutionEntity().getInstitutionCode(), Collectors.groupingBy(itemEntity -> itemEntity.getImsLocationEntity().getImsLocationCode())));
        try {
            log.info("{}{}{}", ScsbConstants.STARTING, ScsbConstants.REQUEST_INITIAL_LOAD_FS_ROUTE, institutionCode);
            institutionWiseImsLocBarcodes.entrySet().forEach(institutionWiseEntries -> {
                Map<String, Object> headers = new HashMap<>();
                headers.put("institutionCode", institutionWiseEntries.getKey());
                institutionWiseEntries.getValue().entrySet().forEach(imsWiseEntries -> {
                    headers.put("imsLocationCode", imsWiseEntries.getKey());
                    List<ItemEntity> barcodesInAvailableStatus = imsWiseEntries.getValue();
                    List<RequestInitialLoadBarcodesInLAS> barcodes = barcodesInAvailableStatus.stream().map(itemEntity -> new RequestInitialLoadBarcodesInLAS(itemEntity.getBarcode())).collect(Collectors.toCollection(ArrayList::new));
                    producerTemplate.sendBodyAndHeaders(ScsbConstants.DIRECT + ScsbConstants.RIL_DIRECT_BARCODES_AVAILABLE_IN_LAS, barcodes, headers);
                });
            });
            camelContext.getRouteController().startRoute(ScsbConstants.REQUEST_INITIAL_LOAD_FS_ROUTE + institutionCode);
        } catch (Exception e) {
            log.error(ScsbCommonConstants.LOG_ERROR, e);
        }
    }

    /**
     * Gets barcode set.
     *
     * @return the barcode set
     */
    public Set<String> getBarcodeSet() {
        return barcodeSet;
    }

    /**
     * Sets barcode set.
     *
     * @param barcodeSet the barcode set
     */
    public void setBarcodeSet(Set<String> barcodeSet) {
        this.barcodeSet = barcodeSet;
    }
}
