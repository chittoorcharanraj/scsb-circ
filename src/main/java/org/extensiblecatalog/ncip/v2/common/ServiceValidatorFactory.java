//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.common;

import java.util.Properties;
import org.slf4j.Logger;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.LoggerFactory;

public class ServiceValidatorFactory extends BaseComponentFactory<ServiceValidator, ServiceValidatorConfiguration> {
    private static final Logger LOG = LoggerFactory.getLogger(ServiceValidatorFactory.class);
    protected ServiceValidator serviceValidator;

    public ServiceValidatorFactory() throws ToolkitException {
    }

    public ServiceValidatorFactory(Properties properties) throws ToolkitException {
        this.serviceValidator = buildServiceValidator(properties);
    }

    public ServiceValidatorFactory(String appName) throws ToolkitException {
        this.serviceValidator = buildServiceValidator(appName);
    }

    public ServiceValidatorFactory(String appName, Properties properties) throws ToolkitException {
        this.serviceValidator = buildServiceValidator(appName, properties);
    }

    public ServiceValidatorFactory(ServiceValidatorConfiguration configuration) throws ToolkitException {
        this.serviceValidator = (ServiceValidator)buildComponent(configuration);
    }

    public ServiceValidator getComponent() {
        return this.serviceValidator;
    }

    public static ServiceValidator buildServiceValidator() throws ToolkitException {
        return buildServiceValidator((String)null, (Properties)null);
    }

    public static ServiceValidator buildServiceValidator(Properties properties) throws ToolkitException {
        return buildServiceValidator((String)null, properties);
    }

    public static ServiceValidator buildServiceValidator(String appName) throws ToolkitException {
        return buildServiceValidator(appName, (Properties)null);
    }

    public static ServiceValidator buildServiceValidator(ServiceValidatorConfiguration configuration) throws ToolkitException {
        return (ServiceValidator)buildComponent(configuration);
    }

    public static ServiceValidator buildServiceValidator(String appName, Properties properties) throws ToolkitException {
        ServiceValidator sv = (ServiceValidator)buildComponent(ServiceValidatorFactory.class, appName, ServiceValidator.COMPONENT_NAME, "ServiceValidatorConfiguration.SpringConfigFile", ServiceValidatorConfiguration.SERVICE_VALIDATOR_CONFIG_FILE_NAME_DEFAULT, properties, "ServiceValidatorConfiguration.PropertiesFile", "servicevalidator.properties", "ServiceValidatorConfiguration.LocalPropertiesFile", "${ToolkitConfiguration.AppName}servicevalidator.properties", "ServiceValidatorConfiguration.PropertiesFileOverride", ServiceValidatorConfiguration.SERVICE_VALIDATOR_CONFIG_PROPERTIES_FILE_OVERRIDE_DEFAULT);
        return sv;
    }
}
