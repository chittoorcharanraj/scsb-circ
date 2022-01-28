package org.extensiblecatalog.ncip.v2.service;

import java.util.GregorianCalendar;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class UserPrivilegeStatus {
    protected UserPrivilegeStatusType userPrivilegeStatusType;
    protected GregorianCalendar dateOfUserPrivilegeStatus;

    public UserPrivilegeStatus() {
    }

    public UserPrivilegeStatusType getUserPrivilegeStatusType() {
        return this.userPrivilegeStatusType;
    }

    public void setUserPrivilegeStatusType(UserPrivilegeStatusType userPrivilegeStatusType) {
        this.userPrivilegeStatusType = userPrivilegeStatusType;
    }

    public GregorianCalendar getDateOfUserPrivilegeStatus() {
        return this.dateOfUserPrivilegeStatus;
    }

    public void setDateOfUserPrivilegeStatus(GregorianCalendar dateOfUserPrivilegeStatus) {
        this.dateOfUserPrivilegeStatus = dateOfUserPrivilegeStatus;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
