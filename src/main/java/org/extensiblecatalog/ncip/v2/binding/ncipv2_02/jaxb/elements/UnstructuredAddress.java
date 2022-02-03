package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"unstructuredAddressType", "unstructuredAddressData", "ext"}
)
@XmlRootElement(
        name = "UnstructuredAddress"
)
public class UnstructuredAddress {
    @XmlElement(
            name = "UnstructuredAddressType",
            required = true
    )
    protected SchemeValuePair unstructuredAddressType;
    @XmlElement(
            name = "UnstructuredAddressData",
            required = true
    )
    protected String unstructuredAddressData;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public UnstructuredAddress() {
    }

    public SchemeValuePair getUnstructuredAddressType() {
        return this.unstructuredAddressType;
    }

    public void setUnstructuredAddressType(SchemeValuePair value) {
        this.unstructuredAddressType = value;
    }

    public String getUnstructuredAddressData() {
        return this.unstructuredAddressData;
    }

    public void setUnstructuredAddressData(String value) {
        this.unstructuredAddressData = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
