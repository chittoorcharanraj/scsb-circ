package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import java.math.BigDecimal;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter2 extends XmlAdapter<String, BigDecimal> {
    public Adapter2() {
    }

    public BigDecimal unmarshal(String value) {
        return new BigDecimal(value);
    }

    public String marshal(BigDecimal value) {
        return value == null ? null : value.toString();
    }
}
