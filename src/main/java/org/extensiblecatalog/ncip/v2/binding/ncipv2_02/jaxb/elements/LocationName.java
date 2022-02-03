package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"locationNameInstance", "ext"}
)
@XmlRootElement(
        name = "LocationName"
)
public class LocationName {
    @XmlElement(
            name = "LocationNameInstance",
            required = true
    )
    protected List<LocationNameInstance> locationNameInstance;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public LocationName() {
    }

    public List<LocationNameInstance> getLocationNameInstance() {
        if (this.locationNameInstance == null) {
            this.locationNameInstance = new ArrayList();
        }

        return this.locationNameInstance;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
