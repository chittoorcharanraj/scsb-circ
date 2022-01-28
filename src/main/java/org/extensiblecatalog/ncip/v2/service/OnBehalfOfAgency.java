package org.extensiblecatalog.ncip.v2.service;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class OnBehalfOfAgency {
    protected AgencyId agencyId;

    public OnBehalfOfAgency() {
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
