package org.extensiblecatalog.ncip.v2.service;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class PhysicalAddress {
    protected StructuredAddress structuredAddress;
    protected UnstructuredAddress unstructuredAddress;
    protected PhysicalAddressType physicalAddressType;

    public PhysicalAddress() {
    }

    public StructuredAddress getStructuredAddress() {
        return this.structuredAddress;
    }

    public void setStructuredAddress(StructuredAddress structuredAddress) {
        this.structuredAddress = structuredAddress;
    }

    public UnstructuredAddress getUnstructuredAddress() {
        return this.unstructuredAddress;
    }

    public void setUnstructuredAddress(UnstructuredAddress unstructuredAddress) {
        this.unstructuredAddress = unstructuredAddress;
    }

    public PhysicalAddressType getPhysicalAddressType() {
        return this.physicalAddressType;
    }

    public void setPhysicalAddressType(PhysicalAddressType physicalAddressType) {
        this.physicalAddressType = physicalAddressType;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
