package org.extensiblecatalog.ncip.v2.common;

import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseToolkitConfiguration implements ToolkitConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(BaseToolkitConfiguration.class);
    protected String appName;
    protected Properties properties;

    public BaseToolkitConfiguration() {
    }

    public BaseToolkitConfiguration(Properties properties) {
        this.properties = properties;
    }

    public BaseToolkitConfiguration(String appName) {
        this.appName = appName;
    }

    public BaseToolkitConfiguration(String appName, Properties properties) {
        this.appName = appName;
        this.properties = properties;
    }

    public Properties getProperties() {
        return this.properties;
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return this.properties.getProperty(key, defaultValue);
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
