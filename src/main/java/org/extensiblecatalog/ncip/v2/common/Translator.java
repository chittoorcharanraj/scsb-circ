package org.extensiblecatalog.ncip.v2.common;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.extensiblecatalog.ncip.v2.service.NCIPInitiationData;
import org.extensiblecatalog.ncip.v2.service.NCIPResponseData;
import org.extensiblecatalog.ncip.v2.service.ServiceContext;
import org.extensiblecatalog.ncip.v2.service.ServiceException;
import org.extensiblecatalog.ncip.v2.service.ValidationException;

public interface Translator extends ToolkitComponent {
    String COMPONENT_NAME = Translator.class.getSimpleName();

    NCIPInitiationData createInitiationData(ServiceContext var1, InputStream var2) throws ServiceException, ValidationException;

    NCIPResponseData createResponseData(ServiceContext var1, InputStream var2) throws ServiceException, ValidationException;

    ByteArrayInputStream createInitiationMessageStream(ServiceContext var1, NCIPInitiationData var2) throws ServiceException, ValidationException;

    ByteArrayInputStream createResponseMessageStream(ServiceContext var1, NCIPResponseData var2) throws ServiceException, ValidationException;
}
