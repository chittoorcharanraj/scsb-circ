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
        propOrder = {"initiationHeader", "mandatedAction", "itemId", "itemElementType", "userElementType", "ext"}
)
@XmlRootElement(
        name = "CheckInItem"
)
public class CheckInItem {
    @XmlElement(
            name = "InitiationHeader"
    )
    protected InitiationHeader initiationHeader;
    @XmlElement(
            name = "MandatedAction"
    )
    protected MandatedAction mandatedAction;
    @XmlElement(
            name = "ItemId",
            required = true
    )
    protected ItemId itemId;
    @XmlElement(
            name = "ItemElementType"
    )
    protected List<SchemeValuePair> itemElementType;
    @XmlElement(
            name = "UserElementType"
    )
    protected List<SchemeValuePair> userElementType;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public CheckInItem() {
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

    public ItemId getItemId() {
        return this.itemId;
    }

    public void setItemId(ItemId value) {
        this.itemId = value;
    }

    public List<SchemeValuePair> getItemElementType() {
        if (this.itemElementType == null) {
            this.itemElementType = new ArrayList();
        }

        return this.itemElementType;
    }

    public List<SchemeValuePair> getUserElementType() {
        if (this.userElementType == null) {
            this.userElementType = new ArrayList();
        }

        return this.userElementType;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
