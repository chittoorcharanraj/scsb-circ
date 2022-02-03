package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"responseHeader", "problem", "itemId", "userId", "routingInformation", "itemOptionalFields", "userOptionalFields", "ext"}
)
@XmlRootElement(
        name = "CheckInItemResponse"
)
public class CheckInItemResponse {
    @XmlElement(
            name = "ResponseHeader"
    )
    protected ResponseHeader responseHeader;
    @XmlElement(
            name = "Problem"
    )
    protected List<Problem> problem;
    @XmlElement(
            name = "ItemId"
    )
    protected ItemId itemId;
    @XmlElement(
            name = "UserId"
    )
    protected UserId userId;
    @XmlElement(
            name = "RoutingInformation"
    )
    protected RoutingInformation routingInformation;
    @XmlElement(
            name = "ItemOptionalFields"
    )
    protected ItemOptionalFields itemOptionalFields;
    @XmlElement(
            name = "UserOptionalFields"
    )
    protected UserOptionalFields userOptionalFields;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public CheckInItemResponse() {
    }

    public ResponseHeader getResponseHeader() {
        return this.responseHeader;
    }

    public void setResponseHeader(ResponseHeader value) {
        this.responseHeader = value;
    }

    public List<Problem> getProblem() {
        if (this.problem == null) {
            this.problem = new ArrayList();
        }

        return this.problem;
    }

    public ItemId getItemId() {
        return this.itemId;
    }

    public void setItemId(ItemId value) {
        this.itemId = value;
    }

    public UserId getUserId() {
        return this.userId;
    }

    public void setUserId(UserId value) {
        this.userId = value;
    }

    public RoutingInformation getRoutingInformation() {
        return this.routingInformation;
    }

    public void setRoutingInformation(RoutingInformation value) {
        this.routingInformation = value;
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

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
