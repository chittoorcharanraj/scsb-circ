//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.binding.jaxb;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.extensiblecatalog.ncip.v2.service.PhysicalAddressType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatatypeConverter {
    private static final Logger logger = LoggerFactory.getLogger(DatatypeConverter.class);
    private static final TimeZone UTC_TIMEZONE = TimeZone.getTimeZone("Etc/UTC");
    private static final DatatypeFactory datatypeFactory;
    protected static Pattern timeHasExcessMillisecondsPattern;

    public DatatypeConverter() {
    }

    public static XMLGregorianCalendar parseDateTime(String value) {
        if (value != null) {
            String originalValue = value;
            Matcher matcher = timeHasExcessMillisecondsPattern.matcher(value);
            if (matcher.matches()) {
                value = matcher.group(1) + matcher.group(3);
                if (logger.isDebugEnabled() && matcher.group(2).length() > 0) {
                    logger.debug("Stripped sub-millsecond portion of time '" + originalValue + "', leaving '" + value + "'.");
                }
            }
        }

        return datatypeFactory.newXMLGregorianCalendar(value);
    }

    public static String printDateTime(XMLGregorianCalendar calendar) {
        TimeZone tz = calendar.getTimeZone(-2147483648);
        String result;
        if (tz.hasSameRules(UTC_TIMEZONE)) {
            result = javax.xml.bind.DatatypeConverter.printDateTime(calendar.toGregorianCalendar());
        } else {
            Date utcDateTime = calendar.toGregorianCalendar().getTime();
            GregorianCalendar utcCalendar = (GregorianCalendar)GregorianCalendar.getInstance(TimeZone.getTimeZone("Etc/UTC"));
            utcCalendar.setTime(utcDateTime);
            result = javax.xml.bind.DatatypeConverter.printDateTime(utcCalendar);
        }

        return result;
    }

    static {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException var1) {
            logger.error("Exception creating a new instance of JAXBContext:", var1);
            throw new ExceptionInInitializerError(var1);
        }

        timeHasExcessMillisecondsPattern = Pattern.compile("(.*T[0-9]{2}:[0-9]{2}:[0-9]{2}\\.[0-9]{3})([0-9]+)((Z)?)$");
    }
}
