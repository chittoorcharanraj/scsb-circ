package org.recap.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.CamelContext;
import org.recap.PropertyKeyConstants;
import org.recap.ScsbCommonConstants;
import org.recap.common.ScsbConstants;
import org.recap.ims.service.GFALasService;
import org.recap.mqconsumer.RequestItemQueueConsumer;
import org.recap.ims.processor.LasHeartBeatCheckPollingProcessor;
import org.recap.request.service.ItemEDDRequestService;
import org.recap.request.service.ItemRequestService;
import org.recap.util.CommonUtil;
import org.recap.util.PropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rajeshbabuk on 21/Jan/2021
 */

@RestController
@RequestMapping("/onboardInstitution")
@Slf4j
public class OnboardingInstitutionController {

    @Autowired
    private CamelContext camelContext;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private PropertyUtil propertyUtil;

    @Autowired
    private CommonUtil commonUtil;

    @Autowired
    private ItemRequestService itemRequestService;

    @Autowired
    private ItemEDDRequestService itemEDDRequestService;

    @GetMapping(value = "/createTopicsForNewInstitution")
    public String createTopicsForNewInstitution(@RequestParam String institutionCode) {
        String responseStatus = ScsbCommonConstants.SUCCESS;
        try {
            String retrievalInstitutionTopicUri = propertyUtil.getPropertyByInstitutionAndKey(institutionCode, PropertyKeyConstants.ILS.ILS_TOPIC_RETRIEVAL_REQUEST);
            String eddInstitutionTopicUri = propertyUtil.getPropertyByInstitutionAndKey(institutionCode, PropertyKeyConstants.ILS.ILS_TOPIC_EDD_REQUEST);
            String recallInstitutionTopicUri = propertyUtil.getPropertyByInstitutionAndKey(institutionCode, PropertyKeyConstants.ILS.ILS_TOPIC_RECALL_REQUEST);

            commonUtil.addRoutesToCamelContext(camelContext, retrievalInstitutionTopicUri, institutionCode + ScsbConstants.REQUEST_TOPIC_ROUTE_ID, "Message Received in Retrieval topic for " + institutionCode, new RequestItemQueueConsumer(institutionCode, itemRequestService, itemEDDRequestService), ScsbConstants.REQUEST_TOPIC_ROUTE_METHOD);
            commonUtil.addRoutesToCamelContext(camelContext, eddInstitutionTopicUri, institutionCode + ScsbConstants.EDD_TOPIC_ROUTE_ID, "Message Received in EDD topic for " + institutionCode, new RequestItemQueueConsumer(institutionCode, itemRequestService, itemEDDRequestService), ScsbConstants.EDD_TOPIC_ROUTE_METHOD);
            commonUtil.addRoutesToCamelContext(camelContext, recallInstitutionTopicUri, institutionCode + ScsbConstants.RECALL_TOPIC_ROUTE_ID, "Message Received in Recall topic for " + institutionCode, new RequestItemQueueConsumer(institutionCode, itemRequestService, itemEDDRequestService), ScsbConstants.RECALL_TOPIC_ROUTE_METHOD);
        } catch (Exception e) {
            log.error("Failed to create Topics for institution - {} : {}", institutionCode, e);
            responseStatus = ScsbCommonConstants.FAILURE;
        }
        return responseStatus;
    }

    @GetMapping(value = "/createQueuesForNewInstitution")
    public String createQueuesForNewImsLocation(@RequestParam String imsLocationCode) {
        String responseStatus = ScsbCommonConstants.SUCCESS;
        try {
            commonUtil.addRoutesToCamelContext(camelContext, ScsbConstants.SCSB_LAS_OUTGOING_QUEUE_PREFIX + imsLocationCode + ScsbConstants.OUTGOING_QUEUE_SUFFIX, imsLocationCode + ScsbConstants.SCSB_OUTGOING_ROUTE_ID, "Message Received in SCSB OUTGOING QUEUE for " + imsLocationCode, applicationContext.getBean(LasHeartBeatCheckPollingProcessor.class), ScsbConstants.SCSB_LAS_OUTGOING_QUEUE_METHOD);
            commonUtil.addRoutesToCamelContext(camelContext, ScsbConstants.LAS_OUTGOING_QUEUE_PREFIX + imsLocationCode + ScsbConstants.OUTGOING_QUEUE_SUFFIX, imsLocationCode + ScsbConstants.LAS_OUTGOING_ROUTE_ID, "Message Received in LAS OUTGOING QUEUE for " + imsLocationCode, applicationContext.getBean(GFALasService.class), ScsbConstants.LAS_OUTGOING_QUEUE_METHOD);
        } catch (Exception e) {
            log.error("Failed to create Queues for IMS Location - {} : {}", imsLocationCode, e);
            responseStatus = ScsbCommonConstants.FAILURE;
        }
        return responseStatus;
    }

}
