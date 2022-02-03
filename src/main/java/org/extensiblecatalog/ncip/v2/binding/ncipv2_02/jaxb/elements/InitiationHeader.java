package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"fromSystemId", "fromSystemAuthentication", "fromAgencyId", "fromAgencyAuthentication", "onBehalfOfAgency", "toSystemId", "toAgencyId", "applicationProfileType", "ext"}
)
@XmlRootElement(
        name = "InitiationHeader"
)
public class InitiationHeader {
    @XmlElement(
            name = "FromSystemId"
    )
    protected SchemeValuePair fromSystemId;
    @XmlElement(
            name = "FromSystemAuthentication"
    )
    protected String fromSystemAuthentication;
    @XmlElement(
            name = "FromAgencyId",
            required = true
    )
    protected FromAgencyId fromAgencyId;
    @XmlElement(
            name = "FromAgencyAuthentication"
    )
    protected String fromAgencyAuthentication;
    @XmlElement(
            name = "OnBehalfOfAgency"
    )
    protected OnBehalfOfAgency onBehalfOfAgency;
    @XmlElement(
            name = "ToSystemId"
    )
    protected SchemeValuePair toSystemId;
    @XmlElement(
            name = "ToAgencyId",
            required = true
    )
    protected ToAgencyId toAgencyId;
    @XmlElement(
            name = "ApplicationProfileType"
    )
    protected SchemeValuePair applicationProfileType;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public InitiationHeader() {
    }

    public SchemeValuePair getFromSystemId() {
        return this.fromSystemId;
    }

    public void setFromSystemId(SchemeValuePair value) {
        this.fromSystemId = value;
    }

    public String getFromSystemAuthentication() {
        return this.fromSystemAuthentication;
    }

    public void setFromSystemAuthentication(String value) {
        this.fromSystemAuthentication = value;
    }

    public FromAgencyId getFromAgencyId() {
        return this.fromAgencyId;
    }

    public void setFromAgencyId(FromAgencyId value) {
        this.fromAgencyId = value;
    }

    public String getFromAgencyAuthentication() {
        return this.fromAgencyAuthentication;
    }

    public void setFromAgencyAuthentication(String value) {
        this.fromAgencyAuthentication = value;
    }

    public OnBehalfOfAgency getOnBehalfOfAgency() {
        return this.onBehalfOfAgency;
    }

    public void setOnBehalfOfAgency(OnBehalfOfAgency value) {
        this.onBehalfOfAgency = value;
    }

    public SchemeValuePair getToSystemId() {
        return this.toSystemId;
    }

    public void setToSystemId(SchemeValuePair value) {
        this.toSystemId = value;
    }

    public ToAgencyId getToAgencyId() {
        return this.toAgencyId;
    }

    public void setToAgencyId(ToAgencyId value) {
        this.toAgencyId = value;
    }

    public SchemeValuePair getApplicationProfileType() {
        return this.applicationProfileType;
    }

    public void setApplicationProfileType(SchemeValuePair value) {
        this.applicationProfileType = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
