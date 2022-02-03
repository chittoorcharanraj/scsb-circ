package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import org.extensiblecatalog.ncip.v2.binding.jaxb.DatatypeConverter;

public class Adapter1 extends XmlAdapter<String, XMLGregorianCalendar> {
    public Adapter1() {
    }

    public XMLGregorianCalendar unmarshal(String value) {
        return DatatypeConverter.parseDateTime(value);
    }

    public String marshal(XMLGregorianCalendar value) {
        return DatatypeConverter.printDateTime(value);
    }
}
