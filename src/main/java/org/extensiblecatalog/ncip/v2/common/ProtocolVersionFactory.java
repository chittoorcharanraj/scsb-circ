package org.extensiblecatalog.ncip.v2.common;

import java.util.Properties;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtocolVersionFactory extends BaseComponentFactory<ProtocolVersion, ProtocolVersionConfiguration> {
    private static final Logger logger = LoggerFactory.getLogger(ProtocolVersionFactory.class);
    protected ProtocolVersion protocolVersion;

    public ProtocolVersionFactory() throws ToolkitException {
    }

    public ProtocolVersionFactory(Properties properties) throws ToolkitException {
        this.protocolVersion = buildProtocolVersion(properties);
    }

    public ProtocolVersionFactory(String appName) throws ToolkitException {
        this.protocolVersion = buildProtocolVersion(appName);
    }

    public ProtocolVersionFactory(String appName, Properties properties) throws ToolkitException {
        this.protocolVersion = buildProtocolVersion(appName, properties);
    }

    public ProtocolVersionFactory(ProtocolVersionConfiguration configuration) throws ToolkitException {
        this.protocolVersion = (ProtocolVersion)buildComponent(configuration);
    }

    public ProtocolVersion getComponent() {
        return this.protocolVersion;
    }

    public static ProtocolVersion buildProtocolVersion() throws ToolkitException {
        return buildProtocolVersion((String)null, (Properties)null);
    }

    public static ProtocolVersion buildProtocolVersion(Properties properties) throws ToolkitException {
        return buildProtocolVersion((String)null, properties);
    }

    public static ProtocolVersion buildProtocolVersion(String appName) throws ToolkitException {
        return buildProtocolVersion(appName, (Properties)null);
    }

    public static ProtocolVersion buildProtocolVersion(ProtocolVersionConfiguration configuration) throws ToolkitException {
        return (ProtocolVersion)buildComponent(configuration);
    }

    public static ProtocolVersion buildProtocolVersion(String appName, Properties properties) throws ToolkitException {
        ProtocolVersion pv = (ProtocolVersion)buildComponent(ProtocolVersionFactory.class, appName, ProtocolVersion.COMPONENT_NAME, "ProtocolVersionConfiguration.SpringConfigFile", ProtocolVersionConfiguration.PROTOCOL_VERSION_CONFIG_FILE_NAME_DEFAULT, properties, "ProtocolVersionConfiguration.PropertiesFile", "protocolversion.properties", "ProtocolVersionConfiguration.LocalPropertiesFile", "${ToolkitConfiguration.AppName}protocolversion.properties", "ProtocolVersionConfiguration.PropertiesFileOverride", ProtocolVersionConfiguration.PROTOCOL_VERSION_CONFIG_PROPERTIES_FILE_OVERRIDE_DEFAULT);
        return pv;
    }
}
