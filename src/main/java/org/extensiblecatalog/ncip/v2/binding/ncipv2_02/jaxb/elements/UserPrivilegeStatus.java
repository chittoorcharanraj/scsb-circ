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
        propOrder = {"userPrivilegeStatusType", "dateOfUserPrivilegeStatus", "ext"}
)
@XmlRootElement(
        name = "UserPrivilegeStatus"
)
public class UserPrivilegeStatus {
    @XmlElement(
            name = "UserPrivilegeStatusType",
            required = true
    )
    protected SchemeValuePair userPrivilegeStatusType;
    @XmlElement(
            name = "DateOfUserPrivilegeStatus",
            type = String.class
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    @XmlSchemaType(
            name = "dateTime"
    )
    protected XMLGregorianCalendar dateOfUserPrivilegeStatus;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public UserPrivilegeStatus() {
    }

    public SchemeValuePair getUserPrivilegeStatusType() {
        return this.userPrivilegeStatusType;
    }

    public void setUserPrivilegeStatusType(SchemeValuePair value) {
        this.userPrivilegeStatusType = value;
    }

    public XMLGregorianCalendar getDateOfUserPrivilegeStatus() {
        return this.dateOfUserPrivilegeStatus;
    }

    public void setDateOfUserPrivilegeStatus(XMLGregorianCalendar value) {
        this.dateOfUserPrivilegeStatus = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
