//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class LookupUserInitiationData implements NCIPInitiationData {
    protected String version;
    protected InitiationHeader initiationHeader;
    protected UserId userId;
    protected boolean loanedItemsDesired;
    protected boolean requestedItemsDesired;
    protected boolean userFiscalAccountDesired;
    protected AgencyId relyingPartyId;
    protected boolean authenticationInputDesired;
    protected boolean blockOrTrapDesired;
    protected boolean dateOfBirthDesired;
    protected boolean nameInformationDesired;
    protected boolean userAddressInformationDesired;
    protected boolean userLanguageDesired;
    protected boolean userPrivilegeDesired;
    protected boolean userIdDesired;
    protected boolean previousUserIdDesired;

    public LookupUserInitiationData() {
    }

    /** @deprecated */
    @Deprecated
    public String getVersion() {
        return this.version;
    }

    /** @deprecated */
    @Deprecated
    public void setVersion(String version) {
        this.version = version;
    }

    public InitiationHeader getInitiationHeader() {
        return this.initiationHeader;
    }

    public void setInitiationHeader(InitiationHeader initiationHeader) {
        this.initiationHeader = initiationHeader;
    }

    public AgencyId getRelyingPartyId() {
        return this.relyingPartyId;
    }

    public void setRelyingPartyId(AgencyId relyingPartyId) {
        this.relyingPartyId = relyingPartyId;
    }

    public UserId getUserId() {
        return this.userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public boolean getLoanedItemsDesired() {
        return this.loanedItemsDesired;
    }

    public void setLoanedItemsDesired(boolean loanedItemsDesired) {
        this.loanedItemsDesired = loanedItemsDesired;
    }

    public boolean getRequestedItemsDesired() {
        return this.requestedItemsDesired;
    }

    public void setRequestedItemsDesired(boolean requestedItemsDesired) {
        this.requestedItemsDesired = requestedItemsDesired;
    }

    public boolean getUserFiscalAccountDesired() {
        return this.userFiscalAccountDesired;
    }

    public void setUserFiscalAccountDesired(boolean userFiscalAccountDesired) {
        this.userFiscalAccountDesired = userFiscalAccountDesired;
    }

    public boolean getAuthenticationInputDesired() {
        return this.authenticationInputDesired;
    }

    public void setAuthenticationInputDesired(boolean authenticationInputDesired) {
        this.authenticationInputDesired = authenticationInputDesired;
    }

    public boolean getBlockOrTrapDesired() {
        return this.blockOrTrapDesired;
    }

    public void setBlockOrTrapDesired(boolean blockOrTrapDesired) {
        this.blockOrTrapDesired = blockOrTrapDesired;
    }

    public boolean getDateOfBirthDesired() {
        return this.dateOfBirthDesired;
    }

    public void setDateOfBirthDesired(boolean dateOfBirthDesired) {
        this.dateOfBirthDesired = dateOfBirthDesired;
    }

    public boolean getNameInformationDesired() {
        return this.nameInformationDesired;
    }

    public void setNameInformationDesired(boolean nameInformationDesired) {
        this.nameInformationDesired = nameInformationDesired;
    }

    public boolean getUserAddressInformationDesired() {
        return this.userAddressInformationDesired;
    }

    public void setUserAddressInformationDesired(boolean userAddressInformationDesired) {
        this.userAddressInformationDesired = userAddressInformationDesired;
    }

    public boolean getUserLanguageDesired() {
        return this.userLanguageDesired;
    }

    public void setUserLanguageDesired(boolean userLanguageDesired) {
        this.userLanguageDesired = userLanguageDesired;
    }

    public boolean getUserPrivilegeDesired() {
        return this.userPrivilegeDesired;
    }

    public void setUserPrivilegeDesired(boolean userPrivilegeDesired) {
        this.userPrivilegeDesired = userPrivilegeDesired;
    }

    public boolean getUserIdDesired() {
        return this.userIdDesired;
    }

    public void setUserIdDesired(boolean userIdDesired) {
        this.userIdDesired = userIdDesired;
    }

    public boolean getPreviousUserIdDesired() {
        return this.previousUserIdDesired;
    }

    public void setPreviousUserIdDesired(boolean previousUserIdDesired) {
        this.previousUserIdDesired = previousUserIdDesired;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
