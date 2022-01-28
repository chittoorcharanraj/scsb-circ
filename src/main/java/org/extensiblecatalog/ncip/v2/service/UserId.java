package org.extensiblecatalog.ncip.v2.service;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public final class UserId {
    protected AgencyId agencyId;
    protected UserIdentifierType userIdentifierType;
    protected String userIdentifierValue;

    public UserId() {
    }

    public AgencyId getAgencyId() {
        return this.agencyId;
    }

    public void setAgencyId(AgencyId agencyId) {
        this.agencyId = agencyId;
    }

    public UserIdentifierType getUserIdentifierType() {
        return this.userIdentifierType;
    }

    public void setUserIdentifierType(UserIdentifierType userIdentifierType) {
        this.userIdentifierType = userIdentifierType;
    }

    public String getUserIdentifierValue() {
        return this.userIdentifierValue;
    }

    public void setUserIdentifierValue(String userIdentifierValue) {
        this.userIdentifierValue = userIdentifierValue;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
