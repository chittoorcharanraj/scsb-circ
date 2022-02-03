package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"content"}
)
@XmlRootElement(
        name = "StructuredAddress"
)
public class StructuredAddress {
    @XmlElementRefs({@XmlElementRef(
            name = "Locality",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "Line2",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "PostalCode",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "Region",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "PostOfficeBox",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "District",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "CareOf",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "HouseName",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "Street",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "Country",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "LocationWithinBuilding",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "Ext",
            namespace = "http://www.niso.org/2008/ncip",
            type = Ext.class
    ), @XmlElementRef(
            name = "Line1",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    )})
    protected List<Object> content;

    public StructuredAddress() {
    }

    public List<Object> getContent() {
        if (this.content == null) {
            this.content = new ArrayList();
        }

        return this.content;
    }
}
