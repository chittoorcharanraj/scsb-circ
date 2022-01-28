package org.extensiblecatalog.ncip.v2.common;

import java.util.Properties;

import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TranslatorFactory extends BaseComponentFactory<Translator, TranslatorConfiguration> {
    private static final Logger logger = LoggerFactory.getLogger(TranslatorFactory.class);
    protected Translator translator;

    public TranslatorFactory() throws ToolkitException {
    }

    public TranslatorFactory(Properties properties) throws ToolkitException {
        this.translator = buildTranslator(properties);
    }

    public TranslatorFactory(String appName) throws ToolkitException {
        this.translator = buildTranslator(appName);
    }

    public TranslatorFactory(String appName, Properties properties) throws ToolkitException {
        this.translator = buildTranslator(appName, properties);
    }

    public TranslatorFactory(TranslatorConfiguration configuration) throws ToolkitException {
        this.translator = (Translator)buildComponent(configuration);
    }

    public Translator getComponent() {
        return this.translator;
    }

    public static Translator buildTranslator() throws ToolkitException {
        return buildTranslator((String)null, (Properties)null);
    }

    public static Translator buildTranslator(Properties properties) throws ToolkitException {
        return buildTranslator((String)null, properties);
    }

    public static Translator buildTranslator(String appName) throws ToolkitException {
        return buildTranslator(appName, (Properties)null);
    }

    public static Translator buildTranslator(TranslatorConfiguration configuration) throws ToolkitException {
        return (Translator)buildComponent(configuration);
    }

    public static Translator buildTranslator(String appName, Properties properties) throws ToolkitException {
        Translator trans = (Translator)buildComponent(TranslatorFactory.class, appName, Translator.COMPONENT_NAME, "TranslatorConfiguration.SpringConfigFile", TranslatorConfiguration.TRANSLATOR_CONFIG_FILE_NAME_DEFAULT, properties, "TranslatorConfiguration.PropertiesFile", "translator.properties", "TranslatorConfiguration.LocalPropertiesFile", "${ToolkitConfiguration.AppName}translator.properties", "TranslatorConfiguration.PropertiesFileOverride", TranslatorConfiguration.TRANSLATOR_CONFIG_PROPERTIES_FILE_OVERRIDE_DEFAULT);
        return trans;
    }
}
