package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import java.util.ArrayList;
import java.util.List;
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
        propOrder = {"nameInformation", "userAddressInformation", "dateOfBirth", "userLanguage", "userPrivilege", "blockOrTrap", "userId", "previousUserId", "ext"}
)
@XmlRootElement(
        name = "UserOptionalFields"
)
public class UserOptionalFields {
    @XmlElement(
            name = "NameInformation"
    )
    protected NameInformation nameInformation;
    @XmlElement(
            name = "UserAddressInformation"
    )
    protected List<UserAddressInformation> userAddressInformation;
    @XmlElement(
            name = "DateOfBirth",
            type = String.class
    )
    @XmlJavaTypeAdapter(Adapter1.class)
    @XmlSchemaType(
            name = "dateTime"
    )
    protected XMLGregorianCalendar dateOfBirth;
    @XmlElement(
            name = "UserLanguage"
    )
    protected List<SchemeValuePair> userLanguage;
    @XmlElement(
            name = "UserPrivilege"
    )
    protected List<UserPrivilege> userPrivilege;
    @XmlElement(
            name = "BlockOrTrap"
    )
    protected List<BlockOrTrap> blockOrTrap;
    @XmlElement(
            name = "UserId"
    )
    protected List<UserId> userId;
    @XmlElement(
            name = "PreviousUserId"
    )
    protected List<PreviousUserId> previousUserId;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public UserOptionalFields() {
    }

    public NameInformation getNameInformation() {
        return this.nameInformation;
    }

    public void setNameInformation(NameInformation value) {
        this.nameInformation = value;
    }

    public List<UserAddressInformation> getUserAddressInformation() {
        if (this.userAddressInformation == null) {
            this.userAddressInformation = new ArrayList();
        }

        return this.userAddressInformation;
    }

    public XMLGregorianCalendar getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(XMLGregorianCalendar value) {
        this.dateOfBirth = value;
    }

    public List<SchemeValuePair> getUserLanguage() {
        if (this.userLanguage == null) {
            this.userLanguage = new ArrayList();
        }

        return this.userLanguage;
    }

    public List<UserPrivilege> getUserPrivilege() {
        if (this.userPrivilege == null) {
            this.userPrivilege = new ArrayList();
        }

        return this.userPrivilege;
    }

    public List<BlockOrTrap> getBlockOrTrap() {
        if (this.blockOrTrap == null) {
            this.blockOrTrap = new ArrayList();
        }

        return this.blockOrTrap;
    }

    public List<UserId> getUserId() {
        if (this.userId == null) {
            this.userId = new ArrayList();
        }

        return this.userId;
    }

    public List<PreviousUserId> getPreviousUserId() {
        if (this.previousUserId == null) {
            this.previousUserId = new ArrayList();
        }

        return this.previousUserId;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
