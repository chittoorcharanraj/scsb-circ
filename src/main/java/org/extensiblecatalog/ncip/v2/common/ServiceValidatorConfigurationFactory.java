package org.extensiblecatalog.ncip.v2.common;

import java.util.Properties;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceValidatorConfigurationFactory extends BaseConfigurationFactory<ServiceValidatorConfiguration> {
    private static final Logger logger = LoggerFactory.getLogger(ServiceValidatorConfigurationFactory.class);
    protected ServiceValidatorConfiguration configuration;

    public ServiceValidatorConfigurationFactory() throws ToolkitException {
    }

    public ServiceValidatorConfigurationFactory(String appName) throws ToolkitException {
        this.configuration = buildConfiguration(appName);
    }

    public ServiceValidatorConfigurationFactory(String appName, Properties properties) throws ToolkitException {
        this.configuration = buildConfiguration(appName, properties);
    }

    public ServiceValidatorConfigurationFactory(Properties properties) throws ToolkitException {
        this.configuration = buildConfiguration(properties);
    }

    public ServiceValidatorConfigurationFactory(ServiceValidatorConfiguration configInstance) throws ToolkitException {
        this.configuration = configInstance;
    }

    public ServiceValidatorConfiguration getConfiguration() {
        return this.configuration;
    }

    public static ServiceValidatorConfiguration buildConfiguration() throws ToolkitException {
        return buildConfiguration((String)null, (Properties)null);
    }

    public static ServiceValidatorConfiguration buildConfiguration(Properties properties) throws ToolkitException {
        return buildConfiguration((String)null, properties);
    }

    public static ServiceValidatorConfiguration buildConfiguration(String appName) throws ToolkitException {
        return buildConfiguration(appName, (Properties)null);
    }

    public static ServiceValidatorConfiguration buildConfiguration(String appName, Properties properties) throws ToolkitException {
        ServiceValidatorConfiguration config = (ServiceValidatorConfiguration)buildConfiguration(appName, ServiceValidator.COMPONENT_NAME, "ServiceValidatorConfiguration.SpringConfigFile", ServiceValidatorConfiguration.SERVICE_VALIDATOR_CONFIG_FILE_NAME_DEFAULT, properties, "ServiceValidatorConfiguration.ConfigClass", ServiceValidatorConfiguration.SERVICE_VALIDATOR_CONFIG_CLASS_NAME_DEFAULT, "ServiceValidatorConfiguration.PropertiesFile", "servicevalidator.properties", "ServiceValidatorConfiguration.LocalPropertiesFile", "${ToolkitConfiguration.AppName}servicevalidator.properties", "ServiceValidatorConfiguration.PropertiesFileOverride", ServiceValidatorConfiguration.SERVICE_VALIDATOR_CONFIG_PROPERTIES_FILE_OVERRIDE_DEFAULT);
        return config;
    }
}
