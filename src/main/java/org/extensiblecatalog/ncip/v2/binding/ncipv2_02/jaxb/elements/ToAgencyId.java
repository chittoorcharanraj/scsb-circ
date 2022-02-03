package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"agencyId", "ext"}
)
@XmlRootElement(
        name = "ToAgencyId"
)
public class ToAgencyId {
    @XmlElement(
            name = "AgencyId",
            required = true
    )
    protected SchemeValuePair agencyId;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public ToAgencyId() {
    }

    public SchemeValuePair getAgencyId() {
        return this.agencyId;
    }

    public void setAgencyId(SchemeValuePair value) {
        this.agencyId = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
