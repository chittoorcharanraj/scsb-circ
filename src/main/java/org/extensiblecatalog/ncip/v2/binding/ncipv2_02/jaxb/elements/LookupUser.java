//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

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
        propOrder = {"initiationHeader", "userId", "userElementType", "ext"}
)
@XmlRootElement(
        name = "LookupUser"
)
public class LookupUser {
    @XmlElement(
            name = "InitiationHeader"
    )
    protected InitiationHeader initiationHeader;
    @XmlElement(
            name = "UserId"
    )
    protected UserId userId;
    @XmlElement(
            name = "UserElementType"
    )
    protected List<SchemeValuePair> userElementType;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public LookupUser() {
    }

    public InitiationHeader getInitiationHeader() {
        return this.initiationHeader;
    }

    public void setInitiationHeader(InitiationHeader value) {
        this.initiationHeader = value;
    }

    public UserId getUserId() {
        return this.userId;
    }

    public void setUserId(UserId value) {
        this.userId = value;
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
