package org.extensiblecatalog.ncip.v2.service;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ShippingInformation {
    protected String shippingInstructions;
    protected String shippingNote;
    protected PhysicalAddress physicalAddress;
    protected ElectronicAddress electronicAddress;

    public ShippingInformation() {
    }

    public String getShippingInstructions() {
        return this.shippingInstructions;
    }

    public void setShippingInstructions(String shippingInstructions) {
        this.shippingInstructions = shippingInstructions;
    }

    public String getShippingNote() {
        return this.shippingNote;
    }

    public void setShippingNote(String shippingNote) {
        this.shippingNote = shippingNote;
    }

    public PhysicalAddress getPhysicalAddress() {
        return this.physicalAddress;
    }

    public void setPhysicalAddress(PhysicalAddress physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public ElectronicAddress getElectronicAddress() {
        return this.electronicAddress;
    }

    public void setElectronicAddress(ElectronicAddress electronicAddress) {
        this.electronicAddress = electronicAddress;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
