package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CheckInItemResponseData implements NCIPResponseData {
    protected String version;
    protected ResponseHeader responseHeader;
    protected List<Problem> problems;
    protected ItemId itemId;
    protected UserId userId;
    protected ItemOptionalFields itemOptionalFields;
    protected UserOptionalFields userOptionalFields;

    public CheckInItemResponseData() {
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ResponseHeader getResponseHeader() {
        return this.responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public List<Problem> getProblems() {
        return this.problems;
    }

    public Problem getProblem(int index) {
        return (Problem)this.problems.get(index);
    }

    public void setProblems(List<Problem> problems) {
        this.problems = problems;
    }

    public ItemId getItemId() {
        return this.itemId;
    }

    public void setItemId(ItemId itemId) {
        this.itemId = itemId;
    }

    public UserId getUserId() {
        return this.userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public ItemOptionalFields getItemOptionalFields() {
        return this.itemOptionalFields;
    }

    public void setItemOptionalFields(ItemOptionalFields itemOptionalFields) {
        this.itemOptionalFields = itemOptionalFields;
    }

    public UserOptionalFields getUserOptionalFields() {
        return this.userOptionalFields;
    }

    public void setUserOptionalFields(UserOptionalFields userOptionalFields) {
        this.userOptionalFields = userOptionalFields;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
