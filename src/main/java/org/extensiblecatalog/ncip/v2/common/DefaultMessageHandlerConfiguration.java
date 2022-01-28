package org.extensiblecatalog.ncip.v2.common;

import java.util.Properties;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultMessageHandlerConfiguration extends BaseToolkitConfiguration implements MessageHandlerConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(DefaultMessageHandlerConfiguration.class);
    protected String messageHandlerClassName;

    public DefaultMessageHandlerConfiguration() throws ToolkitException {
        this.messageHandlerClassName = MessageHandlerConfiguration.MESSAGE_HANDLER_CLASS_NAME_DEFAULT;
    }

    public DefaultMessageHandlerConfiguration(String appName) throws ToolkitException {
        this(appName, (Properties)null);
    }

    public DefaultMessageHandlerConfiguration(Properties properties) throws ToolkitException {
        this((String)null, properties);
    }

    public DefaultMessageHandlerConfiguration(String appName, Properties properties) {
        super(appName, properties);
        this.messageHandlerClassName = MessageHandlerConfiguration.MESSAGE_HANDLER_CLASS_NAME_DEFAULT;
        String messageHandlerClassNameString = null;
        if (properties != null) {
            messageHandlerClassNameString = this.properties.getProperty("MessageHandlerConfiguration.ClassName");
        }

        if (messageHandlerClassNameString != null) {
            this.messageHandlerClassName = messageHandlerClassNameString;
        }

    }

    public String getComponentClassName() {
        return this.messageHandlerClassName;
    }

    public void setComponentClassName(String componentClassName) {
        this.messageHandlerClassName = componentClassName;
    }
}
