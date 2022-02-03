package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"acceptItem", "acceptItemResponse",  "cancelRequestItem", "cancelRequestItemResponse", "checkInItem", "checkInItemResponse", "checkOutItem", "checkOutItemResponse",  "lookupUser", "lookupUserResponse", "recallItem", "recallItemResponse", "requestItem", "requestItemResponse", "problem", "ext"}
)
@XmlRootElement(
        name = "NCIPMessage"
)
public class NCIPMessage {
    @XmlElement(
            name = "AcceptItem"
    )
    protected AcceptItem acceptItem;
    @XmlElement(
            name = "AcceptItemResponse"
    )
    protected AcceptItemResponse acceptItemResponse;
    @XmlElement(
            name = "CancelRequestItem"
    )
    protected CancelRequestItem cancelRequestItem;
    @XmlElement(
            name = "CancelRequestItemResponse"
    )
    protected CancelRequestItemResponse cancelRequestItemResponse;
    @XmlElement(
            name = "CheckInItem"
    )
    protected CheckInItem checkInItem;
    @XmlElement(
            name = "CheckInItemResponse"
    )
    protected CheckInItemResponse checkInItemResponse;
    @XmlElement(
            name = "CheckOutItem"
    )
    protected CheckOutItem checkOutItem;
    @XmlElement(
            name = "CheckOutItemResponse"
    )
    protected CheckOutItemResponse checkOutItemResponse;
    @XmlElement(
            name = "LookupUser"
    )
    protected LookupUser lookupUser;
    @XmlElement(
            name = "LookupUserResponse"
    )
    protected LookupUserResponse lookupUserResponse;
    @XmlElement(
            name = "RecallItem"
    )
    protected RecallItem recallItem;
    @XmlElement(
            name = "RecallItemResponse"
    )
    protected RecallItemResponse recallItemResponse;
    @XmlElement(
            name = "RequestItem"
    )
    protected RequestItem requestItem;
    @XmlElement(
            name = "RequestItemResponse"
    )
    protected RequestItemResponse requestItemResponse;
    @XmlElement(
            name = "Problem"
    )
    protected List<Problem> problem;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;
    @XmlAttribute(
            name = "version",
            namespace = "http://www.niso.org/2008/ncip",
            required = true
    )
    protected String version;

    public NCIPMessage() {
    }

    public AcceptItem getAcceptItem() {
        return this.acceptItem;
    }

    public void setAcceptItem(AcceptItem value) {
        this.acceptItem = value;
    }

    public AcceptItemResponse getAcceptItemResponse() {
        return this.acceptItemResponse;
    }

    public void setAcceptItemResponse(AcceptItemResponse value) {
        this.acceptItemResponse = value;
    }


    public CancelRequestItem getCancelRequestItem() {
        return this.cancelRequestItem;
    }

    public void setCancelRequestItem(CancelRequestItem value) {
        this.cancelRequestItem = value;
    }

    public CancelRequestItemResponse getCancelRequestItemResponse() {
        return this.cancelRequestItemResponse;
    }

    public void setCancelRequestItemResponse(CancelRequestItemResponse value) {
        this.cancelRequestItemResponse = value;
    }

    public CheckInItem getCheckInItem() {
        return this.checkInItem;
    }

    public void setCheckInItem(CheckInItem value) {
        this.checkInItem = value;
    }


    public LookupUser getLookupUser() {
        return this.lookupUser;
    }

    public void setLookupUser(LookupUser value) {
        this.lookupUser = value;
    }

    public LookupUserResponse getLookupUserResponse() {
        return this.lookupUserResponse;
    }

    public void setLookupUserResponse(LookupUserResponse value) {
        this.lookupUserResponse = value;
    }

    public RecallItem getRecallItem() {
        return this.recallItem;
    }

    public void setRecallItem(RecallItem value) {
        this.recallItem = value;
    }

    public RecallItemResponse getRecallItemResponse() {
        return this.recallItemResponse;
    }

    public void setRecallItemResponse(RecallItemResponse value) {
        this.recallItemResponse = value;
    }

    public RequestItem getRequestItem() {
        return this.requestItem;
    }

    public void setRequestItem(RequestItem value) {
        this.requestItem = value;
    }

    public RequestItemResponse getRequestItemResponse() {
        return this.requestItemResponse;
    }

    public void setRequestItemResponse(RequestItemResponse value) {
        this.requestItemResponse = value;
    }


    public List<Problem> getProblem() {
        if (this.problem == null) {
            this.problem = new ArrayList();
        }

        return this.problem;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String value) {
        this.version = value;
    }
}
