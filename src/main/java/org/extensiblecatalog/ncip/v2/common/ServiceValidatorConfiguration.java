package org.extensiblecatalog.ncip.v2.common;

public interface ServiceValidatorConfiguration extends ToolkitConfiguration {
    String SERVICE_VALIDATOR_PROPERTIES_FILE_TITLE_KEY = "ServiceValidatorConfiguration.PropertiesFileTitle";
    String SERVICE_VALIDATOR_PROPERTIES_FILE_TITLE_DEFAULT = null;
    String SERVICE_VALIDATOR_LOCAL_PROPERTIES_FILE_TITLE_KEY = "ServiceValidatorConfiguration.LocalPropertiesFileTitle";
    String SERVICE_VALIDATOR_LOCAL_PROPERTIES_FILE_TITLE_DEFAULT = null;
    String SERVICE_VALIDATOR_PROPERTIES_FILENAME_KEY = "ServiceValidatorConfiguration.PropertiesFile";
    String SERVICE_VALIDATOR_PROPERTIES_FILENAME_DEFAULT = "servicevalidator.properties";
    String SERVICE_VALIDATOR_LOCAL_PROPERTIES_FILENAME_KEY = "ServiceValidatorConfiguration.LocalPropertiesFile";
    String SERVICE_VALIDATOR_LOCAL_PROPERTIES_FILENAME_DEFAULT = "${ToolkitConfiguration.AppName}servicevalidator.properties";
    String SERVICE_VALIDATOR_CONFIG_CLASS_NAME_KEY = "ServiceValidatorConfiguration.ConfigClass";
    String SERVICE_VALIDATOR_CONFIG_CLASS_NAME_DEFAULT = DefaultNCIPServiceValidatorConfiguration.class.getName();
    String SERVICE_VALIDATOR_CONFIG_PROPERTIES_FILE_OVERRIDE_KEY = "ServiceValidatorConfiguration.PropertiesFileOverride";
    String SERVICE_VALIDATOR_CONFIG_PROPERTIES_FILE_OVERRIDE_DEFAULT = null;
    String SERVICE_VALIDATOR_CONFIG_FILE_NAME_KEY = "ServiceValidatorConfiguration.SpringConfigFile";
    String SERVICE_VALIDATOR_CONFIG_FILE_NAME_DEFAULT = null;
    String SERVICE_VALIDATOR_CLASS_NAME_KEY = "ServiceValidatorConfiguration.ClassName";
    String SERVICE_VALIDATOR_CLASS_NAME_DEFAULT = DefaultNCIPServiceValidator.class.getName();
    String SERVICE_VALIDATOR_SERVICE_CONTEXT_CLASS_NAME_KEY = "ServiceValidatorConfiguration.ServiceContextClassName";
    String SERVICE_VALIDATOR_SERVICE_CONTEXT_CLASS_NAME_DEFAULT = NCIPServiceContext.class.getName();
}
