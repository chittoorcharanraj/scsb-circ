package org.extensiblecatalog.ncip.v2.common;

import org.extensiblecatalog.ncip.v2.service.ToolkitException;

public interface ToolkitComponentConfigurationFactory {
    ToolkitConfiguration getConfiguration() throws ToolkitException;
}
