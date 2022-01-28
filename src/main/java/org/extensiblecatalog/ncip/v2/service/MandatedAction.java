package org.extensiblecatalog.ncip.v2.service;

import java.util.GregorianCalendar;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class MandatedAction {
    protected GregorianCalendar dateEventOccurred;

    public MandatedAction() {
    }

    public GregorianCalendar getDateEventOccurred() {
        return this.dateEventOccurred;
    }

    public void setDateEventOccurred(GregorianCalendar dateEventOccurred) {
        this.dateEventOccurred = dateEventOccurred;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
