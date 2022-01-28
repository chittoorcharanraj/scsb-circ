package org.extensiblecatalog.ncip.v2.common;

public interface ProtocolVersionConfiguration extends ToolkitConfiguration {
    String PROTOCOL_VERSION_PROPERTIES_FILE_TITLE_KEY = "ProtocolVersionConfiguration.PropertiesFileTitle";
    String PROTOCOL_VERSION_PROPERTIES_FILE_TITLE_DEFAULT = null;
    String PROTOCOL_VERSION_LOCAL_PROPERTIES_FILE_TITLE_KEY = "ProtocolVersionConfiguration.LocalPropertiesFileTitle";
    String PROTOCOL_VERSION_LOCAL_PROPERTIES_FILE_TITLE_DEFAULT = null;
    String PROTOCOL_VERSION_CONFIG_CLASS_NAME_KEY = "ProtocolVersionConfiguration.ConfigClass";
    String PROTOCOL_VERSION_CONFIG_CLASS_NAME_DEFAULT = DefaultNCIPProtocolVersionConfiguration.class.getName();
    String PROTOCOL_VERSION_PROPERTIES_FILENAME_KEY = "ProtocolVersionConfiguration.PropertiesFile";
    String PROTOCOL_VERSION_PROPERTIES_FILENAME_DEFAULT = "protocolversion.properties";
    String PROTOCOL_VERSION_LOCAL_PROPERTIES_FILENAME_KEY = "ProtocolVersionConfiguration.LocalPropertiesFile";
    String PROTOCOL_VERSION_LOCAL_PROPERTIES_FILENAME_DEFAULT = "${ToolkitConfiguration.AppName}protocolversion.properties";
    String PROTOCOL_VERSION_CONFIG_PROPERTIES_FILE_OVERRIDE_KEY = "ProtocolVersionConfiguration.PropertiesFileOverride";
    String PROTOCOL_VERSION_CONFIG_PROPERTIES_FILE_OVERRIDE_DEFAULT = null;
    String PROTOCOL_VERSION_CONFIG_FILE_NAME_KEY = "ProtocolVersionConfiguration.SpringConfigFile";
    String PROTOCOL_VERSION_CONFIG_FILE_NAME_DEFAULT = null;
    String PROTOCOL_VERSION_CLASS_NAME_KEY = "ProtocolVersionConfiguration.ClassName";
    String PROTOCOL_VERSION_CLASS_NAME_DEFAULT = DefaultNCIPVersion.class.getName();
}
