package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"content"}
)
@XmlRootElement(
        name = "RequestItem"
)
public class RequestItem {
    @XmlElementRefs({@XmlElementRef(
            name = "ItemId",
            namespace = "http://www.niso.org/2008/ncip",
            type = ItemId.class
    ), @XmlElementRef(
            name = "UserElementType",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "InitiationHeader",
            namespace = "http://www.niso.org/2008/ncip",
            type = InitiationHeader.class
    ), @XmlElementRef(
            name = "MandatedAction",
            namespace = "http://www.niso.org/2008/ncip",
            type = MandatedAction.class
    ), @XmlElementRef(
            name = "UserId",
            namespace = "http://www.niso.org/2008/ncip",
            type = UserId.class
    ), @XmlElementRef(
            name = "NeedBeforeDate",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "BibliographicId",
            namespace = "http://www.niso.org/2008/ncip",
            type = BibliographicId.class
    ), @XmlElementRef(
            name = "RequestType",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "PickupExpiryDate",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "ItemElementType",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "RequestId",
            namespace = "http://www.niso.org/2008/ncip",
            type = RequestId.class
    ), @XmlElementRef(
            name = "AcknowledgedItemUseRestrictionType",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "EarliestDateNeeded",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "PickupLocation",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "ItemOptionalFields",
            namespace = "http://www.niso.org/2008/ncip",
            type = ItemOptionalFields.class
    ), @XmlElementRef(
            name = "RequestScopeType",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "Ext",
            namespace = "http://www.niso.org/2008/ncip",
            type = Ext.class
    )})
    protected List<Object> content;

    public RequestItem() {
    }

    public List<Object> getContent() {
        if (this.content == null) {
            this.content = new ArrayList();
        }

        return this.content;
    }
}
