package org.extensiblecatalog.ncip.v2.service;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public final class ItemId {
    private static final long serialVersionUID = 4389080391314069789L;
    protected String itemIdentifierValue;
    protected AgencyId agencyId;
    protected ItemIdentifierType itemIdentifierType;

    public ItemId() {
    }

    public void setItemIdentifierValue(String itemIdentifierValue) {
        this.itemIdentifierValue = itemIdentifierValue;
    }

    public String getItemIdentifierValue() {
        return this.itemIdentifierValue;
    }

    public void setItemIdentifierType(ItemIdentifierType itemIdentifierType) {
        this.itemIdentifierType = itemIdentifierType;
    }

    public ItemIdentifierType getItemIdentifierType() {
        return this.itemIdentifierType;
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
