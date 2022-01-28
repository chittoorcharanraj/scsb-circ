package org.extensiblecatalog.ncip.v2.service;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class NCIPMessage {
    protected NCIPMessage.MessageType messageType;
    protected String version;
    protected AcceptItemInitiationData acceptItem;
    protected AcceptItemResponseData acceptItemResponse;
    protected CancelRequestItemInitiationData cancelRequestItem;
    protected CancelRequestItemResponseData cancelRequestItemResponse;
    protected CheckInItemInitiationData checkInItem;
    protected CheckInItemResponseData checkInItemResponse;
    protected CheckOutItemInitiationData checkOutItem;
    protected CheckOutItemResponseData checkOutItemResponse;
    protected LookupUserInitiationData lookupUser;
    protected LookupUserResponseData lookupUserResponse;
    protected RecallItemInitiationData recallItem;
    protected RecallItemResponseData recallItemResponse;
    protected ProblemResponseData problemResponse;

    public NCIPMessage() {
        this.messageType = NCIPMessage.MessageType.UNKNOWN;
    }

    public boolean isInitiationMessage() {
        return this.messageType == NCIPMessage.MessageType.INITIATION;
    }

    public boolean isResponseMessage() {
        return this.messageType == NCIPMessage.MessageType.RESPONSE;
    }

    public NCIPInitiationData getInitiationData() throws InvocationTargetException, IllegalAccessException, ServiceException {
        NCIPData ncipData = ReflectionHelper.unwrapFirstNonNullNCIPDataFieldViaGetter(this);
        if (ncipData instanceof NCIPInitiationData) {
            NCIPInitiationData initData = (NCIPInitiationData)ncipData;
            return initData;
        } else {
            throw new ServiceException(ServiceError.INVALID_MESSAGE_FORMAT, "Initiation message not a recognized type. (Found '" + ncipData.getClass().getSimpleName() + "'.)");
        }
    }

    public NCIPResponseData getResponseData() throws InvocationTargetException, IllegalAccessException, ServiceException {
        NCIPData ncipData = ReflectionHelper.unwrapFirstNonNullNCIPDataFieldViaGetter(this);
        if (ncipData instanceof NCIPResponseData) {
            NCIPResponseData respData = (NCIPResponseData)ncipData;
            return respData;
        } else {
            throw new ServiceException(ServiceError.INVALID_MESSAGE_FORMAT, "Response message not a recognized type. (Found '" + ncipData.getClass().getSimpleName() + "'.)");
        }
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public AcceptItemInitiationData getAcceptItem() {
        return this.acceptItem;
    }

    public void setAcceptItem(AcceptItemInitiationData acceptItem) {
        this.acceptItem = acceptItem;
    }

    public AcceptItemResponseData getAcceptItemResponse() {
        return this.acceptItemResponse;
    }

    public void setAcceptItemResponse(AcceptItemResponseData acceptItemResponse) {
        this.acceptItemResponse = acceptItemResponse;
    }

    public CancelRequestItemInitiationData getCancelRequestItem() {
        return this.cancelRequestItem;
    }

    public void setCancelRequestItem(CancelRequestItemInitiationData cancelRequestItem) {
        this.cancelRequestItem = cancelRequestItem;
    }

    public CancelRequestItemResponseData getCancelRequestItemResponse() {
        return this.cancelRequestItemResponse;
    }

    public void setCancelRequestItemResponse(CancelRequestItemResponseData cancelRequestItemResponse) {
        this.cancelRequestItemResponse = cancelRequestItemResponse;
    }

    public CheckInItemInitiationData getCheckInItem() {
        return this.checkInItem;
    }

    public void setCheckInItem(CheckInItemInitiationData checkInItem) {
        this.checkInItem = checkInItem;
    }

    public CheckInItemResponseData getCheckInItemResponse() {
        return this.checkInItemResponse;
    }

    public void setCheckInItemResponse(CheckInItemResponseData checkInItemResponse) {
        this.checkInItemResponse = checkInItemResponse;
    }

    public CheckOutItemInitiationData getCheckOutItem() {
        return this.checkOutItem;
    }

    public void setCheckOutItem(CheckOutItemInitiationData checkOutItem) {
        this.checkOutItem = checkOutItem;
    }

    public CheckOutItemResponseData getCheckOutItemResponse() {
        return this.checkOutItemResponse;
    }

    public void setCheckOutItemResponse(CheckOutItemResponseData checkOutItemResponse) {
        this.checkOutItemResponse = checkOutItemResponse;
    }

    public LookupUserInitiationData getLookupUser() {
        return this.lookupUser;
    }

    public void setLookupUser(LookupUserInitiationData lookupUser) {
        this.lookupUser = lookupUser;
    }

    public LookupUserResponseData getLookupUserResponse() {
        return this.lookupUserResponse;
    }

    public void setLookupUserResponse(LookupUserResponseData lookupUserResponse) {
        this.lookupUserResponse = lookupUserResponse;
    }

    public RecallItemInitiationData getRecallItem() {
        return this.recallItem;
    }

    public void setRecallItem(RecallItemInitiationData recallItem) {
        this.recallItem = recallItem;
    }

    public RecallItemResponseData getRecallItemResponse() {
        return this.recallItemResponse;
    }

    public void setRecallItemResponse(RecallItemResponseData recallItemResponse) {
        this.recallItemResponse = recallItemResponse;
    }


    public ProblemResponseData getProblemResponse() {
        return this.problemResponse;
    }

    public void setProblemResponse(ProblemResponseData problemResponse) {
        this.problemResponse = problemResponse;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }

    public static enum MessageType {
        UNKNOWN,
        INITIATION,
        RESPONSE;

        private MessageType() {
        }
    }
}
