package org.extensiblecatalog.ncip.v2.binding.jaxb.dozer;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import org.dozer.DozerConverter;
import org.dozer.MappingException;

public class BigDecimalConverter extends DozerConverter<JAXBElement, BigDecimal> {
    public BigDecimalConverter() {
        super(JAXBElement.class, BigDecimal.class);
    }

    public BigDecimal convertTo(JAXBElement srcObj, BigDecimal targetBoolean) {
        BigDecimal result = null;
        if (srcObj != null) {
            result = (BigDecimal)srcObj.getValue();
        }

        return result;
    }

    public JAXBElement convertFrom(BigDecimal srcBoolean, JAXBElement targetObj) {
        throw new MappingException("BigDecimalConverter.convertFrom() method entered - this should never be called.");
    }
}
