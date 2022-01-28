package org.extensiblecatalog.ncip.v2.service;

import java.util.GregorianCalendar;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class AcceptItemInitiationData implements NCIPInitiationData {
    protected String version;
    protected InitiationHeader initiationHeader;
    protected AgencyId relyingPartyId;
    protected MandatedAction mandatedAction;
    protected ItemId itemId;
    protected RequestId requestId;
    protected RequestedActionType requestedActionType;
    protected UserId userId;
    protected GregorianCalendar dateForReturn;
    protected Boolean indeterminateLoanPeriodFlag;
    protected Boolean nonReturnableFlag;
    protected Boolean renewalNotPermitted;
    protected ItemOptionalFields itemOptionalFields;
    protected UserOptionalFields userOptionalFields;
    protected PickupLocation pickupLocation;
    protected GregorianCalendar pickupExpiryDate;

    public AcceptItemInitiationData() {
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

    public AgencyId getRelyingPartyId() {
        return this.relyingPartyId;
    }

    public void setRelyingPartyId(AgencyId relyingPartyId) {
        this.relyingPartyId = relyingPartyId;
    }

    public InitiationHeader getInitiationHeader() {
        return this.initiationHeader;
    }

    public void setInitiationHeader(InitiationHeader initiationHeader) {
        this.initiationHeader = initiationHeader;
    }

    public MandatedAction getMandatedAction() {
        return this.mandatedAction;
    }

    public void setMandatedAction(MandatedAction mandatedAction) {
        this.mandatedAction = mandatedAction;
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

    public RequestedActionType getRequestedActionType() {
        return this.requestedActionType;
    }

    public void setRequestedActionType(RequestedActionType requestedActionType) {
        this.requestedActionType = requestedActionType;
    }

    public UserId getUserId() {
        return this.userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public GregorianCalendar getDateForReturn() {
        return this.dateForReturn;
    }

    public void setDateForReturn(GregorianCalendar dateForReturn) {
        this.dateForReturn = dateForReturn;
    }

    public Boolean getIndeterminateLoanPeriodFlag() {
        return this.indeterminateLoanPeriodFlag;
    }

    public void setIndeterminateLoanPeriodFlag(Boolean indeterminateLoanPeriodFlag) {
        this.indeterminateLoanPeriodFlag = indeterminateLoanPeriodFlag;
    }

    public Boolean getNonReturnableFlag() {
        return this.nonReturnableFlag;
    }

    public void setNonReturnableFlag(Boolean nonReturnableFlag) {
        this.nonReturnableFlag = nonReturnableFlag;
    }

    public Boolean getRenewalNotPermitted() {
        return this.renewalNotPermitted;
    }

    public void setRenewalNotPermitted(Boolean renewalNotPermitted) {
        this.renewalNotPermitted = renewalNotPermitted;
    }


    public ItemOptionalFields getItemOptionalFields() {
        return this.itemOptionalFields;
    }

    public void setItemOptionalFields(ItemOptionalFields itemOptionalFields) {
        this.itemOptionalFields = itemOptionalFields;
    }

    public UserOptionalFields getUserOptionalFields() {
        return this.userOptionalFields;
    }

    public void setUserOptionalFields(UserOptionalFields userOptionalFields) {
        this.userOptionalFields = userOptionalFields;
    }

    public PickupLocation getPickupLocation() {
        return this.pickupLocation;
    }

    public void setPickupLocation(PickupLocation pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public GregorianCalendar getPickupExpiryDate() {
        return this.pickupExpiryDate;
    }

    public void setPickupExpiryDate(GregorianCalendar pickupExpiryDate) {
        this.pickupExpiryDate = pickupExpiryDate;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
