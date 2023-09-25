package org.recap.routebuilder;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.recap.PropertyKeyConstants;
import org.recap.ScsbCommonConstants;
import org.recap.common.ScsbConstants;
import org.recap.camel.route.StartRouteProcessor;
import org.recap.ims.service.GFALasService;
import org.recap.mqconsumer.RequestItemQueueConsumer;
import org.recap.ims.processor.LasHeartBeatCheckPollingProcessor;
import org.recap.request.service.BulkItemRequestProcessService;
import org.recap.request.service.BulkItemRequestService;
import org.recap.request.service.ItemEDDRequestService;
import org.recap.request.service.ItemRequestService;
import org.recap.util.CommonUtil;
import org.recap.util.PropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by sudhishk on 2/12/16.
 */
@Slf4j
@Component
public class RequestItemRouteBuilder {



    /**
     * Instantiates a new Request item route builder.
     *
     * @param camelContext          the camel context
     * @param itemRequestService    the item request service
     * @param itemEDDRequestService the item edd request service
     */
    @Autowired
    public RequestItemRouteBuilder(@Value("${bulk.request.concurrent.consumer.count}") Integer bulkRequestConsumerCount, CamelContext camelContext, ApplicationContext applicationContext, ItemRequestService itemRequestService, ItemEDDRequestService itemEDDRequestService, BulkItemRequestService bulkItemRequestService, BulkItemRequestProcessService bulkItemRequestProcessService, PropertyUtil propertyUtil, CommonUtil commonUtil) {
        try {
            camelContext.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from(ScsbConstants.REQUEST_ITEM_QUEUE)
                            .routeId(ScsbConstants.REQUEST_ITEM_QUEUE_ROUTEID)
                            .threads(30, 50)
                            .choice()
                            .when(header(ScsbCommonConstants.REQUEST_TYPE_QUEUE_HEADER).isEqualTo(ScsbCommonConstants.REQUEST_TYPE_RETRIEVAL))
                            .bean(new RequestItemQueueConsumer(itemRequestService), ScsbConstants.REQUEST_ITEM_QUEUE_RETRIEVAL_METHOD)
                            .when(header(ScsbCommonConstants.REQUEST_TYPE_QUEUE_HEADER).isEqualTo(ScsbCommonConstants.REQUEST_TYPE_EDD))
                            .bean(new RequestItemQueueConsumer(itemEDDRequestService), ScsbConstants.REQUEST_ITEM_QUEUE_EDD_METHOD)
                            .when(header(ScsbCommonConstants.REQUEST_TYPE_QUEUE_HEADER).isEqualTo(ScsbCommonConstants.REQUEST_TYPE_RECALL))
                            .bean(new RequestItemQueueConsumer(itemRequestService), ScsbConstants.REQUEST_ITEM_QUEUE_RECALL_METHOD);
                }
            });

            for (String imsLocationCode : commonUtil.findAllImsLocationCodeExceptUN()) {
                commonUtil.addRoutesToCamelContext(camelContext, ScsbConstants.SCSB_LAS_OUTGOING_QUEUE_PREFIX + imsLocationCode + ScsbConstants.OUTGOING_QUEUE_SUFFIX, imsLocationCode + ScsbConstants.SCSB_OUTGOING_ROUTE_ID, "Message Received in SCSB OUTGOING QUEUE for " + imsLocationCode, applicationContext.getBean(LasHeartBeatCheckPollingProcessor.class), ScsbConstants.SCSB_LAS_OUTGOING_QUEUE_METHOD);
                commonUtil.addRoutesToCamelContext(camelContext, ScsbConstants.LAS_OUTGOING_QUEUE_PREFIX + imsLocationCode + ScsbConstants.OUTGOING_QUEUE_SUFFIX, imsLocationCode + ScsbConstants.LAS_OUTGOING_ROUTE_ID, "Message Received in LAS OUTGOING QUEUE for " + imsLocationCode, applicationContext.getBean(GFALasService.class), ScsbConstants.LAS_OUTGOING_QUEUE_METHOD);
            }

            camelContext.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from(ScsbConstants.LAS_INCOMING_QUEUE)
                            .routeId(ScsbConstants.LAS_INCOMING_ROUTE_ID)
                            .choice()
                            .when(header(ScsbCommonConstants.REQUEST_TYPE_QUEUE_HEADER).isEqualTo(ScsbCommonConstants.REQUEST_TYPE_RETRIEVAL))
                            .bean(new RequestItemQueueConsumer(itemRequestService), ScsbConstants.LAS_INCOMING_QUEUE_RETRIEVAL_METHOD)
                            .when(header(ScsbCommonConstants.REQUEST_TYPE_QUEUE_HEADER).isEqualTo(ScsbCommonConstants.REQUEST_TYPE_EDD))
                            .bean(new RequestItemQueueConsumer(itemRequestService), ScsbConstants.LAS_INCOMING_QUEUE_EDD_METHOD)
                            .when(header(ScsbCommonConstants.REQUEST_TYPE_QUEUE_HEADER).isEqualTo(ScsbConstants.REQUEST_TYPE_PW_INDIRECT))
                            .bean(new RequestItemQueueConsumer(itemRequestService), ScsbConstants.LAS_INCOMING_QUEUE_PWI_METHOD)
                            .when(header(ScsbCommonConstants.REQUEST_TYPE_QUEUE_HEADER).isEqualTo(ScsbConstants.REQUEST_TYPE_PW_DIRECT))
                            .bean(new RequestItemQueueConsumer(itemRequestService), ScsbConstants.LAS_INCOMING_QUEUE_PWD_METHOD);
                }
            });

            commonUtil.addRoutesToCamelContext(camelContext, ScsbCommonConstants.BULK_REQUEST_ITEM_QUEUE, ScsbConstants.BULK_REQUEST_ITEM_QUEUE_ROUTEID, "Message Received in BULK REQUEST ITEM QUEUE", new RequestItemQueueConsumer(bulkItemRequestService), ScsbConstants.BULK_REQUEST_ITEM_QUEUE_METHOD);
            commonUtil.addRoutesToCamelContext(camelContext, ScsbConstants.BULK_REQUEST_ITEM_PROCESSING_QUEUE + ScsbConstants.ASYNC_CONCURRENT_CONSUMERS + bulkRequestConsumerCount, ScsbConstants.BULK_REQUEST_ITEM_PROCESSING_QUEUE_ROUTEID, "Message Received in BULK REQUEST ITEM PROCESSING QUEUE", new RequestItemQueueConsumer(bulkItemRequestProcessService), ScsbConstants.BULK_REQUEST_ITEM_PROCESSING_QUEUE_METHOD);

            camelContext.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from(ScsbConstants.REQUEST_ITEM_LAS_STATUS_CHECK_QUEUE)
                            .routeId(ScsbConstants.REQUEST_ITEM_LAS_STATUS_CHECK_QUEUE_ROUTEID)
                            .noAutoStartup()
                            .choice()
                            .when(body().isNull())
                            .log("No Requests To Process")
                            .otherwise()
                            .log("Start Route 1")
                            .process(new StartRouteProcessor(ScsbConstants.REQUEST_ITEM_LAS_STATUS_CHECK_QUEUE_ROUTEID))
                            .bean(new RequestItemQueueConsumer(itemRequestService), ScsbConstants.REQUEST_ITEM_LAS_ITEM_STATUS_QUEUE_METHOD)
                            .endChoice();
                }
            });

            for (String institutionCode : commonUtil.findAllInstitutionCodesExceptSupportInstitution()) {
                String retrievalInstitutionTopicUri = propertyUtil.getPropertyByInstitutionAndKey(institutionCode, PropertyKeyConstants.ILS.ILS_TOPIC_RETRIEVAL_REQUEST);
                String eddInstitutionTopicUri = propertyUtil.getPropertyByInstitutionAndKey(institutionCode, PropertyKeyConstants.ILS.ILS_TOPIC_EDD_REQUEST);
                String recallInstitutionTopicUri = propertyUtil.getPropertyByInstitutionAndKey(institutionCode, PropertyKeyConstants.ILS.ILS_TOPIC_RECALL_REQUEST);

                commonUtil.addRoutesToCamelContext(camelContext, retrievalInstitutionTopicUri, institutionCode + ScsbConstants.REQUEST_TOPIC_ROUTE_ID, "Message Received in Retrieval topic for " + institutionCode, new RequestItemQueueConsumer(institutionCode, itemRequestService, itemEDDRequestService), ScsbConstants.REQUEST_TOPIC_ROUTE_METHOD);
                commonUtil.addRoutesToCamelContext(camelContext, eddInstitutionTopicUri, institutionCode + ScsbConstants.EDD_TOPIC_ROUTE_ID, "Message Received in EDD topic for " + institutionCode, new RequestItemQueueConsumer(institutionCode, itemRequestService, itemEDDRequestService), ScsbConstants.EDD_TOPIC_ROUTE_METHOD);
                commonUtil.addRoutesToCamelContext(camelContext, recallInstitutionTopicUri, institutionCode + ScsbConstants.RECALL_TOPIC_ROUTE_ID, "Message Received in Recall topic for " + institutionCode, new RequestItemQueueConsumer(institutionCode, itemRequestService, itemEDDRequestService), ScsbConstants.RECALL_TOPIC_ROUTE_METHOD);
            }

        } catch (Exception e) {
            log.error(ScsbCommonConstants.REQUEST_EXCEPTION, e);
        }
    }

}
