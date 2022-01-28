package org.extensiblecatalog.ncip.v2.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ToAgencyId {
    protected List<AgencyId> agencyIds = new ArrayList<>();

    public ToAgencyId() {
    }

    public void setAgencyId(AgencyId agencyId) {
        this.agencyIds.add(agencyId);
    }

    public void setAgencyIds(List<AgencyId> agencyIds) {
        this.agencyIds = agencyIds;
    }

    public AgencyId getAgencyId() {
        return this.agencyIds.size() > 0 ? this.agencyIds.get(0) : null;
    }

    public List<AgencyId> getAgencyIds() {
        return this.agencyIds;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
