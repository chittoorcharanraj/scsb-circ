package org.extensiblecatalog.ncip.v2.common;

import java.util.Properties;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectorConfigurationFactory extends BaseConfigurationFactory<ConnectorConfiguration> {
    private static final Logger logger = LoggerFactory.getLogger(ConnectorConfigurationFactory.class);
    protected ConnectorConfiguration configuration;

    public ConnectorConfigurationFactory() throws ToolkitException {
    }

    public ConnectorConfigurationFactory(String appName) throws ToolkitException {
        this.configuration = buildConfiguration(appName);
    }

    public ConnectorConfigurationFactory(String appName, Properties properties) throws ToolkitException {
        this.configuration = buildConfiguration(appName, properties);
    }

    public ConnectorConfigurationFactory(Properties properties) throws ToolkitException {
        this.configuration = buildConfiguration(properties);
    }

    public ConnectorConfigurationFactory(ConnectorConfiguration configInstance) throws ToolkitException {
        this.configuration = configInstance;
    }

    public ConnectorConfiguration getConfiguration() {
        return this.configuration;
    }

    public static ConnectorConfiguration buildConfiguration() throws ToolkitException {
        return buildConfiguration((String)null, (Properties)null);
    }

    public static ConnectorConfiguration buildConfiguration(Properties properties) throws ToolkitException {
        return buildConfiguration((String)null, properties);
    }

    public static ConnectorConfiguration buildConfiguration(String appName) throws ToolkitException {
        return buildConfiguration(appName, (Properties)null);
    }

    public static ConnectorConfiguration buildConfiguration(String appName, Properties properties) throws ToolkitException {
        ConnectorConfiguration config = (ConnectorConfiguration)buildConfiguration(appName, Connector.COMPONENT_NAME, "ConnectorConfiguration.SpringConfigFile", ConnectorConfiguration.CONNECTOR_CONFIG_FILE_NAME_DEFAULT, properties, "ConnectorConfiguration.ConfigClass", ConnectorConfiguration.CONNECTOR_CONFIG_CLASS_NAME_DEFAULT, "ConnectorConfiguration.PropertiesFile", "connector.properties", "ConnectorConfiguration.LocalPropertiesFile", "${ToolkitConfiguration.AppName}connector.properties", "ConnectorConfiguration.PropertiesFileOverride", ConnectorConfiguration.CONNECTOR_CONFIG_PROPERTIES_FILE_OVERRIDE_DEFAULT);
        return config;
    }
}
