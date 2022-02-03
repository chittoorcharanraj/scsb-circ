package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"locationNameLevel", "locationNameValue", "ext"}
)
@XmlRootElement(
        name = "LocationNameInstance"
)
public class LocationNameInstance {
    @XmlElement(
            name = "LocationNameLevel",
            required = true,
            type = String.class
    )
    @XmlJavaTypeAdapter(Adapter2.class)
    @XmlSchemaType(
            name = "positiveInteger"
    )
    protected BigDecimal locationNameLevel;
    @XmlElement(
            name = "LocationNameValue",
            required = true
    )
    protected String locationNameValue;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public LocationNameInstance() {
    }

    public BigDecimal getLocationNameLevel() {
        return this.locationNameLevel;
    }

    public void setLocationNameLevel(BigDecimal value) {
        this.locationNameLevel = value;
    }

    public String getLocationNameValue() {
        return this.locationNameValue;
    }

    public void setLocationNameValue(String value) {
        this.locationNameValue = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
