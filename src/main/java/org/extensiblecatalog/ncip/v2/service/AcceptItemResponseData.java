//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class AcceptItemResponseData implements NCIPResponseData {
    protected String version;
    protected ResponseHeader responseHeader;
    protected List<Problem> problems;
    protected RequestId requestId;
    protected ItemId itemId;

    public AcceptItemResponseData() {
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

    public RequestId getRequestId() {
        return this.requestId;
    }

    public void setRequestId(RequestId requestId) {
        this.requestId = requestId;
    }

    public ItemId getItemId() {
        return this.itemId;
    }

    public void setItemId(ItemId itemId) {
        this.itemId = itemId;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
