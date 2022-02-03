package org.extensiblecatalog.ncip.v2.service;

import java.util.GregorianCalendar;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Location {
    protected LocationName locationName;
    protected LocationType locationType;
    protected GregorianCalendar validFromDate;
    protected GregorianCalendar validToDate;

    public Location() {
    }

    public LocationName getLocationName() {
        return this.locationName;
    }

    public void setLocationName(LocationName locationName) {
        this.locationName = locationName;
    }

    public LocationType getLocationType() {
        return this.locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
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

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
