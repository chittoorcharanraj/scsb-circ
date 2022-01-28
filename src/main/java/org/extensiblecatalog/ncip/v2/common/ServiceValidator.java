package org.extensiblecatalog.ncip.v2.common;

import org.extensiblecatalog.ncip.v2.service.ServiceContext;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;

public interface ServiceValidator extends ToolkitComponent {
    String COMPONENT_NAME = ServiceValidator.class.getSimpleName();

    ServiceContext getInitialServiceContext() throws ToolkitException;
}
