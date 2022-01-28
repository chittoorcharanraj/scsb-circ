//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.service;

import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CheckOutItemResponseData implements NCIPResponseData {
    protected String version;
    protected ResponseHeader responseHeader;
    protected List<Problem> problems;
    protected List<ItemUseRestrictionType> requiredItemUseRestrictionTypes;
    protected ItemId itemId;
    protected UserId userId;
    protected GregorianCalendar dateDue;
    protected Boolean indeterminateLoanPeriodFlag;
    protected Boolean nonReturnableFlag;
    protected BigDecimal renewalCount;
    protected ItemOptionalFields itemOptionalFields;
    protected UserOptionalFields userOptionalFields;

    public CheckOutItemResponseData() {
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ResponseHeader getResponseHeader() {
        return this.responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public List<Problem> getProblems() {
        return this.problems;
    }

    public Problem getProblem(int index) {
        return (Problem)this.problems.get(index);
    }

    public void setProblems(List<Problem> problems) {
        this.problems = problems;
    }

    public ItemId getItemId() {
        return this.itemId;
    }

    public void setItemId(ItemId itemId) {
        this.itemId = itemId;
    }

    public ItemOptionalFields getItemOptionalFields() {
        return this.itemOptionalFields;
    }

    public void setItemOptionalFields(ItemOptionalFields itemOptionalFields) {
        this.itemOptionalFields = itemOptionalFields;
    }

    public List<ItemUseRestrictionType> getRequiredItemUseRestrictionTypes() {
        return this.requiredItemUseRestrictionTypes;
    }

    public ItemUseRestrictionType getRequiredItemUseRestrictionType(int index) {
        return (ItemUseRestrictionType)this.requiredItemUseRestrictionTypes.get(index);
    }

    public void setRequiredItemUseRestrictionTypes(List<ItemUseRestrictionType> requiredItemUseRestrictionTypes) {
        this.requiredItemUseRestrictionTypes = requiredItemUseRestrictionTypes;
    }

    public UserId getUserId() {
        return this.userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public GregorianCalendar getDateDue() {
        return this.dateDue;
    }

    public void setDateDue(GregorianCalendar dateDue) {
        this.dateDue = dateDue;
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

    public BigDecimal getRenewalCount() {
        return this.renewalCount;
    }

    public void setRenewalCount(BigDecimal renewalCount) {
        this.renewalCount = renewalCount;
    }

    public UserOptionalFields getUserOptionalFields() {
        return this.userOptionalFields;
    }

    public void setUserOptionalFields(UserOptionalFields userOptionalFields) {
        this.userOptionalFields = userOptionalFields;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
