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
        propOrder = {"responseHeader", "problem", "requestId", "itemId", "ext"}
)
@XmlRootElement(
        name = "AcceptItemResponse"
)
public class AcceptItemResponse {
    @XmlElement(
            name = "ResponseHeader"
    )
    protected ResponseHeader responseHeader;
    @XmlElement(
            name = "Problem"
    )
    protected List<Problem> problem;
    @XmlElement(
            name = "RequestId"
    )
    protected RequestId requestId;
    @XmlElement(
            name = "ItemId"
    )
    protected ItemId itemId;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public AcceptItemResponse() {
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

    public RequestId getRequestId() {
        return this.requestId;
    }

    public void setRequestId(RequestId value) {
        this.requestId = value;
    }

    public ItemId getItemId() {
        return this.itemId;
    }

    public void setItemId(ItemId value) {
        this.itemId = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
