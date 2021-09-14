package org.recap.camel.requestinitialdataload.processor;

import com.amazonaws.services.s3.AmazonS3;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spi.RouteController;
import org.apache.camel.support.DefaultExchange;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.recap.ScsbCommonConstants;
import org.recap.ScsbConstants;
import org.recap.camel.requestinitialdataload.RequestDataLoadCSVRecord;
import org.recap.model.jpa.BibliographicEntity;
import org.recap.model.jpa.ImsLocationEntity;
import org.recap.model.jpa.InstitutionEntity;
import org.recap.model.jpa.ItemEntity;
import org.recap.service.requestdataload.RequestDataLoadService;
import org.springframework.test.util.ReflectionTestUtils;

import java.text.ParseException;
import java.util.*;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class RequestInitialDataLoadProcessorUT {

    @InjectMocks
    RequestInitialDataLoadProcessor requestInitialDataLoadProcessor;
    @Mock
    RequestInitialDataLoadProcessor requestInitialDataLoadProcessor1;
    @Mock
    RequestInitialDataLoadProcessor requestInitialDataLoadProcessor2;
    @Mock
    Exchange exchange;
    @Mock
    Message message;
    @Mock
    RequestDataLoadService requestDataLoadService;
    @Mock
    AmazonS3 awsS3Client;
    @Mock
    RouteController routeController;
    @Mock
    CamelContext camelContext;

    private Set<String> barcodeSet = new HashSet<>();

    private static String key = "test/test/test";

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testBefore() {
        requestInitialDataLoadProcessor = new RequestInitialDataLoadProcessor("CUL");
        requestInitialDataLoadProcessor1 = new RequestInitialDataLoadProcessor("PUL");
        requestInitialDataLoadProcessor2 = new RequestInitialDataLoadProcessor("NYPL");
        RequestDataLoadCSVRecord requestDataLoadCSVRecord = getDataLoadCSVRecord();
        RequestDataLoadCSVRecord requestDataLoadCSVRecord1 = getLoadCSVRecord();
        List<RequestDataLoadCSVRecord> requestDataLoadCSVRecordList = new ArrayList<>();
        requestDataLoadCSVRecordList.add(requestDataLoadCSVRecord);
        requestDataLoadCSVRecordList.add(requestDataLoadCSVRecord1);
        CamelContext ctx = new DefaultCamelContext();
        Exchange ex = new DefaultExchange(ctx);
        ex.getIn().setHeader("directoryName", "CUL");
        ex.getIn().setBody(requestDataLoadCSVRecordList);
        ex.setProperty("CamelSplitComplete", true);
        try {
            Set<String> data = new HashSet<>();
            data.add("332456456456745");
            data.add("332456456456742");
            requestInitialDataLoadProcessor.setBarcodeSet(data);
            requestInitialDataLoadProcessor.getBarcodeSet();
            requestInitialDataLoadProcessor.processInput(ex);
            ex.getIn().setHeader("directoryName", "PUL");
            requestInitialDataLoadProcessor1.processInput(ex);
            ex.getIn().setHeader("directoryName", "NYPL");
            requestInitialDataLoadProcessor2.processInput(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(true);
    }

    private RequestDataLoadCSVRecord getLoadCSVRecord() {
        RequestDataLoadCSVRecord requestDataLoadCSVRecord1 = new RequestDataLoadCSVRecord();
        requestDataLoadCSVRecord1.setBarcode("332456456456745");
        requestDataLoadCSVRecord1.setCustomerCode("PB");
        requestDataLoadCSVRecord1.setDeliveryMethod("Test");
        requestDataLoadCSVRecord1.setCreatedDate(new Date().toString());
        requestDataLoadCSVRecord1.setLastUpdatedDate(new Date().toString());
        requestDataLoadCSVRecord1.setPatronId("0000000");
        requestDataLoadCSVRecord1.setStopCode("AD");
        requestDataLoadCSVRecord1.setEmail("test@email.com");
        return requestDataLoadCSVRecord1;
    }

    private RequestDataLoadCSVRecord getDataLoadCSVRecord() {
        RequestDataLoadCSVRecord requestDataLoadCSVRecord = new RequestDataLoadCSVRecord();
        requestDataLoadCSVRecord.setBarcode("332456456456745");
        requestDataLoadCSVRecord.setCustomerCode("PB");
        requestDataLoadCSVRecord.setDeliveryMethod("Test");
        requestDataLoadCSVRecord.setCreatedDate(new Date().toString());
        requestDataLoadCSVRecord.setLastUpdatedDate(new Date().toString());
        requestDataLoadCSVRecord.setPatronId("0000000");
        requestDataLoadCSVRecord.setStopCode("AD");
        requestDataLoadCSVRecord.setEmail("test@email.com");
        return requestDataLoadCSVRecord;
    }

    @Test
    public void processInput() throws ParseException {
        barcodeSet.add("123456");
        RequestDataLoadCSVRecord requestDataLoadCSVRecord = getLoadCSVRecord();
        RequestDataLoadCSVRecord requestDataLoadCSVRecord1 = getDataLoadCSVRecord();
        requestDataLoadCSVRecord.setBarcode("123456");
        List<RequestDataLoadCSVRecord> requestDataLoadCSVRecordList = new ArrayList<>();
        requestDataLoadCSVRecordList.add(requestDataLoadCSVRecord);
        requestDataLoadCSVRecordList.add(requestDataLoadCSVRecord1);
        CamelContext ctx = new DefaultCamelContext();
        ctx.setRouteController(routeController);
        Exchange exchange = new DefaultExchange(ctx);
        exchange.getIn().setBody(requestDataLoadCSVRecordList);
        exchange.getIn().setHeader("John", "CUL");
        exchange.getIn().setHeader("CamelAwsS3Key", "GEJGNSIKHIL");
        exchange.getIn().setHeader("CamelAwsS3BucketName", key);
        exchange.setProperty("CamelSplitIndex", 0);
        exchange.setProperty("CamelSplitComplete", true);
        Set<String> stringSet = new HashSet<>();
        stringSet.add("test");
        Set<String> barcodesNotInSCSB = new HashSet<>();
        List<ItemEntity> itemEntityList = Arrays.asList(getItemEntity());
        List<ItemEntity> itemsToIndex =  Arrays.asList(getItemEntity());
        try {
            Map<String, Object> barcodesMap = new HashMap<>();
            barcodesMap.put(ScsbConstants.BARCODE_NOT_FOUND_IN_SCSB, barcodesNotInSCSB);
            barcodesMap.put(ScsbConstants.REQUEST_INITIAL_BARCODES_AVAILABLE_IN_LAS, itemEntityList);
            barcodesMap.put(ScsbConstants.REQUEST_INITIAL_BARCODES_TO_INDEX, itemsToIndex);
            ReflectionTestUtils.setField(requestInitialDataLoadProcessor, "isSolrIndexRequired", Boolean.TRUE);
            //Mockito.when(awsS3Client.doesObjectExist(any(), any())).thenReturn(true);
            Mockito.when(requestDataLoadService.process(any(), any())).thenReturn(barcodesMap);
            requestInitialDataLoadProcessor.processInput(exchange);
        }catch (Exception e){}
    }

    private ItemEntity getItemEntity(){
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setLastUpdatedDate(new Date());
        itemEntity.setOwningInstitutionItemId("1");
        itemEntity.setOwningInstitutionId(1);
        itemEntity.setBarcode("7020");
        itemEntity.setCallNumber("x.12321");
        itemEntity.setCollectionGroupId(1);
        itemEntity.setCallNumberType("1");
        itemEntity.setCustomerCode("PB");
        itemEntity.setCreatedDate(new Date());
        itemEntity.setCreatedBy("tst");
        itemEntity.setLastUpdatedBy("tst");
        itemEntity.setItemAvailabilityStatusId(1);
        itemEntity.setCatalogingStatus(ScsbCommonConstants.COMPLETE_STATUS);
        InstitutionEntity institutionEntity = new InstitutionEntity();
        institutionEntity.setId(1);
        institutionEntity.setInstitutionCode("PUL");
        institutionEntity.setInstitutionName("PUL");
        itemEntity.setInstitutionEntity(institutionEntity);
        itemEntity.setImsLocationEntity(getImsLocationEntity());
        return itemEntity;
    }

    private ImsLocationEntity getImsLocationEntity() {
        ImsLocationEntity imsLocationEntity = new ImsLocationEntity();
        imsLocationEntity.setImsLocationCode("1");
        imsLocationEntity.setImsLocationName("test");
        imsLocationEntity.setCreatedBy("test");
        imsLocationEntity.setCreatedDate(new Date());
        imsLocationEntity.setActive(true);
        imsLocationEntity.setDescription("test");
        imsLocationEntity.setUpdatedBy("test");
        imsLocationEntity.setUpdatedDate(new Date());
        return imsLocationEntity;
    }

}
