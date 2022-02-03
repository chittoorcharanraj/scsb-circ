package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"callNumber", "copyNumber", "itemDescriptionLevel", "numberOfPieces", "ext"}
)
@XmlRootElement(
        name = "ItemDescription"
)
public class ItemDescription {
    @XmlElement(
            name = "CallNumber"
    )
    protected String callNumber;
    @XmlElement(
            name = "CopyNumber"
    )
    protected String copyNumber;
    @XmlElement(
            name = "ItemDescriptionLevel"
    )
    protected SchemeValuePair itemDescriptionLevel;
    @XmlElement(
            name = "NumberOfPieces",
            type = String.class
    )
    protected BigDecimal numberOfPieces;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public ItemDescription() {
    }

    public String getCallNumber() {
        return this.callNumber;
    }

    public void setCallNumber(String value) {
        this.callNumber = value;
    }

    public String getCopyNumber() {
        return this.copyNumber;
    }

    public void setCopyNumber(String value) {
        this.copyNumber = value;
    }

    public SchemeValuePair getItemDescriptionLevel() {
        return this.itemDescriptionLevel;
    }

    public void setItemDescriptionLevel(SchemeValuePair value) {
        this.itemDescriptionLevel = value;
    }

    public BigDecimal getNumberOfPieces() {
        return this.numberOfPieces;
    }

    public void setNumberOfPieces(BigDecimal value) {
        this.numberOfPieces = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
