package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"agencyId", "userIdentifierType", "userIdentifierValue", "ext"}
)
@XmlRootElement(
        name = "UserId"
)
public class UserId {
    @XmlElement(
            name = "AgencyId"
    )
    protected SchemeValuePair agencyId;
    @XmlElement(
            name = "UserIdentifierType"
    )
    protected SchemeValuePair userIdentifierType;
    @XmlElement(
            name = "UserIdentifierValue",
            required = true
    )
    protected String userIdentifierValue;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public UserId() {
    }

    public SchemeValuePair getAgencyId() {
        return this.agencyId;
    }

    public void setAgencyId(SchemeValuePair value) {
        this.agencyId = value;
    }

    public SchemeValuePair getUserIdentifierType() {
        return this.userIdentifierType;
    }

    public void setUserIdentifierType(SchemeValuePair value) {
        this.userIdentifierType = value;
    }

    public String getUserIdentifierValue() {
        return this.userIdentifierValue;
    }

    public void setUserIdentifierValue(String value) {
        this.userIdentifierValue = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
