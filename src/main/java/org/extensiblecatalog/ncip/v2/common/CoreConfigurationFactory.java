package org.extensiblecatalog.ncip.v2.common;

import java.util.Properties;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoreConfigurationFactory extends BaseConfigurationFactory<CoreConfiguration> {
    private static final Logger logger = LoggerFactory.getLogger(CoreConfigurationFactory.class);
    protected CoreConfiguration configuration;

    public CoreConfigurationFactory() throws ToolkitException {
    }

    public CoreConfigurationFactory(String appName) throws ToolkitException {
        this.configuration = buildConfiguration(appName);
    }

    public CoreConfigurationFactory(String appName, Properties properties) throws ToolkitException {
        this.configuration = buildConfiguration(appName, properties);
    }

    public CoreConfigurationFactory(Properties properties) throws ToolkitException {
        this.configuration = buildConfiguration(properties);
    }

    public CoreConfigurationFactory(CoreConfiguration configInstance) throws ToolkitException {
        this.configuration = configInstance;
    }

    public CoreConfiguration getConfiguration() {
        return this.configuration;
    }

    public static CoreConfiguration buildConfiguration() throws ToolkitException {
        return buildConfiguration((String)null, (Properties)null);
    }

    public static CoreConfiguration buildConfiguration(Properties properties) throws ToolkitException {
        return buildConfiguration((String)null, properties);
    }

    public static CoreConfiguration buildConfiguration(String appName) throws ToolkitException {
        return buildConfiguration(appName, (Properties)null);
    }

    public static CoreConfiguration buildConfiguration(String appName, Properties properties) throws ToolkitException {
        CoreConfiguration config = (CoreConfiguration)buildConfiguration(appName, Core.COMPONENT_NAME, "CoreConfiguration.SpringConfigFile", CoreConfiguration.CORE_CONFIG_FILE_NAME_DEFAULT, properties, "CoreConfiguration.ConfigClass", CoreConfiguration.CORE_CONFIG_CLASS_NAME_DEFAULT, "CoreConfiguration.PropertiesFile", "core.properties", "CoreConfiguration.LocalPropertiesFile", "${ToolkitConfiguration.AppName}core.properties", "CoreConfiguration.PropertiesFileOverride", CoreConfiguration.CORE_CONFIG_PROPERTIES_FILE_OVERRIDE_DEFAULT);
        return config;
    }
}
