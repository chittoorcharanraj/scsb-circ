//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.service;

import java.util.GregorianCalendar;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class UserAddressInformation {
    protected UserAddressRoleType userAddressRoleType;
    protected GregorianCalendar validFromDate;
    protected GregorianCalendar validToDate;
    protected PhysicalAddress physicalAddress;
    protected ElectronicAddress electronicAddress;

    public UserAddressInformation() {
    }

    public UserAddressRoleType getUserAddressRoleType() {
        return this.userAddressRoleType;
    }

    public void setUserAddressRoleType(UserAddressRoleType userAddressRoleType) {
        this.userAddressRoleType = userAddressRoleType;
    }

    public GregorianCalendar getValidFromDate() {
        return this.validFromDate;
    }

    public void setValidFromDate(GregorianCalendar validFromDate) {
        this.validFromDate = validFromDate;
    }

    public GregorianCalendar getValidToDate() {
        return this.validToDate;
    }

    public void setValidToDate(GregorianCalendar validToDate) {
        this.validToDate = validToDate;
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
