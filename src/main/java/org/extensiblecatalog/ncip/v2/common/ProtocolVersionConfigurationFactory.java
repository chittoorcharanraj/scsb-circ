package org.extensiblecatalog.ncip.v2.common;

import java.util.Properties;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtocolVersionConfigurationFactory extends BaseConfigurationFactory<ProtocolVersionConfiguration> {
    private static final Logger logger = LoggerFactory.getLogger(ProtocolVersionConfigurationFactory.class);
    protected ProtocolVersionConfiguration configuration;

    public ProtocolVersionConfigurationFactory() throws ToolkitException {
    }

    public ProtocolVersionConfigurationFactory(String appName) throws ToolkitException {
        this.configuration = buildConfiguration(appName);
    }

    public ProtocolVersionConfigurationFactory(String appName, Properties properties) throws ToolkitException {
        this.configuration = buildConfiguration(appName, properties);
    }

    public ProtocolVersionConfigurationFactory(Properties properties) throws ToolkitException {
        this.configuration = buildConfiguration(properties);
    }

    public ProtocolVersionConfigurationFactory(ProtocolVersionConfiguration configInstance) throws ToolkitException {
        this.configuration = configInstance;
    }

    public ProtocolVersionConfiguration getConfiguration() {
        return this.configuration;
    }

    public static ProtocolVersionConfiguration buildConfiguration() throws ToolkitException {
        return buildConfiguration((String)null, (Properties)null);
    }

    public static ProtocolVersionConfiguration buildConfiguration(Properties properties) throws ToolkitException {
        return buildConfiguration((String)null, properties);
    }

    public static ProtocolVersionConfiguration buildConfiguration(String appName) throws ToolkitException {
        return buildConfiguration(appName, (Properties)null);
    }

    public static ProtocolVersionConfiguration buildConfiguration(String appName, Properties properties) throws ToolkitException {
        ProtocolVersionConfiguration config = (ProtocolVersionConfiguration)buildConfiguration(appName, ProtocolVersion.COMPONENT_NAME, "ProtocolVersionConfiguration.SpringConfigFile", ProtocolVersionConfiguration.PROTOCOL_VERSION_CONFIG_FILE_NAME_DEFAULT, properties, "ProtocolVersionConfiguration.ConfigClass", ProtocolVersionConfiguration.PROTOCOL_VERSION_CONFIG_CLASS_NAME_DEFAULT, "ProtocolVersionConfiguration.PropertiesFile", "protocolversion.properties", "ProtocolVersionConfiguration.LocalPropertiesFile", "${ToolkitConfiguration.AppName}protocolversion.properties", "ProtocolVersionConfiguration.PropertiesFileOverride", ProtocolVersionConfiguration.PROTOCOL_VERSION_CONFIG_PROPERTIES_FILE_OVERRIDE_DEFAULT);
        return config;
    }
}
