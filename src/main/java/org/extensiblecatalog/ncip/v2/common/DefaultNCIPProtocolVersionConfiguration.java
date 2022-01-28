package org.extensiblecatalog.ncip.v2.common;

import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultNCIPProtocolVersionConfiguration extends BaseToolkitConfiguration implements NCIPProtocolVersionConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(DefaultNCIPProtocolVersionConfiguration.class);
    protected String protocolVersionClassName;
    protected String versionAttribute;
    protected DefaultNCIPVersion canonicalVersion;

    public DefaultNCIPProtocolVersionConfiguration() {
        this.protocolVersionClassName = ProtocolVersionConfiguration.PROTOCOL_VERSION_CLASS_NAME_DEFAULT;
        this.versionAttribute = "http://www.niso.org/schemas/ncip/v2_0/imp1/xsd/ncip_v2_0.xsd";
        this.canonicalVersion = DefaultNCIPVersion.findByVersionAttribute("http://www.niso.org/schemas/ncip/v2_0/imp1/xsd/ncip_v2_0.xsd");
    }

    public DefaultNCIPProtocolVersionConfiguration(String appName) {
        this(appName, (Properties)null);
    }

    public DefaultNCIPProtocolVersionConfiguration(Properties properties) {
        this((String)null, properties);
    }

    public DefaultNCIPProtocolVersionConfiguration(String appName, Properties properties) {
        super(appName, properties);
        this.protocolVersionClassName = ProtocolVersionConfiguration.PROTOCOL_VERSION_CLASS_NAME_DEFAULT;
        this.versionAttribute = "http://www.niso.org/schemas/ncip/v2_0/imp1/xsd/ncip_v2_0.xsd";
        this.canonicalVersion = DefaultNCIPVersion.findByVersionAttribute("http://www.niso.org/schemas/ncip/v2_0/imp1/xsd/ncip_v2_0.xsd");
        if (properties != null) {
            String classNameString = this.properties.getProperty("ProtocolVersionConfiguration.ClassName");
            if (classNameString != null) {
                this.protocolVersionClassName = classNameString;
            }

            String versionAttributeString = this.properties.getProperty("NCIPProtocolVersionConfiguration.VersionAttribute");
            if (versionAttributeString != null) {
                this.versionAttribute = versionAttributeString;
            }

            String canonicalVersionAttributeString = this.properties.getProperty("NCIPProtocolVersionConfiguration.CanonicalVersionAttribute");
            if (canonicalVersionAttributeString != null) {
                this.canonicalVersion = DefaultNCIPVersion.findByVersionAttribute(canonicalVersionAttributeString);
            }
        }

    }

    public String getComponentClassName() {
        return this.protocolVersionClassName;
    }

    public void setComponentClassName(String componentClassName) {
        this.protocolVersionClassName = componentClassName;
    }

    public String getVersionAttribute() {
        return this.versionAttribute;
    }

    public DefaultNCIPVersion getCanonicalVersion() {
        return this.canonicalVersion;
    }
}
