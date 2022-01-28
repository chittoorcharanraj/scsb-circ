package org.extensiblecatalog.ncip.v2.common;

import java.util.Properties;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TranslatorConfigurationFactory extends BaseConfigurationFactory<TranslatorConfiguration> {
    private static final Logger logger = LoggerFactory.getLogger(TranslatorConfigurationFactory.class);
    protected TranslatorConfiguration configuration;

    public TranslatorConfigurationFactory() throws ToolkitException {
    }

    public TranslatorConfigurationFactory(String appName) throws ToolkitException {
        this.configuration = buildConfiguration(appName);
    }

    public TranslatorConfigurationFactory(String appName, Properties properties) throws ToolkitException {
        this.configuration = buildConfiguration(appName, properties);
    }

    public TranslatorConfigurationFactory(Properties properties) throws ToolkitException {
        this.configuration = buildConfiguration(properties);
    }

    public TranslatorConfigurationFactory(TranslatorConfiguration configInstance) throws ToolkitException {
        this.configuration = configInstance;
    }

    public TranslatorConfiguration getConfiguration() {
        return this.configuration;
    }

    public static TranslatorConfiguration buildConfiguration() throws ToolkitException {
        return buildConfiguration((String)null, (Properties)null);
    }

    public static TranslatorConfiguration buildConfiguration(Properties properties) throws ToolkitException {
        return buildConfiguration((String)null, properties);
    }

    public static TranslatorConfiguration buildConfiguration(String appName) throws ToolkitException {
        return buildConfiguration(appName, (Properties)null);
    }

    public static TranslatorConfiguration buildConfiguration(String appName, Properties properties) throws ToolkitException {
        TranslatorConfiguration config = (TranslatorConfiguration)buildConfiguration(appName, Translator.COMPONENT_NAME, "TranslatorConfiguration.SpringConfigFile", TranslatorConfiguration.TRANSLATOR_CONFIG_FILE_NAME_DEFAULT, properties, "TranslatorConfiguration.ConfigClass", "org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.JAXBDozerNCIP2TranslatorConfiguration", "TranslatorConfiguration.PropertiesFile", "translator.properties", "TranslatorConfiguration.LocalPropertiesFile", "${ToolkitConfiguration.AppName}translator.properties", "TranslatorConfiguration.PropertiesFileOverride", TranslatorConfiguration.TRANSLATOR_CONFIG_PROPERTIES_FILE_OVERRIDE_DEFAULT);
        return config;
    }
}
