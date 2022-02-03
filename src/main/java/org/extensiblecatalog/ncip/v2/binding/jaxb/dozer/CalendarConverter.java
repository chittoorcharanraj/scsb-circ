package org.extensiblecatalog.ncip.v2.binding.jaxb.dozer;

import java.util.GregorianCalendar;
import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;
import org.dozer.DozerConverter;
import org.dozer.MappingException;

public class CalendarConverter extends DozerConverter<JAXBElement, GregorianCalendar> {
    public CalendarConverter() {
        super(JAXBElement.class, GregorianCalendar.class);
    }

    public GregorianCalendar convertTo(JAXBElement srcObj, GregorianCalendar targetCalendar) {
        GregorianCalendar result = null;
        if (srcObj != null) {
            XMLGregorianCalendar calendar = (XMLGregorianCalendar)srcObj.getValue();
            result = calendar.toGregorianCalendar();
        }

        return result;
    }

    public JAXBElement convertFrom(GregorianCalendar srcCalendar, JAXBElement targetObj) {
        throw new MappingException("CalendarConverter.convertFrom() method entered - this should never be called.");
    }
}
