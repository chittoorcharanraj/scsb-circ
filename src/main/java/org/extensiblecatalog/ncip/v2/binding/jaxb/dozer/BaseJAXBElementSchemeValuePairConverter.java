package org.extensiblecatalog.ncip.v2.binding.jaxb.dozer;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBElement;
import org.dozer.DozerConverter;
import org.dozer.MappingException;
import org.extensiblecatalog.ncip.v2.binding.jaxb.JAXBHelper;
import org.extensiblecatalog.ncip.v2.service.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.ServiceHelper;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;

public class BaseJAXBElementSchemeValuePairConverter<JAXBSVP, SVCSVP extends SchemeValuePair> extends DozerConverter<JAXBSVP, SVCSVP> {
    protected static final Map<Class, Method> findMethodsByClass = new HashMap();
    protected final Class jaxbSVPClass;
    protected final Class<SVCSVP> serviceSVPClass;

    public BaseJAXBElementSchemeValuePairConverter(Class jaxbSVPClass, Class serviceSVPClass) {
        super(jaxbSVPClass, serviceSVPClass);
        this.jaxbSVPClass = jaxbSVPClass;
        this.serviceSVPClass = serviceSVPClass;
    }

    public SVCSVP convertTo(JAXBSVP source, SVCSVP destination) {
        SVCSVP result = null;
        if (source != null) {
            try {
                result = ServiceHelper.findSchemeValuePair(this.serviceSVPClass, JAXBHelper.getScheme(((JAXBElement)source).getValue()), JAXBHelper.getValue(((JAXBElement)source).getValue()));
            } catch (ToolkitException var5) {
                throw new MappingException(var5);
            }
        } else if (destination != null) {
            throw new MappingException("Source is null but destination is not null.");
        }

        return result;
    }

    public JAXBSVP convertFrom(SVCSVP source, JAXBSVP destination) {
        throw new MappingException("Unsupported mapping from service.SchemeValuePair to JAXBElement.");
    }
}
