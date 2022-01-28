//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.service;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class UnstructuredAddress {
    protected String unstructuredAddressData;
    protected UnstructuredAddressType unstructuredAddressType;

    public UnstructuredAddress() {
    }

    public String getUnstructuredAddressData() {
        return this.unstructuredAddressData;
    }

    public void setUnstructuredAddressData(String unstructuredAddressData) {
        this.unstructuredAddressData = unstructuredAddressData;
    }

    public UnstructuredAddressType getUnstructuredAddressType() {
        return this.unstructuredAddressType;
    }

    public void setUnstructuredAddressType(UnstructuredAddressType unstructuredAddressType) {
        this.unstructuredAddressType = unstructuredAddressType;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
