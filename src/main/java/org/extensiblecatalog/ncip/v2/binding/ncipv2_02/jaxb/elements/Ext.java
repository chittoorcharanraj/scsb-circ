package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"any"}
)
@XmlRootElement(
        name = "Ext"
)
public class Ext {
    @XmlAnyElement(
            lax = true
    )
    protected List<Object> any;

    public Ext() {
    }

    public List<Object> getAny() {
        if (this.any == null) {
            this.any = new ArrayList();
        }

        return this.any;
    }
}
