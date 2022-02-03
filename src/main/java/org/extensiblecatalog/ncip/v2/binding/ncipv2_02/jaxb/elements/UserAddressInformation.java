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
        propOrder = {"userAddressRoleType", "validFromDate", "validToDate", "physicalAddress", "electronicAddress", "ext"}
)
@XmlRootElement(
        name = "UserAddressInformation"
)
public class UserAddressInformation {
    @XmlElement(
            name = "UserAddressRoleType",
            required = true
    )
    protected SchemeValuePair userAddressRoleType;
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
            name = "PhysicalAddress"
    )
    protected PhysicalAddress physicalAddress;
    @XmlElement(
            name = "ElectronicAddress"
    )
    protected ElectronicAddress electronicAddress;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public UserAddressInformation() {
    }

    public SchemeValuePair getUserAddressRoleType() {
        return this.userAddressRoleType;
    }

    public void setUserAddressRoleType(SchemeValuePair value) {
        this.userAddressRoleType = value;
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

    public PhysicalAddress getPhysicalAddress() {
        return this.physicalAddress;
    }

    public void setPhysicalAddress(PhysicalAddress value) {
        this.physicalAddress = value;
    }

    public ElectronicAddress getElectronicAddress() {
        return this.electronicAddress;
    }

    public void setElectronicAddress(ElectronicAddress value) {
        this.electronicAddress = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
