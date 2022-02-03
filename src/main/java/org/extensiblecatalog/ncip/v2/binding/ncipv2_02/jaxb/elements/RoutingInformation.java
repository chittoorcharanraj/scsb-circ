package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"routingInstructions", "destination", "requestType", "userId", "nameInformation", "ext"}
)
@XmlRootElement(
        name = "RoutingInformation"
)
public class RoutingInformation {
    @XmlElement(
            name = "RoutingInstructions",
            required = true
    )
    protected String routingInstructions;
    @XmlElement(
            name = "Destination",
            required = true
    )
    protected Destination destination;
    @XmlElement(
            name = "RequestType"
    )
    protected SchemeValuePair requestType;
    @XmlElement(
            name = "UserId"
    )
    protected UserId userId;
    @XmlElement(
            name = "NameInformation"
    )
    protected NameInformation nameInformation;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public RoutingInformation() {
    }

    public String getRoutingInstructions() {
        return this.routingInstructions;
    }

    public void setRoutingInstructions(String value) {
        this.routingInstructions = value;
    }

    public Destination getDestination() {
        return this.destination;
    }

    public void setDestination(Destination value) {
        this.destination = value;
    }

    public SchemeValuePair getRequestType() {
        return this.requestType;
    }

    public void setRequestType(SchemeValuePair value) {
        this.requestType = value;
    }

    public UserId getUserId() {
        return this.userId;
    }

    public void setUserId(UserId value) {
        this.userId = value;
    }

    public NameInformation getNameInformation() {
        return this.nameInformation;
    }

    public void setNameInformation(NameInformation value) {
        this.nameInformation = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
