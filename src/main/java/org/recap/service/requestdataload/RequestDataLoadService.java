package org.recap.service.requestdataload;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.recap.PropertyKeyConstants;
import org.recap.ScsbConstants;
import org.recap.ScsbCommonConstants;
import org.recap.camel.requestinitialdataload.RequestDataLoadCSVRecord;
import org.recap.ims.service.GFALasService;
import org.recap.model.jpa.ItemEntity;
import org.recap.model.jpa.ItemStatusEntity;
import org.recap.model.jpa.RequestItemEntity;
import org.recap.model.jpa.RequestTypeEntity;
import org.recap.repository.jpa.ItemDetailsRepository;
import org.recap.repository.jpa.ItemStatusDetailsRepository;
import org.recap.repository.jpa.RequestItemDetailsRepository;
import org.recap.repository.jpa.RequestTypeDetailsRepository;
import org.recap.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import static org.apache.commons.collections.CollectionUtils.isNotEmpty;

/**
 * Created by hemalathas on 4/5/17.
 */
@Slf4j
@Service
public class RequestDataLoadService {



    @Value("${" + PropertyKeyConstants.IS_GFA_CHECK_REQ_FOR_REQUEST_INITIAL_LOAD + "}")
    private boolean requestInitialLoadGfaCheck;

    @Autowired
    ItemStatusDetailsRepository itemStatusDetailsRepository;

    @Autowired
    private ItemDetailsRepository itemDetailsRepository;

    @Autowired
    private RequestTypeDetailsRepository requestTypeDetailsRepository;

    @Autowired
    private RequestItemDetailsRepository requestItemDetailsRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    GFALasService gfaLasService;

    @Autowired
    CommonUtil commonUtil;

    /**
     * To save the given requestDataLoadCSVRecords in scsb.
     *
     * @param requestDataLoadCSVRecords the request data load csv records
     * @param barcodeSet                the barcode set
     * @return the set
     * @throws ParseException the parse exception
     */
    public Map<String,Object> process(List<RequestDataLoadCSVRecord> requestDataLoadCSVRecords, Set<String> barcodeSet) throws ParseException {
        List<RequestItemEntity> requestItemEntityList = new ArrayList<>();
        List<String> duplicateBarcodes = new ArrayList<>();
        Set<String> barcodesNotInScsb = new HashSet<>();
        List<ItemEntity> barcodesAvailableInLAS = new ArrayList<>();
        List<ItemEntity> itemsToIndex = new ArrayList<>();
        RequestItemEntity requestItemEntity = null;
        ItemStatusEntity itemNotAvailableEntity = itemStatusDetailsRepository.findByStatusCode(ScsbCommonConstants.NOT_AVAILABLE);
        for(RequestDataLoadCSVRecord requestDataLoadCSVRecord : requestDataLoadCSVRecords){
            Integer itemId = 0;
            Integer requestingInstitutionId = 0 ;
            requestItemEntity = new RequestItemEntity();
            if(!barcodeSet.add(requestDataLoadCSVRecord.getBarcode())){
                duplicateBarcodes.add(requestDataLoadCSVRecord.getBarcode());
                log.info("Barcodes duplicated in the incoming record {}",requestDataLoadCSVRecord.getBarcode());
                continue;
            }
            Map<String,Object> itemInfo = getItemInfo(requestDataLoadCSVRecord.getBarcode(),itemNotAvailableEntity);
            if(itemInfo.get(ScsbConstants.REQUEST_DATA_LOAD_ITEM_ID) != null){
                itemId = (Integer) itemInfo.get(ScsbConstants.REQUEST_DATA_LOAD_ITEM_ID);
            }
            if(itemInfo.get(ScsbConstants.REQUEST_DATA_LOAD_REQUESTING_INST_ID) != null){
                requestingInstitutionId = (Integer) itemInfo.get(ScsbConstants.REQUEST_DATA_LOAD_REQUESTING_INST_ID);
            }
            if(itemInfo.get(ScsbConstants.REQUEST_INITIAL_BARCODES_AVAILABLE_IN_LAS)!=null){
                barcodesAvailableInLAS.addAll((Collection<? extends ItemEntity>) itemInfo.get(ScsbConstants.REQUEST_INITIAL_BARCODES_AVAILABLE_IN_LAS));
            }
            if(!CollectionUtils.isEmpty((Collection<?>) itemInfo.get(ScsbConstants.REQUEST_INITIAL_BARCODES_TO_INDEX))){
                List<ItemEntity> itemEntityList = (List<ItemEntity>) itemInfo.get(ScsbConstants.REQUEST_INITIAL_BARCODES_TO_INDEX);
                itemsToIndex.addAll(itemEntityList);
            }
            if(itemId == 0 || requestingInstitutionId == 0){
                barcodesNotInScsb.add(requestDataLoadCSVRecord.getBarcode());
            }else if(CollectionUtils.isEmpty((Collection<?>) itemInfo.get(ScsbConstants.REQUEST_INITIAL_BARCODES_AVAILABLE_IN_LAS))){
                prepareRequestItemEntities(requestItemEntityList, requestItemEntity, requestDataLoadCSVRecord, itemId, requestingInstitutionId);
            }
        }
        savingRequestItemEntities(requestItemEntityList);
        log.info("Total request item count not in db {}" ,barcodesNotInScsb.size());
        log.info("Total duplicate barcodes from las report{}", duplicateBarcodes.size());
        Map<String, Object> resultMap=new HashMap<>();
        resultMap.put(ScsbConstants.BARCODE_NOT_FOUND_IN_SCSB,barcodesNotInScsb);
        resultMap.put(ScsbConstants.REQUEST_INITIAL_BARCODES_AVAILABLE_IN_LAS,barcodesAvailableInLAS);
        resultMap.put(ScsbConstants.REQUEST_INITIAL_BARCODES_TO_INDEX,itemsToIndex);
        return resultMap;
    }

    private void prepareRequestItemEntities(List<RequestItemEntity> requestItemEntityList, RequestItemEntity requestItemEntity, RequestDataLoadCSVRecord requestDataLoadCSVRecord, Integer itemId, Integer requestingInstitutionId) throws ParseException {
        List<RequestItemEntity> requestAlreadyPlacedList = requestItemDetailsRepository.findByitemId(itemId,Arrays.asList(ScsbCommonConstants.REQUEST_STATUS_RETRIEVAL_ORDER_PLACED, ScsbCommonConstants.REQUEST_STATUS_RECALLED, ScsbCommonConstants.REQUEST_STATUS_EDD, ScsbCommonConstants.REQUEST_STATUS_INITIAL_LOAD));
        if (CollectionUtils.isEmpty(requestAlreadyPlacedList)) {
            requestItemEntity.setItemId(itemId);
            requestItemEntity.setRequestingInstitutionId(requestingInstitutionId);
            SimpleDateFormat formatter = new SimpleDateFormat(ScsbConstants.REQUEST_DATA_LOAD_DATE_FORMAT);
            requestItemEntity.setCreatedBy(ScsbConstants.REQUEST_DATA_LOAD_CREATED_BY);
            setValuesFromOutReportToRequestItemEntity(requestItemEntity, requestDataLoadCSVRecord, formatter);
            requestItemEntity.setRequestStatusId(9);
            requestItemEntity.setPatronId(ScsbConstants.REQUEST_DATA_LOAD_PATRON_ID);
            requestItemEntityList.add(requestItemEntity);
        }
    }

    private void setValuesFromOutReportToRequestItemEntity(RequestItemEntity requestItemEntity, RequestDataLoadCSVRecord requestDataLoadCSVRecord, SimpleDateFormat formatter) throws ParseException {
        requestItemEntity.setRequestTypeId(getRequestTypeId(requestDataLoadCSVRecord.getDeliveryMethod()));
        Date createdDate = getDateFormat(requestDataLoadCSVRecord.getCreatedDate());
        requestItemEntity.setCreatedDate(formatter.parse(formatter.format(createdDate)));
        Date updatedDate = getDateFormat(requestDataLoadCSVRecord.getLastUpdatedDate());
        requestItemEntity.setLastUpdatedDate(formatter.parse(formatter.format(updatedDate)));
        String stopCode=requestDataLoadCSVRecord.getStopCode() != null ? requestDataLoadCSVRecord.getStopCode() : "Stop Code Not Found";
        requestItemEntity.setStopCode(stopCode);
    }

    private void savingRequestItemEntities(List<RequestItemEntity> requestItemEntityList) {
        if (!CollectionUtils.isEmpty(requestItemEntityList)){
            List<RequestItemEntity> savedRequestItemEntities = requestItemDetailsRepository.saveAll(requestItemEntityList);
            requestItemDetailsRepository.flush();
            log.info("Total request item count saved in db {}", savedRequestItemEntities.size());
        }
    }

    private static Date getDateFormat(String date) throws ParseException {
        SimpleDateFormat formatter=new SimpleDateFormat(ScsbConstants.REQUEST_DATA_LOAD_DATE_FORMAT);
        if (StringUtils.isNotBlank(date)){
            return formatter.parse(date);
        }
        else {
            String currentDate = formatter.format(new Date());
            return formatter.parse(currentDate);
        }
    }

    private Map<String,Object> getItemInfo(String barcode, ItemStatusEntity itemStatusNotAvailableEntity){
        Integer itemId = 0;
        Integer owningInstitutionId = 0;
        Map<String,Object> itemInfo = new HashMap<>();
        List<ItemEntity> barcodesAvailableInLas=new ArrayList<>();
        List<ItemEntity> itemsToIndex=new ArrayList<>();
        List<ItemEntity> itemEntityList = itemDetailsRepository.findByBarcode(barcode);
        itemEntityList.stream()
                .filter(entity -> ScsbCommonConstants.AVAILABLE.equals(entity.getItemStatusEntity().getStatusCode()))
                .forEach(updateItemAsNotAvailableIfAny(itemStatusNotAvailableEntity,barcodesAvailableInLas,itemsToIndex));
        if(isNotEmpty(itemEntityList)){
            Integer itemInstitutionId = itemEntityList.get(0).getOwningInstitutionId();
            for(ItemEntity itemEntity : itemEntityList){
                if(itemEntity.getOwningInstitutionId().equals(itemInstitutionId)){
                    itemId = itemEntityList.get(0).getId();
                    owningInstitutionId = itemEntityList.get(0).getOwningInstitutionId();
                }else{
                    log.info("Barcodes duplicated in database with different institution {}",barcode);
                    return itemInfo;
                }
            }
            itemInfo.put(ScsbConstants.REQUEST_DATA_LOAD_ITEM_ID , itemId);
            itemInfo.put(ScsbConstants.REQUEST_DATA_LOAD_REQUESTING_INST_ID , owningInstitutionId);
            itemInfo.put(ScsbConstants.REQUEST_INITIAL_BARCODES_AVAILABLE_IN_LAS,barcodesAvailableInLas);
            itemInfo.put(ScsbConstants.REQUEST_INITIAL_BARCODES_TO_INDEX,itemsToIndex);
        }
        return itemInfo;
    }

    private Consumer<ItemEntity> updateItemAsNotAvailableIfAny(ItemStatusEntity itemNotAvailableEntity, List<ItemEntity> itemListAvailableInLAS, List<ItemEntity> itemsToIndex) {
        return itemEntity -> {
            if(requestInitialLoadGfaCheck){
                try {
                    String gfaItemStatus = gfaLasService.callGfaItemStatus(itemEntity.getBarcode());
                    gfaItemStatus = gfaLasService.getGfaItemStatusInUpperCase(gfaItemStatus);
                    boolean isImsItemStatusAvailable = commonUtil.checkIfImsItemStatusIsAvailableOrNotAvailable(itemEntity.getImsLocationEntity().getImsLocationCode(), gfaItemStatus, true);
                    if (!isImsItemStatusAvailable) {
                        saveItemAsNotAvailable(itemNotAvailableEntity, itemEntity);
                        itemsToIndex.add(itemEntity);
                    } else {
                        itemListAvailableInLAS.add(itemEntity);
                    }
                }
                catch (RuntimeException exception){
                    log.info("Exception Occurred while checking status for {} in LAS",itemEntity.getBarcode());
                    itemListAvailableInLAS.add(itemEntity);
                }
            }
            else {
                saveItemAsNotAvailable(itemNotAvailableEntity, itemEntity);
                itemsToIndex.add(itemEntity);
            }
        };
    }

    @Transactional
    public void saveItemAsNotAvailable(ItemStatusEntity itemNotAvailableEntity, ItemEntity itemEntity) {
        itemEntity.setItemAvailabilityStatusId(itemNotAvailableEntity.getId());
        itemEntity.setLastUpdatedDate(new Date());
        itemEntity.setLastUpdatedBy("SCSB");
        itemDetailsRepository.save(itemEntity);
    }

    private Integer getRequestTypeId(String deliveyMethod){
        Integer requestTypeId = 0;
        if(deliveyMethod.equalsIgnoreCase(ScsbConstants.REQUEST_DATA_LOAD_REQUEST_TYPE)){
            RequestTypeEntity requestTypeEntity = requestTypeDetailsRepository.findByrequestTypeCode(ScsbCommonConstants.RETRIEVAL);
            requestTypeId = requestTypeEntity.getId();
        }
        return requestTypeId;
    }

}
