package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"agencyId", "requestIdentifierType", "requestIdentifierValue", "ext"}
)
@XmlRootElement(
        name = "RequestId"
)
public class RequestId {
    @XmlElement(
            name = "AgencyId"
    )
    protected SchemeValuePair agencyId;
    @XmlElement(
            name = "RequestIdentifierType"
    )
    protected SchemeValuePair requestIdentifierType;
    @XmlElement(
            name = "RequestIdentifierValue",
            required = true
    )
    protected String requestIdentifierValue;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public RequestId() {
    }

    public SchemeValuePair getAgencyId() {
        return this.agencyId;
    }

    public void setAgencyId(SchemeValuePair value) {
        this.agencyId = value;
    }

    public SchemeValuePair getRequestIdentifierType() {
        return this.requestIdentifierType;
    }

    public void setRequestIdentifierType(SchemeValuePair value) {
        this.requestIdentifierType = value;
    }

    public String getRequestIdentifierValue() {
        return this.requestIdentifierValue;
    }

    public void setRequestIdentifierValue(String value) {
        this.requestIdentifierValue = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
