//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.service;

import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ItemOptionalFields {
    protected ItemDescription itemDescription;
    protected BibliographicDescription bibliographicDescription;
    protected BigDecimal holdQueueLength;
    protected List<ItemUseRestrictionType> itemUseRestrictionTypes;
    protected String holdQueue;
    protected Boolean sensitizationFlag = false;
    protected GregorianCalendar dateDue;

    public ItemOptionalFields() {
    }

    public ItemDescription getItemDescription() {
        return this.itemDescription;
    }

    public void setItemDescription(ItemDescription itemDescription) {
        this.itemDescription = itemDescription;
    }

    public BibliographicDescription getBibliographicDescription() {
        return this.bibliographicDescription;
    }

    public void setBibliographicDescription(BibliographicDescription bibliographicDescription) {
        this.bibliographicDescription = bibliographicDescription;
    }

    public BigDecimal getHoldQueueLength() {
        return this.holdQueueLength;
    }

    public void setHoldQueueLength(BigDecimal holdQueueLength) {
        this.holdQueueLength = holdQueueLength;
    }

    public String getHoldQueue() {
        return this.holdQueue;
    }

    public void setHoldQueue(String holdQueue) {
        this.holdQueue = holdQueue;
    }

    public List<ItemUseRestrictionType> getItemUseRestrictionTypes() {
        return this.itemUseRestrictionTypes;
    }

    public ItemUseRestrictionType getItemUseRestrictionType(int index) {
        return (ItemUseRestrictionType)this.itemUseRestrictionTypes.get(index);
    }

    public void setItemUseRestrictionTypes(List<ItemUseRestrictionType> itemUseRestrictionTypes) {
        this.itemUseRestrictionTypes = itemUseRestrictionTypes;
    }

    public boolean getSensitizationFlag() {
        return this.sensitizationFlag;
    }

    public void setSensitizationFlag(boolean sensitizationFlag) {
        this.sensitizationFlag = sensitizationFlag;
    }

    public GregorianCalendar getDateDue() {
        return this.dateDue;
    }

    public void setDateDue(GregorianCalendar dateDue) {
        this.dateDue = dateDue;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
