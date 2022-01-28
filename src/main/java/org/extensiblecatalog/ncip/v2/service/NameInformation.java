//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class NameInformation {
    protected PersonalNameInformation personalNameInformation;
    protected List<OrganizationNameInformation> organizationNameInformations;

    public NameInformation() {
    }

    public PersonalNameInformation getPersonalNameInformation() {
        return this.personalNameInformation;
    }

    public void setPersonalNameInformation(PersonalNameInformation personalNameInformation) {
        this.personalNameInformation = personalNameInformation;
    }

    public List<OrganizationNameInformation> getOrganizationNameInformations() {
        return this.organizationNameInformations;
    }

    public OrganizationNameInformation getOrganizationNameInformation(int index) {
        return (OrganizationNameInformation)this.organizationNameInformations.get(index);
    }

    public void setOrganizationNameInformations(List<OrganizationNameInformation> organizationNameInformations) {
        this.organizationNameInformations = organizationNameInformations;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
