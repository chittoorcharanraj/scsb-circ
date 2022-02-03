package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"prefix", "givenName", "initials", "surname", "suffix", "ext"}
)
@XmlRootElement(
        name = "StructuredPersonalUserName"
)
public class StructuredPersonalUserName {
    @XmlElement(
            name = "Prefix"
    )
    protected String prefix;
    @XmlElement(
            name = "GivenName"
    )
    protected String givenName;
    @XmlElement(
            name = "Initials"
    )
    protected String initials;
    @XmlElement(
            name = "Surname",
            required = true
    )
    protected String surname;
    @XmlElement(
            name = "Suffix"
    )
    protected String suffix;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public StructuredPersonalUserName() {
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String value) {
        this.prefix = value;
    }

    public String getGivenName() {
        return this.givenName;
    }

    public void setGivenName(String value) {
        this.givenName = value;
    }

    public String getInitials() {
        return this.initials;
    }

    public void setInitials(String value) {
        this.initials = value;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String value) {
        this.surname = value;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public void setSuffix(String value) {
        this.suffix = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
