package org.extensiblecatalog.ncip.v2.common;

import java.util.Properties;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageHandlerConfigurationFactory extends BaseConfigurationFactory<MessageHandlerConfiguration> {
    private static final Logger logger = LoggerFactory.getLogger(MessageHandlerConfigurationFactory.class);
    protected MessageHandlerConfiguration configuration;

    public MessageHandlerConfigurationFactory(String appName) throws ToolkitException {
        this.configuration = buildConfiguration(appName);
    }

    public MessageHandlerConfigurationFactory() throws ToolkitException {
    }

    public MessageHandlerConfigurationFactory(String appName, Properties properties) throws ToolkitException {
        this.configuration = buildConfiguration(appName, properties);
    }

    public MessageHandlerConfigurationFactory(Properties properties) throws ToolkitException {
        this.configuration = buildConfiguration(properties);
    }

    public MessageHandlerConfigurationFactory(MessageHandlerConfiguration configInstance) throws ToolkitException {
        this.configuration = configInstance;
    }

    public MessageHandlerConfiguration getConfiguration() {
        return this.configuration;
    }

    public static MessageHandlerConfiguration buildConfiguration() throws ToolkitException {
        return buildConfiguration((String)null, (Properties)null);
    }

    public static MessageHandlerConfiguration buildConfiguration(Properties properties) throws ToolkitException {
        return buildConfiguration((String)null, properties);
    }

    public static MessageHandlerConfiguration buildConfiguration(String appName) throws ToolkitException {
        return buildConfiguration(appName, (Properties)null);
    }

    public static MessageHandlerConfiguration buildConfiguration(String appName, Properties properties) throws ToolkitException {
        MessageHandlerConfiguration config = (MessageHandlerConfiguration)buildConfiguration(appName, MessageHandler.COMPONENT_NAME, "MessageHandlerConfiguration.SpringConfigFile", MessageHandlerConfiguration.MESSAGE_HANDLER_CONFIG_FILE_NAME_DEFAULT, properties, "MessageHandlerConfiguration.ConfigClass", MessageHandlerConfiguration.MESSAGE_HANDLER_CONFIG_CLASS_NAME_DEFAULT, "MessageHandlerConfiguration.PropertiesFile", "messagehandler.properties", "MessageHandlerConfiguration.LocalPropertiesFile", "${ToolkitConfiguration.AppName}messagehandler.properties", "MessageHandlerConfiguration.PropertiesFileOverride", MessageHandlerConfiguration.MESSAGE_HANDLER_CONFIG_PROPERTIES_FILE_OVERRIDE_DEFAULT);
        return config;
    }
}
