package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"electronicAddressType", "electronicAddressData", "ext"}
)
@XmlRootElement(
        name = "ElectronicAddress"
)
public class ElectronicAddress {
    @XmlElement(
            name = "ElectronicAddressType",
            required = true
    )
    protected SchemeValuePair electronicAddressType;
    @XmlElement(
            name = "ElectronicAddressData",
            required = true
    )
    protected String electronicAddressData;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public ElectronicAddress() {
    }

    public SchemeValuePair getElectronicAddressType() {
        return this.electronicAddressType;
    }

    public void setElectronicAddressType(SchemeValuePair value) {
        this.electronicAddressType = value;
    }

    public String getElectronicAddressData() {
        return this.electronicAddressData;
    }

    public void setElectronicAddressData(String value) {
        this.electronicAddressData = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
