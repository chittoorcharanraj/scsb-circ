package org.extensiblecatalog.ncip.v2.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultNCIPVersion implements ProtocolVersion {
    private static final Logger logger = LoggerFactory.getLogger(DefaultNCIPVersion.class);
    protected static Map<String, DefaultNCIPVersion> versionsByAttribute = new HashMap();
    protected final String versionAttribute;
    protected final DefaultNCIPVersion canonicalVersion;
    public static final DefaultNCIPVersion VERSION_1_0 = new DefaultNCIPVersion("http://www.niso.org/ncip/v1_0/imp1/dtd/ncip_v1_0.dtd");
    public static final DefaultNCIPVersion VERSION_1_01 = new DefaultNCIPVersion("http://www.niso.org/ncip/v1_01/imp1/dtd/ncip_v1_01.dtd");
    public static final DefaultNCIPVersion VERSION_2_0 = new DefaultNCIPVersion("http://www.niso.org/schemas/ncip/v2_0/imp1/xsd/ncip_v2_0.xsd");
    public static final DefaultNCIPVersion VERSION_2_01 = new DefaultNCIPVersion("http://www.niso.org/schemas/ncip/v2_0/imp1/xsd/ncip_v2_01.xsd");

    public DefaultNCIPVersion(String versionAttribute, DefaultNCIPVersion canonicalVersion) {
        this.versionAttribute = versionAttribute;
        this.canonicalVersion = canonicalVersion;
        Class var3 = DefaultNCIPVersion.class;
        synchronized(DefaultNCIPVersion.class) {
            versionsByAttribute.put(this.versionAttribute, this);
        }
    }

    public DefaultNCIPVersion(String versionAttribute) {
        this(versionAttribute, (DefaultNCIPVersion)null);
    }

    public DefaultNCIPVersion(Properties properties) throws ToolkitException {
        this(ProtocolVersionConfigurationFactory.buildConfiguration(properties));
    }

    public DefaultNCIPVersion(ProtocolVersionConfiguration config) {
        this(((NCIPProtocolVersionConfiguration)config).getVersionAttribute(), ((NCIPProtocolVersionConfiguration)config).getCanonicalVersion());
    }

    public String getVersionAttribute() {
        return this.versionAttribute;
    }

    public DefaultNCIPVersion getCanonicalVersion() {
        return this.canonicalVersion;
    }

    public static DefaultNCIPVersion findByVersionAttribute(String versionAttribute) {
        DefaultNCIPVersion result = null;
        if (versionAttribute != null) {
            result = (DefaultNCIPVersion)versionsByAttribute.get(versionAttribute);
        }

        return result;
    }
}
