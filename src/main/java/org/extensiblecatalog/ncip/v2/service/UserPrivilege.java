package org.extensiblecatalog.ncip.v2.service;

import java.util.GregorianCalendar;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class UserPrivilege {
    protected AgencyId agencyId;
    protected AgencyUserPrivilegeType agencyUserPrivilegeType;
    protected GregorianCalendar validFromDate;
    protected GregorianCalendar validToDate;
    protected UserPrivilegeStatus userPrivilegeStatus;
    protected String userPrivilegeDescription;

    public UserPrivilege() {
    }

    public AgencyId getAgencyId() {
        return this.agencyId;
    }

    public void setAgencyId(AgencyId agencyId) {
        this.agencyId = agencyId;
    }

    public AgencyUserPrivilegeType getAgencyUserPrivilegeType() {
        return this.agencyUserPrivilegeType;
    }

    public void setAgencyUserPrivilegeType(AgencyUserPrivilegeType agencyUserPrivilegeType) {
        this.agencyUserPrivilegeType = agencyUserPrivilegeType;
    }

    public GregorianCalendar getValidFromDate() {
        return this.validFromDate;
    }

    public void setValidFromDate(GregorianCalendar validFromDate) {
        this.validFromDate = validFromDate;
    }

    public GregorianCalendar getValidToDate() {
        return this.validToDate;
    }

    public void setValidToDate(GregorianCalendar validToDate) {
        this.validToDate = validToDate;
    }

    public UserPrivilegeStatus getUserPrivilegeStatus() {
        return this.userPrivilegeStatus;
    }

    public void setUserPrivilegeStatus(UserPrivilegeStatus userPrivilegeStatus) {
        this.userPrivilegeStatus = userPrivilegeStatus;
    }

    public String getUserPrivilegeDescription() {
        return this.userPrivilegeDescription;
    }

    public void setUserPrivilegeDescription(String userPrivilegeDescription) {
        this.userPrivilegeDescription = userPrivilegeDescription;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
