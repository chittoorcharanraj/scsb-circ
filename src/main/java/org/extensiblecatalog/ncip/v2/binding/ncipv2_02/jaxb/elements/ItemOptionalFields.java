package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"bibliographicDescription", "itemUseRestrictionType", "circulationStatus", "holdQueueLength", "itemDescription",  "securityMarker",  "dateDue", "ext"}
)
@XmlRootElement(
        name = "ItemOptionalFields"
)
public class ItemOptionalFields {
    @XmlElement(
            name = "BibliographicDescription"
    )
    protected BibliographicDescription bibliographicDescription;
    @XmlElement(
            name = "ItemUseRestrictionType"
    )
    protected List<SchemeValuePair> itemUseRestrictionType;
    @XmlElement(
            name = "CirculationStatus"
    )
    protected SchemeValuePair circulationStatus;
    @XmlElement(
            name = "HoldQueueLength",
            type = String.class
    )
    protected BigDecimal holdQueueLength;
    @XmlElement(
            name = "ItemDescription"
    )
    protected ItemDescription itemDescription;
    @XmlElement(
            name = "SecurityMarker"
    )
    protected SchemeValuePair securityMarker;
    @XmlElement(
            name = "DateDue",
            type = String.class
    )
    protected XMLGregorianCalendar dateDue;

    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public ItemOptionalFields() {
    }

    public BibliographicDescription getBibliographicDescription() {
        return this.bibliographicDescription;
    }

    public void setBibliographicDescription(BibliographicDescription value) {
        this.bibliographicDescription = value;
    }

    public List<SchemeValuePair> getItemUseRestrictionType() {
        if (this.itemUseRestrictionType == null) {
            this.itemUseRestrictionType = new ArrayList();
        }

        return this.itemUseRestrictionType;
    }

    public SchemeValuePair getCirculationStatus() {
        return this.circulationStatus;
    }

    public void setCirculationStatus(SchemeValuePair value) {
        this.circulationStatus = value;
    }

    public BigDecimal getHoldQueueLength() {
        return this.holdQueueLength;
    }

    public void setHoldQueueLength(BigDecimal value) {
        this.holdQueueLength = value;
    }

    public ItemDescription getItemDescription() {
        return this.itemDescription;
    }

    public void setItemDescription(ItemDescription value) {
        this.itemDescription = value;
    }

    public SchemeValuePair getSecurityMarker() {
        return this.securityMarker;
    }

    public void setSecurityMarker(SchemeValuePair value) {
        this.securityMarker = value;
    }

    public XMLGregorianCalendar getDateDue() {
        return this.dateDue;
    }

    public void setDateDue(XMLGregorianCalendar value) {
        this.dateDue = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
