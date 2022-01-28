//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.service;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public final class RequestId {
    private static final long serialVersionUID = 4389080391314069789L;
    protected String requestIdentifierValue;
    protected AgencyId agencyId;
    protected RequestIdentifierType requestIdentifierType;

    public RequestId() {
    }

    public void setRequestIdentifierValue(String requestIdentifierValue) {
        this.requestIdentifierValue = requestIdentifierValue;
    }

    public String getRequestIdentifierValue() {
        return this.requestIdentifierValue;
    }

    public void setRequestIdentifierType(RequestIdentifierType requestIdentifierType) {
        this.requestIdentifierType = requestIdentifierType;
    }

    public RequestIdentifierType getRequestIdentifierType() {
        return this.requestIdentifierType;
    }

    public void setAgencyId(AgencyId agencyId) {
        this.agencyId = agencyId;
    }

    public AgencyId getAgencyId() {
        return this.agencyId;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
