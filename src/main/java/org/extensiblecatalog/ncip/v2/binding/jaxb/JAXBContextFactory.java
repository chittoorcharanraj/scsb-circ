package org.extensiblecatalog.ncip.v2.binding.jaxb;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;

public class JAXBContextFactory {
    protected static Map<String, JAXBContext> sharedJAXBContextInstances = new HashMap();

    public JAXBContextFactory() throws ToolkitException {
    }

    public static synchronized JAXBContext getJAXBContext(String packageNames) throws ToolkitException {
        JAXBContext jaxbContext = (JAXBContext)sharedJAXBContextInstances.get(packageNames);
        if (jaxbContext == null) {
            jaxbContext = getUniqueJAXBContext(packageNames);
            sharedJAXBContextInstances.put(packageNames, jaxbContext);
        }

        return jaxbContext;
    }

    public static JAXBContext getUniqueJAXBContext(String packageNames) throws ToolkitException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(packageNames);
            return jaxbContext;
        } catch (JAXBException var3) {
            throw new ToolkitException("Exception constructing a JAXBContext for package name(s) " + packageNames + ".", var3);
        }
    }
}
