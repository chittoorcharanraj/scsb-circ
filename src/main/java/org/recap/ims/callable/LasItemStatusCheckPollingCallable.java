package org.recap.ims.callable;

import lombok.extern.slf4j.Slf4j;
import org.recap.common.ScsbConstants;
import org.recap.ims.connector.factory.LASImsLocationConnectorFactory;
import org.recap.ims.model.GFAItemStatus;
import org.recap.ims.model.GFAItemStatusCheckRequest;
import org.recap.model.gfa.GFAItemStatusCheckResponse;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@Slf4j
public class LasItemStatusCheckPollingCallable implements Callable {



    private static String barcode;
    private String imsLocationCode;
    private LASImsLocationConnectorFactory lasImsLocationConnectorFactory;
    private Integer pollingTimeInterval;


    public LasItemStatusCheckPollingCallable(Integer pollingTimeInterval, LASImsLocationConnectorFactory lasImsLocationConnectorFactory, String barcode, String imsLocationCode) {
        this.lasImsLocationConnectorFactory = lasImsLocationConnectorFactory;
        this.pollingTimeInterval = pollingTimeInterval;
        this.barcode = barcode;
        this.imsLocationCode = imsLocationCode;
    }

    @Override
    public GFAItemStatusCheckResponse call() throws Exception {
        return poll();
    }

    private GFAItemStatusCheckResponse poll() throws Exception {
        GFAItemStatusCheckResponse gfaItemStatusCheckResponse = null;
        GFAItemStatusCheckRequest gfaItemStatusCheckRequest = new GFAItemStatusCheckRequest();
        //Pol ItemRequest Rest Service
        GFAItemStatus gfaItemStatus001 = new GFAItemStatus();
        gfaItemStatus001.setItemBarCode(barcode);
        List<GFAItemStatus> gfaItemStatuses = new ArrayList<>();
        gfaItemStatuses.add(gfaItemStatus001);
        gfaItemStatusCheckRequest.setItemStatus(gfaItemStatuses);
        try {
            gfaItemStatusCheckResponse = lasImsLocationConnectorFactory.getLasImsLocationConnector(imsLocationCode).itemStatusCheck(gfaItemStatusCheckRequest);
            log.info("Item Status Check Polling -> {}", gfaItemStatusCheckResponse);
            if (gfaItemStatusCheckResponse == null) {
                Thread.sleep(pollingTimeInterval);
                log.info("LAS Item Status Check Polling");
                gfaItemStatusCheckResponse = poll();
            }
            ScsbConstants.LAS_ITEM_STATUS_REST_SERVICE_STATUS = 0;
        } catch (Exception e) {
            log.error("", e);
        }
        return gfaItemStatusCheckResponse;
    }

    public static String getBarcode() {
        return barcode;
    }

    public static void setBarcode(String barcode) {
        LasItemStatusCheckPollingCallable.barcode = barcode;
    }
}
