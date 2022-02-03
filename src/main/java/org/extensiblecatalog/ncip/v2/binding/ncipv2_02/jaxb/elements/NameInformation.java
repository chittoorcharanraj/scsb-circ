//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

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
        propOrder = {"personalNameInformation", "organizationNameInformation", "ext"}
)
@XmlRootElement(
        name = "NameInformation"
)
public class NameInformation {
    @XmlElement(
            name = "PersonalNameInformation"
    )
    protected PersonalNameInformation personalNameInformation;
    @XmlElement(
            name = "OrganizationNameInformation"
    )
    protected List<OrganizationNameInformation> organizationNameInformation;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public NameInformation() {
    }

    public PersonalNameInformation getPersonalNameInformation() {
        return this.personalNameInformation;
    }

    public void setPersonalNameInformation(PersonalNameInformation value) {
        this.personalNameInformation = value;
    }

    public List<OrganizationNameInformation> getOrganizationNameInformation() {
        if (this.organizationNameInformation == null) {
            this.organizationNameInformation = new ArrayList();
        }

        return this.organizationNameInformation;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
