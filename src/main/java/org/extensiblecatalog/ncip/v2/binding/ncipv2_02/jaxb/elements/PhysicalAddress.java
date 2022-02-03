package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"structuredAddress", "unstructuredAddress", "physicalAddressType", "ext"}
)
@XmlRootElement(
        name = "PhysicalAddress"
)
public class PhysicalAddress {
    @XmlElement(
            name = "StructuredAddress"
    )
    protected StructuredAddress structuredAddress;
    @XmlElement(
            name = "UnstructuredAddress"
    )
    protected UnstructuredAddress unstructuredAddress;
    @XmlElement(
            name = "PhysicalAddressType",
            required = true
    )
    protected SchemeValuePair physicalAddressType;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public PhysicalAddress() {
    }

    public StructuredAddress getStructuredAddress() {
        return this.structuredAddress;
    }

    public void setStructuredAddress(StructuredAddress value) {
        this.structuredAddress = value;
    }

    public UnstructuredAddress getUnstructuredAddress() {
        return this.unstructuredAddress;
    }

    public void setUnstructuredAddress(UnstructuredAddress value) {
        this.unstructuredAddress = value;
    }

    public SchemeValuePair getPhysicalAddressType() {
        return this.physicalAddressType;
    }

    public void setPhysicalAddressType(SchemeValuePair value) {
        this.physicalAddressType = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
