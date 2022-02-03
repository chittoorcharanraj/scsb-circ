package org.extensiblecatalog.ncip.v2.binding.jaxb.dozer;

import javax.xml.bind.JAXBElement;
import org.dozer.DozerConverter;
import org.dozer.MappingException;

public class StringConverter extends DozerConverter<JAXBElement, String> {
    public StringConverter() {
        super(JAXBElement.class, String.class);
    }

    public String convertTo(JAXBElement srcObj, String targetBoolean) {
        String result = null;
        if (srcObj != null) {
            result = (String)srcObj.getValue();
        }

        return result;
    }

    public JAXBElement convertFrom(String srcBoolean, JAXBElement targetObj) {
        throw new MappingException("StringConverter.convertFrom() method entered - this should never be called.");
    }
}
