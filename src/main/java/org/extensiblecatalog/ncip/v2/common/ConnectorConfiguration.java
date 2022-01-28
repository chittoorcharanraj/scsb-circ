package org.extensiblecatalog.ncip.v2.common;

public interface ConnectorConfiguration extends ToolkitConfiguration {
    String COMPONENT_NAME = "Connector";
    String CONNECTOR_PROPERTIES_FILE_TITLE_KEY = "ConnectorConfiguration.PropertiesFileTitle";
    String CONNECTOR_PROPERTIES_FILE_TITLE_DEFAULT = null;
    String CONNECTOR_LOCAL_PROPERTIES_FILE_TITLE_KEY = "ConnectorConfiguration.LocalPropertiesFileTitle";
    String CONNECTOR_LOCAL_PROPERTIES_FILE_TITLE_DEFAULT = null;
    String CONNECTOR_CONFIG_CLASS_NAME_KEY = "ConnectorConfiguration.ConfigClass";
    String CONNECTOR_CONFIG_CLASS_NAME_DEFAULT = DefaultConnectorConfiguration.class.getName();
    String CONNECTOR_PROPERTIES_FILENAME_KEY = "ConnectorConfiguration.PropertiesFile";
    String CONNECTOR_PROPERTIES_FILENAME_DEFAULT = "connector.properties";
    String CONNECTOR_LOCAL_PROPERTIES_FILENAME_KEY = "ConnectorConfiguration.LocalPropertiesFile";
    String CONNECTOR_LOCAL_PROPERTIES_FILENAME_DEFAULT = "${ToolkitConfiguration.AppName}connector.properties";
    String CONNECTOR_CONFIG_PROPERTIES_FILE_OVERRIDE_KEY = "ConnectorConfiguration.PropertiesFileOverride";
    String CONNECTOR_CONFIG_PROPERTIES_FILE_OVERRIDE_DEFAULT = null;
    String CONNECTOR_CONFIG_FILE_NAME_KEY = "ConnectorConfiguration.SpringConfigFile";
    String CONNECTOR_CONFIG_FILE_NAME_DEFAULT = null;
    String CONNECTOR_CLASS_NAME_KEY = "ConnectorConfiguration.ClassName";
    String CONNECTOR_CLASS_NAME_DEFAULT = "org.extensiblecatalog.ncip.v2.dummy.DummyRemoteServiceManager";
}
