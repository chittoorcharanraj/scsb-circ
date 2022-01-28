package org.extensiblecatalog.ncip.v2.common;

import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultConnectorConfiguration extends BaseToolkitConfiguration implements ConnectorConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(DefaultConnectorConfiguration.class);
    protected String connectorClassName = "org.extensiblecatalog.ncip.v2.dummy.DummyRemoteServiceManager";

    public DefaultConnectorConfiguration() {
    }

    public DefaultConnectorConfiguration(Properties properties) {
        super((String)null, properties);
    }

    public DefaultConnectorConfiguration(String appName) {
        super(appName, (Properties)null);
    }

    public DefaultConnectorConfiguration(String appName, Properties properties) {
        super(appName, properties);
    }

    public String getComponentClassName() {
        return this.connectorClassName;
    }

    public void setComponentClassName(String componentClassName) {
        this.connectorClassName = componentClassName;
    }
}
