package org.extensiblecatalog.ncip.v2.common;

public interface MessageHandlerConfiguration extends ToolkitConfiguration {
    String MESSAGE_HANDLER_PROPERTIES_FILE_TITLE_KEY = "MessageHandlerConfiguration.PropertiesFileTitle";
    String MESSAGE_HANDLER_PROPERTIES_FILE_TITLE_DEFAULT = null;
    String MESSAGE_HANDLER_LOCAL_PROPERTIES_FILE_TITLE_KEY = "MessageHandlerConfiguration.LocalPropertiesFileTitle";
    String MESSAGE_HANDLER_LOCAL_PROPERTIES_FILE_TITLE_DEFAULT = null;
    String MESSAGE_HANDLER_CONFIG_CLASS_NAME_KEY = "MessageHandlerConfiguration.ConfigClass";
    String MESSAGE_HANDLER_CONFIG_CLASS_NAME_DEFAULT = DefaultMessageHandlerConfiguration.class.getName();
    String MESSAGE_HANDLER_PROPERTIES_FILENAME_KEY = "MessageHandlerConfiguration.PropertiesFile";
    String MESSAGE_HANDLER_PROPERTIES_FILENAME_DEFAULT = "messagehandler.properties";
    String MESSAGE_HANDLER_LOCAL_PROPERTIES_FILENAME_KEY = "MessageHandlerConfiguration.LocalPropertiesFile";
    String MESSAGE_HANDLER_LOCAL_PROPERTIES_FILENAME_DEFAULT = "${ToolkitConfiguration.AppName}messagehandler.properties";
    String MESSAGE_HANDLER_CONFIG_PROPERTIES_FILE_OVERRIDE_KEY = "MessageHandlerConfiguration.PropertiesFileOverride";
    String MESSAGE_HANDLER_CONFIG_PROPERTIES_FILE_OVERRIDE_DEFAULT = null;
    String MESSAGE_HANDLER_CONFIG_FILE_NAME_KEY = "MessageHandlerConfiguration.SpringConfigFile";
    String MESSAGE_HANDLER_CONFIG_FILE_NAME_DEFAULT = null;
    String MESSAGE_HANDLER_CLASS_NAME_KEY = "MessageHandlerConfiguration.ClassName";
    String MESSAGE_HANDLER_CLASS_NAME_DEFAULT = MappedMessageHandler.class.getName();
}
