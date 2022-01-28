//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.service;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class PersonalNameInformation {
    protected String unstructuredPersonalUserName;
    protected StructuredPersonalUserName structuredPersonalUserName;

    public PersonalNameInformation() {
    }

    public String getUnstructuredPersonalUserName() {
        return this.unstructuredPersonalUserName;
    }

    public void setUnstructuredPersonalUserName(String unstructuredPersonalUserName) {
        this.unstructuredPersonalUserName = unstructuredPersonalUserName;
    }

    public StructuredPersonalUserName getStructuredPersonalUserName() {
        return this.structuredPersonalUserName;
    }

    public void setStructuredPersonalUserName(StructuredPersonalUserName structuredPersonalUserName) {
        this.structuredPersonalUserName = structuredPersonalUserName;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
