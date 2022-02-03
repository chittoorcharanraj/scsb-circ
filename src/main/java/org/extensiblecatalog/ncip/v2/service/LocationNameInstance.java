package org.extensiblecatalog.ncip.v2.service;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class LocationNameInstance {
    protected BigDecimal locationNameLevel;
    protected String locationNameValue;

    public LocationNameInstance() {
    }

    public BigDecimal getLocationNameLevel() {
        return this.locationNameLevel;
    }

    public void setLocationNameLevel(BigDecimal locationNameLevel) {
        this.locationNameLevel = locationNameLevel;
    }

    public String getLocationNameValue() {
        return this.locationNameValue;
    }

    public void setLocationNameValue(String locationNameValue) {
        this.locationNameValue = locationNameValue;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
