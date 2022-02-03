package org.extensiblecatalog.ncip.v2.service;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Destination {
    protected Location location;
    protected String binNumber;

    public Destination() {
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getBinNumber() {
        return this.binNumber;
    }

    public void setBinNumber(String binNumber) {
        this.binNumber = binNumber;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
