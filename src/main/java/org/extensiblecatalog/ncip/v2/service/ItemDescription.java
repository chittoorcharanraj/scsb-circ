package org.extensiblecatalog.ncip.v2.service;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ItemDescription {
    protected String callNumber;
    protected String copyNumber;
    protected BigDecimal numberOfPieces;

    public ItemDescription() {
    }

    public String getCallNumber() {
        return this.callNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    public String getCopyNumber() {
        return this.copyNumber;
    }

    public void setCopyNumber(String copyNumber) {
        this.copyNumber = copyNumber;
    }

    public BigDecimal getNumberOfPieces() {
        return this.numberOfPieces;
    }

    public void setNumberOfPieces(BigDecimal numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
