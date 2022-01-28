package org.extensiblecatalog.ncip.v2.common;

import org.extensiblecatalog.ncip.v2.service.NCIPInitiationData;
import org.extensiblecatalog.ncip.v2.service.NCIPResponseData;
import org.extensiblecatalog.ncip.v2.service.ServiceContext;

public interface MessageHandler extends ToolkitComponent {
    String COMPONENT_NAME = MessageHandler.class.getSimpleName();

    NCIPResponseData performService(NCIPInitiationData var1, ServiceContext var2);
}
