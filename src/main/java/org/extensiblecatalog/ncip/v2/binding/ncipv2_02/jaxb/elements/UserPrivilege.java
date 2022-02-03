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
        propOrder = {"agencyId", "agencyUserPrivilegeType", "validFromDate", "validToDate", "userPrivilegeStatus", "userPrivilegeDescription", "ext"}
)
@XmlRootElement(
        name = "UserPrivilege"
)
public class UserPrivilege {
    @XmlElement(
            name = "AgencyId",
            required = true
    )
    protected SchemeValuePair agencyId;
    @XmlElement(
            name = "AgencyUserPrivilegeType",
            required = true
    )
    protected SchemeValuePair agencyUserPrivilegeType;
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
            name = "UserPrivilegeStatus"
    )
    protected UserPrivilegeStatus userPrivilegeStatus;
    @XmlElement(
            name = "UserPrivilegeDescription"
    )
    protected String userPrivilegeDescription;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public UserPrivilege() {
    }

    public SchemeValuePair getAgencyId() {
        return this.agencyId;
    }

    public void setAgencyId(SchemeValuePair value) {
        this.agencyId = value;
    }

    public SchemeValuePair getAgencyUserPrivilegeType() {
        return this.agencyUserPrivilegeType;
    }

    public void setAgencyUserPrivilegeType(SchemeValuePair value) {
        this.agencyUserPrivilegeType = value;
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


    public UserPrivilegeStatus getUserPrivilegeStatus() {
        return this.userPrivilegeStatus;
    }

    public void setUserPrivilegeStatus(UserPrivilegeStatus value) {
        this.userPrivilegeStatus = value;
    }

    public String getUserPrivilegeDescription() {
        return this.userPrivilegeDescription;
    }

    public void setUserPrivilegeDescription(String value) {
        this.userPrivilegeDescription = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
