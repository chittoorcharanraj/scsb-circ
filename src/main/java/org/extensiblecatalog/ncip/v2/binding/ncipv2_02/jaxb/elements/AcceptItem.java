package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"initiationHeader", "mandatedAction", "requestId", "requestedActionType", "userId", "itemId", "itemOptionalFields", "userOptionalFields", "pickupLocation", "pickupExpiryDate", "ext"}
)
@XmlRootElement(
        name = "AcceptItem"
)
public class AcceptItem {
    @XmlElement(
            name = "InitiationHeader"
    )
    protected InitiationHeader initiationHeader;
    @XmlElement(
            name = "MandatedAction"
    )
    protected MandatedAction mandatedAction;
    @XmlElement(
            name = "RequestId",
            required = true
    )
    protected RequestId requestId;
    @XmlElement(
            name = "RequestedActionType",
            required = true
    )
    protected SchemeValuePair requestedActionType;
    @XmlElement(
            name = "UserId"
    )
    protected UserId userId;
    @XmlElement(
            name = "ItemId"
    )
    protected ItemId itemId;
    @XmlElement(
            name = "ItemOptionalFields"
    )
    protected ItemOptionalFields itemOptionalFields;
    @XmlElement(
            name = "UserOptionalFields"
    )
    protected UserOptionalFields userOptionalFields;
    @XmlElement(
            name = "PickupLocation"
    )
    protected SchemeValuePair pickupLocation;
    @XmlElement(
            name = "PickupExpiryDate",
            type = String.class
    )
    protected XMLGregorianCalendar pickupExpiryDate;

    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public AcceptItem() {
    }

    public InitiationHeader getInitiationHeader() {
        return this.initiationHeader;
    }

    public void setInitiationHeader(InitiationHeader value) {
        this.initiationHeader = value;
    }

    public MandatedAction getMandatedAction() {
        return this.mandatedAction;
    }

    public void setMandatedAction(MandatedAction value) {
        this.mandatedAction = value;
    }

    public RequestId getRequestId() {
        return this.requestId;
    }

    public void setRequestId(RequestId value) {
        this.requestId = value;
    }

    public SchemeValuePair getRequestedActionType() {
        return this.requestedActionType;
    }

    public void setRequestedActionType(SchemeValuePair value) {
        this.requestedActionType = value;
    }

    public UserId getUserId() {
        return this.userId;
    }

    public void setUserId(UserId value) {
        this.userId = value;
    }

    public ItemId getItemId() {
        return this.itemId;
    }

    public void setItemId(ItemId value) {
        this.itemId = value;
    }


    public ItemOptionalFields getItemOptionalFields() {
        return this.itemOptionalFields;
    }

    public void setItemOptionalFields(ItemOptionalFields value) {
        this.itemOptionalFields = value;
    }

    public UserOptionalFields getUserOptionalFields() {
        return this.userOptionalFields;
    }

    public void setUserOptionalFields(UserOptionalFields value) {
        this.userOptionalFields = value;
    }

    public SchemeValuePair getPickupLocation() {
        return this.pickupLocation;
    }

    public void setPickupLocation(SchemeValuePair value) {
        this.pickupLocation = value;
    }

    public XMLGregorianCalendar getPickupExpiryDate() {
        return this.pickupExpiryDate;
    }

    public void setPickupExpiryDate(XMLGregorianCalendar value) {
        this.pickupExpiryDate = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
