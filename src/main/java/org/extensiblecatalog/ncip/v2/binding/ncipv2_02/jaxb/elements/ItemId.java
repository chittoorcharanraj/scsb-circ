package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"agencyId", "itemIdentifierType", "itemIdentifierValue", "ext"}
)
@XmlRootElement(
        name = "ItemId"
)
public class ItemId {
    @XmlElement(
            name = "AgencyId"
    )
    protected SchemeValuePair agencyId;
    @XmlElement(
            name = "ItemIdentifierType"
    )
    protected SchemeValuePair itemIdentifierType;
    @XmlElement(
            name = "ItemIdentifierValue",
            required = true
    )
    protected String itemIdentifierValue;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public ItemId() {
    }

    public SchemeValuePair getAgencyId() {
        return this.agencyId;
    }

    public void setAgencyId(SchemeValuePair value) {
        this.agencyId = value;
    }

    public SchemeValuePair getItemIdentifierType() {
        return this.itemIdentifierType;
    }

    public void setItemIdentifierType(SchemeValuePair value) {
        this.itemIdentifierType = value;
    }

    public String getItemIdentifierValue() {
        return this.itemIdentifierValue;
    }

    public void setItemIdentifierValue(String value) {
        this.itemIdentifierValue = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
