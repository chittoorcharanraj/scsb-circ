//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "SchemeValuePair",
        propOrder = {"value"}
)
public class SchemeValuePair {
    @XmlValue
    protected String value;
    @XmlAttribute(
            name = "Scheme",
            namespace = "http://www.niso.org/2008/ncip"
    )
    @XmlSchemaType(
            name = "anyURI"
    )
    protected String scheme;

    public SchemeValuePair() {
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getScheme() {
        return this.scheme;
    }

    public void setScheme(String value) {
        this.scheme = value;
    }
}
