package org.extensiblecatalog.ncip.v2.common;

import java.util.Properties;

public interface ToolkitConfiguration {
    String TOOLKIT_CONFIG_PROPERTY_OVERRIDE_KEY = "ToolkitConfiguration.PropertiesFileOverride";
    String TOOLKIT_CONFIG_PROPERTY_OVERRIDE_DEFAULT = null;
    String TOOLKIT_PROPERTIES_FILENAME_KEY = "ToolkitConfiguration.PropertiesFile";
    String TOOLKIT_PROPERTIES_FILENAME_DEFAULT = "toolkit.properties";
    String TOOLKIT_LOCAL_PROPERTIES_FILENAME_KEY = "ToolkitConfiguration.LocalPropertiesFile";
    String TOOLKIT_LOCAL_PROPERTIES_FILENAME_DEFAULT = "${ToolkitConfiguration.AppName}toolkit.properties";
    String TOOLKIT_PROPERTIES_FILE_TITLE_KEY = "ToolkitConfiguration.PropertiesFileTitle";
    String TOOLKIT_PROPERTIES_FILE_TITLE_DEFAULT = null;
    String TOOLKIT_LOCAL_PROPERTIES_FILE_TITLE_KEY = "ToolkitConfiguration.LocalPropertiesFileTitle";
    String TOOLKIT_LOCAL_PROPERTIES_FILE_TITLE_DEFAULT = null;
    String TOOLKIT_CONFIG_FILE_NAME_KEY = "ToolkitConfiguration.SpringConfigFile";
    String TOOLKIT_CONFIG_FILE_NAME_DEFAULT = null;
    String TOOLKIT_APP_NAME_KEY = "ToolkitConfiguration.AppName";
    String TOOLKIT_APP_NAME_DEFAULT = "local";

    Properties getProperties();

    String getProperty(String var1);

    String getProperty(String var1, String var2);

    String getAppName();

    void setAppName(String var1);

    String getComponentClassName();

    void setComponentClassName(String var1);
}
