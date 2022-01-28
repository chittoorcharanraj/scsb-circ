package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CancelRequestItemResponseData implements NCIPResponseData {
    protected String version;
    protected ResponseHeader responseHeader;
    protected List<Problem> problems;
    protected ItemId itemId;
    protected RequestId requestId;
    protected UserId userId;
    protected ItemOptionalFields itemOptionalFields;
    protected UserOptionalFields userOptionalFields;

    public CancelRequestItemResponseData() {
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public ResponseHeader getResponseHeader() {
        return this.responseHeader;
    }

    public void setProblems(List<Problem> problems) {
        this.problems = problems;
    }

    public List<Problem> getProblems() {
        return this.problems;
    }

    public void setItemId(ItemId itemId) {
        this.itemId = itemId;
    }

    public ItemId getItemId() {
        return this.itemId;
    }

    public void setRequestId(RequestId requestId) {
        this.requestId = requestId;
    }

    public RequestId getRequestId() {
        return this.requestId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public UserId getUserId() {
        return this.userId;
    }

    public void setItemOptionalFields(ItemOptionalFields itemOptionalFields) {
        this.itemOptionalFields = itemOptionalFields;
    }

    public ItemOptionalFields getItemOptionalFields() {
        return this.itemOptionalFields;
    }

    public void setUserOptionalFields(UserOptionalFields userOptionalFields) {
        this.userOptionalFields = userOptionalFields;
    }

    public UserOptionalFields getUserOptionalFields() {
        return this.userOptionalFields;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
