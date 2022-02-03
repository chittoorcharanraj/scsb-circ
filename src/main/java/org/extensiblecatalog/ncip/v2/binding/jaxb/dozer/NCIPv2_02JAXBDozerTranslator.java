package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import java.util.Properties;
import org.dozer.DozerBeanMapper;
import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseJAXBDozerTranslator;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.NCIPMessage;
import org.extensiblecatalog.ncip.v2.common.TranslatorConfiguration;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;

public class NCIPv2_02JAXBDozerTranslator extends BaseJAXBDozerTranslator<NCIPMessage> {
    public NCIPv2_02JAXBDozerTranslator() throws ToolkitException {
    }

    public NCIPv2_02JAXBDozerTranslator(Properties properties) throws ToolkitException {
        super(properties);
    }

    public NCIPv2_02JAXBDozerTranslator(TranslatorConfiguration config) throws ToolkitException {
        super(config);
    }

    protected NCIPMessage mapMessage(Object svcMsg, DozerBeanMapper mapper) {
        return (NCIPMessage)mapper.map(svcMsg, NCIPMessage.class);
    }
}
