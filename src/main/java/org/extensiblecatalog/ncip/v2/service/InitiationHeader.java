//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.service;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class InitiationHeader {
    protected ApplicationProfileType applicationProfileType;
    protected ToSystemId toSystemId;
    protected ToAgencyId toAgencyId;
    protected String fromSystemAuthentication;
    protected FromSystemId fromSystemId;
    protected String fromAgencyAuthentication;
    protected FromAgencyId fromAgencyId;
    protected OnBehalfOfAgency onBehalfOfAgency;

    public InitiationHeader() {
    }

    public ApplicationProfileType getApplicationProfileType() {
        return this.applicationProfileType;
    }

    public void setApplicationProfileType(ApplicationProfileType applicationProfileType) {
        this.applicationProfileType = applicationProfileType;
    }

    public ToSystemId getToSystemId() {
        return this.toSystemId;
    }

    public void setToSystemId(ToSystemId toSystemId) {
        this.toSystemId = toSystemId;
    }

    public String getFromSystemAuthentication() {
        return this.fromSystemAuthentication;
    }

    public void setFromSystemAuthentication(String fromSystemAuthentication) {
        this.fromSystemAuthentication = fromSystemAuthentication;
    }

    public FromSystemId getFromSystemId() {
        return this.fromSystemId;
    }

    public void setFromSystemId(FromSystemId fromSystemId) {
        this.fromSystemId = fromSystemId;
    }

    public String getFromAgencyAuthentication() {
        return this.fromAgencyAuthentication;
    }

    public void setFromAgencyAuthentication(String fromAgencyAuthentication) {
        this.fromAgencyAuthentication = fromAgencyAuthentication;
    }

    public OnBehalfOfAgency getOnBehalfOfAgency() {
        return this.onBehalfOfAgency;
    }

    public void setOnBehalfOfAgency(OnBehalfOfAgency onBehalfOfAgency) {
        this.onBehalfOfAgency = onBehalfOfAgency;
    }

    public ToAgencyId getToAgencyId() {
        return this.toAgencyId;
    }

    public void setToAgencyId(ToAgencyId toAgencyId) {
        this.toAgencyId = toAgencyId;
    }

    public FromAgencyId getFromAgencyId() {
        return this.fromAgencyId;
    }

    public void setFromAgencyId(FromAgencyId fromAgencyId) {
        this.fromAgencyId = fromAgencyId;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
