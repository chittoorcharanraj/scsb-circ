package org.extensiblecatalog.ncip.v2.common;

import org.apache.logging.log4j.Level;

public interface TranslatorConfiguration extends ToolkitConfiguration {
    String TRANSLATOR_PROPERTIES_FILE_TITLE_KEY = "TranslatorConfiguration.PropertiesFileTitle";
    String TRANSLATOR_PROPERTIES_FILE_TITLE_DEFAULT = null;
    String TRANSLATOR_LOCAL_PROPERTIES_FILE_TITLE_KEY = "TranslatorConfiguration.LocalPropertiesFileTitle";
    String TRANSLATOR_LOCAL_PROPERTIES_FILE_TITLE_DEFAULT = null;
    String TRANSLATOR_CONFIG_CLASS_NAME_KEY = "TranslatorConfiguration.ConfigClass";
    String TRANSLATOR_CONFIG_CLASS_NAME_DEFAULT = "org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.JAXBDozerNCIP2TranslatorConfiguration";
    String TRANSLATOR_PROPERTIES_FILENAME_KEY = "TranslatorConfiguration.PropertiesFile";
    String TRANSLATOR_PROPERTIES_FILENAME_DEFAULT = "translator.properties";
    String TRANSLATOR_LOCAL_PROPERTIES_FILENAME_KEY = "TranslatorConfiguration.LocalPropertiesFile";
    String TRANSLATOR_LOCAL_PROPERTIES_FILENAME_DEFAULT = "${ToolkitConfiguration.AppName}translator.properties";
    String TRANSLATOR_CONFIG_PROPERTIES_FILE_OVERRIDE_KEY = "TranslatorConfiguration.PropertiesFileOverride";
    String TRANSLATOR_CONFIG_PROPERTIES_FILE_OVERRIDE_DEFAULT = null;
    String TRANSLATOR_CONFIG_FILE_NAME_KEY = "TranslatorConfiguration.SpringConfigFile";
    String TRANSLATOR_CONFIG_FILE_NAME_DEFAULT = null;
    String TRANSLATOR_CLASS_NAME_KEY = "TranslatorConfiguration.ClassName";
    String TRANSLATOR_CLASS_NAME_DEFAULT = "org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer.NCIPv2_02JAXBDozerTranslator";
    String TRANSLATOR_LOG_MESSAGES_KEY = "TranslatorConfiguration.LogMessages";
    String TRANSLATOR_LOG_MESSAGES_DEFAULT = "false";
    String TRANSLATOR_MESSAGES_LOGGING_LEVEL_KEY = "TranslatorConfiguration.MessagesLoggingLevel";
    String TRANSLATOR_MESSAGES_LOGGING_LEVEL_DEFAULT = "INFO";

    boolean getLogMessages();

    void setLogMessages(boolean var1);

    Level getMessagesLoggingLevel();

    void setMessagesLoggingLevel(Level var1);
}
