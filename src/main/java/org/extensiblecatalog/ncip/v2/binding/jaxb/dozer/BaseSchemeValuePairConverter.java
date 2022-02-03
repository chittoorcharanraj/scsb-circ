package org.extensiblecatalog.ncip.v2.binding.jaxb.dozer;

import org.dozer.DozerConverter;
import org.dozer.MappingException;
import org.extensiblecatalog.ncip.v2.binding.jaxb.JAXBHelper;
import org.extensiblecatalog.ncip.v2.service.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.ServiceHelper;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;

public class BaseSchemeValuePairConverter<JAXBSVP, SVCSVP extends SchemeValuePair> extends DozerConverter<JAXBSVP, SVCSVP> {
    protected final Class jaxbSVPClass;
    protected final Class<SVCSVP> serviceSVPClass;

    public BaseSchemeValuePairConverter(Class jaxbSVPClass, Class serviceSVPClass) {
        super(jaxbSVPClass, serviceSVPClass);
        this.jaxbSVPClass = jaxbSVPClass;
        this.serviceSVPClass = serviceSVPClass;
    }

    public SVCSVP convertTo(JAXBSVP source, SVCSVP destination) {
        SVCSVP result = null;
        if (source != null) {
            try {
                result = ServiceHelper.findSchemeValuePair(this.serviceSVPClass, JAXBHelper.getScheme(source), JAXBHelper.getValue(source));
            } catch (ToolkitException var5) {
                throw new MappingException(var5);
            }
        } else if (destination != null) {
            throw new MappingException("Source is null but destination is not null.");
        }

        return result;
    }

    public JAXBSVP convertFrom(SVCSVP source, JAXBSVP destination) {
        JAXBSVP result = null;
        if (source != null) {
            if (destination != null) {
                result = destination;
                JAXBHelper.setScheme(destination, source.getScheme());
                JAXBHelper.setValue(destination, source.getValue());
            } else {
                try {
                    result = (JAXBSVP) JAXBHelper.createJAXBSchemeValuePair(this.jaxbSVPClass, source.getScheme(), source.getValue());
                } catch (IllegalAccessException var5) {
                    throw new MappingException(var5);
                } catch (InstantiationException var6) {
                    throw new MappingException(var6);
                }
            }
        } else if (destination != null) {
            throw new MappingException("Source is null but destination is not null.");
        }

        return result;
    }
}
