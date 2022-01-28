//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.service;

import java.util.GregorianCalendar;
import java.util.List;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CheckOutItemInitiationData implements NCIPInitiationData {
    protected String version;
    protected InitiationHeader initiationHeader;
    protected MandatedAction mandatedAction;
    protected UserId userId;
    protected ItemId itemId;
    protected RequestId requestId;
    protected List<ItemUseRestrictionType> acknowledgedItemUseRestrictionTypes;
    protected ShippingInformation shippingInformation;
    protected Boolean resourceDesired;
    protected GregorianCalendar desiredDateDue;
    protected AgencyId relyingPartyId;
    protected boolean bibliographicDescriptionDesired;
    protected boolean circulationStatusDesired;
    protected boolean electronicResourceDesired;
    protected boolean holdQueueLengthDesired;
    protected boolean itemDescriptionDesired;
    protected boolean itemUseRestrictionTypeDesired;
    protected boolean locationDesired;
    protected boolean physicalConditionDesired;
    protected boolean securityMarkerDesired;
    protected boolean sensitizationFlagDesired;
    protected boolean authenticationInputDesired;
    protected boolean blockOrTrapDesired;
    protected boolean dateOfBirthDesired;
    protected boolean nameInformationDesired;
    protected boolean userAddressInformationDesired;
    protected boolean userLanguageDesired;
    protected boolean userPrivilegeDesired;
    protected boolean userIdDesired;
    protected boolean previousUserIdDesired;

    public CheckOutItemInitiationData() {
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

    public ItemId getItemId() {
        return this.itemId;
    }

    public void setItemId(ItemId itemId) {
        this.itemId = itemId;
    }

    public RequestId getRequestId() {
        return this.requestId;
    }

    public void setRequestId(RequestId requestId) {
        this.requestId = requestId;
    }

    public MandatedAction getMandatedAction() {
        return this.mandatedAction;
    }

    public void setMandatedAction(MandatedAction mandatedAction) {
        this.mandatedAction = mandatedAction;
    }

    public UserId getUserId() {
        return this.userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public List<ItemUseRestrictionType> getAcknowledgedItemUseRestrictionTypes() {
        return this.acknowledgedItemUseRestrictionTypes;
    }

    public ItemUseRestrictionType getAcknowledgedItemUseRestrictionType(int index) {
        return (ItemUseRestrictionType)this.acknowledgedItemUseRestrictionTypes.get(index);
    }

    public void setAcknowledgedItemUseRestrictionTypes(List<ItemUseRestrictionType> acknowledgedItemUseRestrictionTypes) {
        this.acknowledgedItemUseRestrictionTypes = acknowledgedItemUseRestrictionTypes;
    }

    public ShippingInformation getShippingInformation() {
        return this.shippingInformation;
    }

    public void setShippingInformation(ShippingInformation shippingInformation) {
        this.shippingInformation = shippingInformation;
    }

    public Boolean getResourceDesired() {
        return this.resourceDesired;
    }

    public void setResourceDesired(Boolean resourceDesired) {
        this.resourceDesired = resourceDesired;
    }

    public GregorianCalendar getDesiredDateDue() {
        return this.desiredDateDue;
    }

    public void setDesiredDateDue(GregorianCalendar desiredDateDue) {
        this.desiredDateDue = desiredDateDue;
    }

    public boolean getBibliographicDescriptionDesired() {
        return this.bibliographicDescriptionDesired;
    }

    public void setBibliographicDescriptionDesired(boolean bibliographicDescriptionDesired) {
        this.bibliographicDescriptionDesired = bibliographicDescriptionDesired;
    }

    public boolean getCirculationStatusDesired() {
        return this.circulationStatusDesired;
    }

    public void setCirculationStatusDesired(boolean circulationStatusDesired) {
        this.circulationStatusDesired = circulationStatusDesired;
    }

    public boolean getElectronicResourceDesired() {
        return this.electronicResourceDesired;
    }

    public void setElectronicResourceDesired(boolean electronicResourceDesired) {
        this.electronicResourceDesired = electronicResourceDesired;
    }

    public boolean getHoldQueueLengthDesired() {
        return this.holdQueueLengthDesired;
    }

    public void setHoldQueueLengthDesired(boolean holdQueueLengthDesired) {
        this.holdQueueLengthDesired = holdQueueLengthDesired;
    }

    public boolean getItemDescriptionDesired() {
        return this.itemDescriptionDesired;
    }

    public void setItemDescriptionDesired(boolean itemDescriptionDesired) {
        this.itemDescriptionDesired = itemDescriptionDesired;
    }

    public boolean getItemUseRestrictionTypeDesired() {
        return this.itemUseRestrictionTypeDesired;
    }

    public void setItemUseRestrictionTypeDesired(boolean itemUseRestrictionTypeDesired) {
        this.itemUseRestrictionTypeDesired = itemUseRestrictionTypeDesired;
    }

    public boolean getLocationDesired() {
        return this.locationDesired;
    }

    public void setLocationDesired(boolean locationDesired) {
        this.locationDesired = locationDesired;
    }

    public boolean getPhysicalConditionDesired() {
        return this.physicalConditionDesired;
    }

    public void setPhysicalConditionDesired(boolean physicalConditionDesired) {
        this.physicalConditionDesired = physicalConditionDesired;
    }

    public boolean getSecurityMarkerDesired() {
        return this.securityMarkerDesired;
    }

    public void setSecurityMarkerDesired(boolean securityMarkerDesired) {
        this.securityMarkerDesired = securityMarkerDesired;
    }

    public boolean getSensitizationFlagDesired() {
        return this.sensitizationFlagDesired;
    }

    public void setSensitizationFlagDesired(boolean sensitizationFlagDesired) {
        this.sensitizationFlagDesired = sensitizationFlagDesired;
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
