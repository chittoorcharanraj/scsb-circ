//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

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
        name = "Destination"
)
public class Destination {
    @XmlElementRefs({@XmlElementRef(
            name = "Location",
            namespace = "http://www.niso.org/2008/ncip",
            type = Location.class
    ), @XmlElementRef(
            name = "BinNumber",
            namespace = "http://www.niso.org/2008/ncip",
            type = JAXBElement.class
    ), @XmlElementRef(
            name = "Ext",
            namespace = "http://www.niso.org/2008/ncip",
            type = Ext.class
    )})
    protected List<Object> content;

    public Destination() {
    }

    public List<Object> getContent() {
        if (this.content == null) {
            this.content = new ArrayList();
        }

        return this.content;
    }
}
