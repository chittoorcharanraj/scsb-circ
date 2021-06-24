package org.recap.request.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.recap.PropertyKeyConstants;
import org.recap.ScsbCommonConstants;
import org.recap.ScsbConstants;
import org.recap.model.request.BulkRequestItem;
import org.recap.model.request.ItemRequestInformation;
import org.recap.ims.model.TtitemEDDResponse;
import org.recap.model.jpa.*;
import org.recap.repository.jpa.BulkRequestItemDetailsRepository;
import org.recap.repository.jpa.GenericPatronDetailsRepository;
import org.recap.request.service.EmailService;
import org.recap.service.RestHeaderService;
import org.recap.util.PropertyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

/**
 * Created by rajeshbabuk on 10/10/17.
 */
@Service
public class ItemRequestServiceUtil {

    private final Logger logger = LoggerFactory.getLogger(ItemRequestServiceUtil.class);

    @Value("${" + PropertyKeyConstants.SCSB_SOLR_DOC_URL + "}")
    private String scsbSolrClientUrl;

    @Autowired
    private RestHeaderService restHeaderService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private BulkRequestItemDetailsRepository bulkRequestItemDetailsRepository;

    @Autowired
    private GenericPatronDetailsRepository genericPatronDetailsRepository;

    @Autowired
    private PropertyUtil propertyUtil;

    public RestHeaderService getRestHeaderService(){
        return restHeaderService;
    }

    /**
     * Update solr index.
     *
     * @param itemEntity the item entity
     */
    public void updateSolrIndex(ItemEntity itemEntity) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity requestEntity = new HttpEntity<>(getRestHeaderService().getHttpHeaders());
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(scsbSolrClientUrl + ScsbConstants.UPDATE_ITEM_STATUS_SOLR).queryParam(ScsbConstants.UPDATE_ITEM_STATUS_SOLR_PARAM_ITEM_ID, itemEntity.getBarcode());
            ResponseEntity<String> responseEntity = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, requestEntity, String.class);
            logger.info(responseEntity.getBody());
        } catch (Exception e) {
            logger.error(ScsbCommonConstants.REQUEST_EXCEPTION, e);
        }
    }

    /**
     * Updates process status to each barcode in csv format.
     * @param bulkRequestItems
     * @param bulkRequestItemEntity
     */
    public void updateStatusToBarcodes(List<BulkRequestItem> bulkRequestItems, BulkRequestItemEntity bulkRequestItemEntity) {
        StringBuilder csvFormatDataBuilder = new StringBuilder();
        String requestData = new String(bulkRequestItemEntity.getBulkRequestFileData());
        csvFormatDataBuilder.append(requestData);
        buildCsvFormatData(bulkRequestItems, csvFormatDataBuilder);
        bulkRequestItemEntity.setBulkRequestFileData(csvFormatDataBuilder.toString().getBytes());
        bulkRequestItemDetailsRepository.save(bulkRequestItemEntity);
    }

    /**
     * Builds csv format data for all bulk request items.
     * @param exceptionBulkRequestItems
     * @param csvFormatDataBuilder
     */
    public void buildCsvFormatData(List<BulkRequestItem> exceptionBulkRequestItems, StringBuilder csvFormatDataBuilder) {
        for (BulkRequestItem bulkRequestItem : exceptionBulkRequestItems) {
            csvFormatDataBuilder.append("\n");
            csvFormatDataBuilder.append(bulkRequestItem.getItemBarcode()).append(",");
            csvFormatDataBuilder.append(bulkRequestItem.getCustomerCode()).append(",");
            csvFormatDataBuilder.append(bulkRequestItem.getRequestId()).append(",");
            csvFormatDataBuilder.append(bulkRequestItem.getRequestStatus()).append(",");
            csvFormatDataBuilder.append(StringEscapeUtils.escapeCsv(bulkRequestItem.getStatus()));
        }
    }

    /**
     * Generates report for the bulk request items and sends an email.
     * @param bulkRequestId
     */
    public void generateReportAndSendEmail(Integer bulkRequestId) {
        Optional<BulkRequestItemEntity> bulkRequestItemEntity = bulkRequestItemDetailsRepository.findById(bulkRequestId);
        if(bulkRequestItemEntity.isPresent()) {
            emailService.sendBulkRequestEmail(String.valueOf(bulkRequestItemEntity.get().getId()),
                    bulkRequestItemEntity.get().getBulkRequestName(), bulkRequestItemEntity.get().getBulkRequestFileName(),
                    bulkRequestItemEntity.get().getBulkRequestStatus(), new String(bulkRequestItemEntity.get().getBulkRequestFileData()),
                    "Bulk Request Process Report");
        }
    }

    /**
     * Builds edd info from request notes for LAS request queue.
     * @param line
     * @param ttitem001
     */
    public void setEddInfoToGfaRequest(String line, TtitemEDDResponse ttitem001) {
        String[] splitData = line.split(":");
        if (ArrayUtils.isNotEmpty(splitData) && splitData.length > 1) {
            ttitem001.setStartPage(validateAndSet("Start Page", splitData));
            ttitem001.setEndPage(validateAndSet("End Page", splitData));
            ttitem001.setArticleVolume(validateAndSet("Volume Number", splitData));
            ttitem001.setArticleIssue(validateAndSet("Issue", splitData));
            ttitem001.setArticleAuthor(validateAndSet("Article Author", splitData));
            ttitem001.setArticleTitle(validateAndSet("Article/Chapter Title", splitData));
        }
    }

    /**
     * Builds edd info from request notes for SCSB request queue.
     * @param line
     * @param itemRequestInformation
     */
    public void setEddInfoToScsbRequest(String line, ItemRequestInformation itemRequestInformation) {
        String[] splitData = line.split(":");
        if (ArrayUtils.isNotEmpty(splitData) && splitData.length > 1) {
            itemRequestInformation.setRequestNotes(validateAndSet("User", splitData));
            itemRequestInformation.setStartPage(validateAndSet("Start Page", splitData));
            itemRequestInformation.setEndPage(validateAndSet("End Page", splitData));
            itemRequestInformation.setVolume(validateAndSet("Volume Number", splitData));
            itemRequestInformation.setIssue(validateAndSet("Issue", splitData));
            itemRequestInformation.setAuthor(validateAndSet("Article Author", splitData));
            itemRequestInformation.setChapterTitle(validateAndSet("Article/Chapter Title", splitData));
        }
    }

    private String validateAndSet(String key, String[] splitData) {
        if (ArrayUtils.isNotEmpty(splitData)) {
            String splitDataString = splitData[0];
            String splitDataValue = splitData[1].trim();
            if (key.equals(splitDataString))
                return splitDataValue;
        }
        return "";
    }

    public String getPatronIdBorrowingInstitution(String requestingInstitution, String owningInstitution, String requestType) {
        String patronId = "";
        GenericPatronEntity genericPatronEntity = genericPatronDetailsRepository.findByRequestingInstitutionCodeAndItemOwningInstitutionCode(requestingInstitution, owningInstitution);
        if(genericPatronEntity != null) {
            if (ScsbCommonConstants.REQUEST_TYPE_EDD.equalsIgnoreCase(requestType)) {
                patronId = genericPatronEntity.getEddGenericPatron();
            } else {
                patronId = genericPatronEntity.getRetrievalGenericPatron();
            }
        }
        logger.info("Own Ins: {}, Req Ins: {}, Cross PatronId: {}", owningInstitution, requestingInstitution, patronId);
        return patronId;
    }
}
