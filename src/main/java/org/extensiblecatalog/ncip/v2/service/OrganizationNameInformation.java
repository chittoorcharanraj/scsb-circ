package org.extensiblecatalog.ncip.v2.service;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class OrganizationNameInformation {
    protected OrganizationNameType organizationNameType;
    protected String organizationName;

    public OrganizationNameInformation() {
    }

    public OrganizationNameType getOrganizationNameType() {
        return this.organizationNameType;
    }

    public void setOrganizationNameType(OrganizationNameType organizationNameType) {
        this.organizationNameType = organizationNameType;
    }

    public String getOrganizationName() {
        return this.organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
