package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

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
        propOrder = {"agencyId", "userIdentifierValue", "validFromDate", "validToDate", "ext"}
)
@XmlRootElement(
        name = "PreviousUserId"
)
public class PreviousUserId {
    @XmlElement(
            name = "AgencyId",
            required = true
    )
    protected SchemeValuePair agencyId;
    @XmlElement(
            name = "UserIdentifierValue",
            required = true
    )
    protected String userIdentifierValue;
    @XmlElement(
            name = "ValidFromDate",
            type = String.class
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    @XmlSchemaType(
            name = "dateTime"
    )
    protected XMLGregorianCalendar validFromDate;
    @XmlElement(
            name = "ValidToDate",
            type = String.class
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    @XmlSchemaType(
            name = "dateTime"
    )
    protected XMLGregorianCalendar validToDate;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public PreviousUserId() {
    }

    public SchemeValuePair getAgencyId() {
        return this.agencyId;
    }

    public void setAgencyId(SchemeValuePair value) {
        this.agencyId = value;
    }

    public String getUserIdentifierValue() {
        return this.userIdentifierValue;
    }

    public void setUserIdentifierValue(String value) {
        this.userIdentifierValue = value;
    }

    public XMLGregorianCalendar getValidFromDate() {
        return this.validFromDate;
    }

    public void setValidFromDate(XMLGregorianCalendar value) {
        this.validFromDate = value;
    }

    public XMLGregorianCalendar getValidToDate() {
        return this.validToDate;
    }

    public void setValidToDate(XMLGregorianCalendar value) {
        this.validToDate = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
