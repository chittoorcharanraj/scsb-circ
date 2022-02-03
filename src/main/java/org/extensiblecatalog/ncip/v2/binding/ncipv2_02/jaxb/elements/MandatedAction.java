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
        propOrder = {"dateEventOccurred", "ext"}
)
@XmlRootElement(
        name = "MandatedAction"
)
public class MandatedAction {
    @XmlElement(
            name = "DateEventOccurred",
            required = true,
            type = String.class
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    @XmlSchemaType(
            name = "dateTime"
    )
    protected XMLGregorianCalendar dateEventOccurred;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public MandatedAction() {
    }

    public XMLGregorianCalendar getDateEventOccurred() {
        return this.dateEventOccurred;
    }

    public void setDateEventOccurred(XMLGregorianCalendar value) {
        this.dateEventOccurred = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
