//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.service;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class StructuredAddress {
    protected String locationWithinBuilding;
    protected String houseName;
    protected String street;
    protected String postOfficeBox;
    protected String district;
    protected String line1;
    protected String line2;
    protected String locality;
    protected String region;
    protected String country;
    protected String postalCode;
    protected String careOf;

    public StructuredAddress() {
    }

    public String getLocationWithinBuilding() {
        return this.locationWithinBuilding;
    }

    public void setLocationWithinBuilding(String locationWithinBuilding) {
        this.locationWithinBuilding = locationWithinBuilding;
    }

    public String getHouseName() {
        return this.houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostOfficeBox() {
        return this.postOfficeBox;
    }

    public void setPostOfficeBox(String postOfficeBox) {
        this.postOfficeBox = postOfficeBox;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLine1() {
        return this.line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return this.line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getLocality() {
        return this.locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCareOf() {
        return this.careOf;
    }

    public void setCareOf(String careOf) {
        this.careOf = careOf;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
