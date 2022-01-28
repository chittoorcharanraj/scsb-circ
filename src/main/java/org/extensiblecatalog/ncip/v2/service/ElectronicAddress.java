package org.extensiblecatalog.ncip.v2.service;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ElectronicAddress {
    protected String electronicAddressData;
    protected ElectronicAddressType electronicAddressType;

    public ElectronicAddress() {
    }

    public String getElectronicAddressData() {
        return this.electronicAddressData;
    }

    public void setElectronicAddressData(String electronicAddressData) {
        this.electronicAddressData = electronicAddressData;
    }

    public ElectronicAddressType getElectronicAddressType() {
        return this.electronicAddressType;
    }

    public void setElectronicAddressType(ElectronicAddressType electronicAddressType) {
        this.electronicAddressType = electronicAddressType;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
