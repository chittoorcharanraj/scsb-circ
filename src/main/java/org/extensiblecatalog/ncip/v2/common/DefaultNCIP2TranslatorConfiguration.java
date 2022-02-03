package org.extensiblecatalog.ncip.v2.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultNCIP2TranslatorConfiguration extends DefaultTranslatorConfiguration implements NCIP2TranslatorConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(DefaultNCIP2TranslatorConfiguration.class);
    protected Map<String, String> schemaURLsToPackageMap;
    protected Map<String, String> canonicalSchemaURLMap;

    public DefaultNCIP2TranslatorConfiguration() throws ToolkitException {
        this((String)null, (Properties)null);
    }

    public DefaultNCIP2TranslatorConfiguration(String appName) throws ToolkitException {
        this(appName, (Properties)null);
    }

    public DefaultNCIP2TranslatorConfiguration(Properties properties) throws ToolkitException {
        this((String)null, properties);
    }

    public DefaultNCIP2TranslatorConfiguration(String appName, Properties properties) throws ToolkitException {
        super(appName, properties);
        if (properties != null) {
            String schemaURLsToPackageMapString = this.properties.getProperty("NCIP2TranslatorConfiguration.SchemaURLsToPackageMap", "ncip_v2_01.xsd=org.extensiblecatalog.ncip.v2.binding.ncipv2_01.jaxb.elements,ncip_v2_02.xsd=org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements,ncip_v2_01_ils-di_extensions.xsd=org.extensiblecatalog.ncip.v2.binding.ilsdiv1_0.jaxb.elements");
            if (schemaURLsToPackageMapString == null) {
                throw new ToolkitException("NCIP2TranslatorConfiguration.SchemaURLsToPackageMap property is set to null.");
            }

            this.schemaURLsToPackageMap = new HashMap();
            String[] schemaURLsToPackageArray = schemaURLsToPackageMapString.split(",");
            String[] canonicalSchemaURLArray = schemaURLsToPackageArray;
            int var6 = schemaURLsToPackageArray.length;

            int var7;
            for(var7 = 0; var7 < var6; ++var7) {
                String schemaURLtoPackageString = canonicalSchemaURLArray[var7];
                String[] schemaURLAndPackage = schemaURLtoPackageString.split("=");
                if (schemaURLAndPackage.length != 2) {
                    throw new ToolkitException("NCIP2TranslatorConfiguration.SchemaURLsToPackageMap has invalid format: '" + schemaURLsToPackageMapString + "'; format should be 'schemaURL=packagename'. E.g. '" + "ncip_v2_01.xsd=org.extensiblecatalog.ncip.v2.binding.ncipv2_01.jaxb.elements,ncip_v2_02.xsd=org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements,ncip_v2_01_ils-di_extensions.xsd=org.extensiblecatalog.ncip.v2.binding.ilsdiv1_0.jaxb.elements" + "'.");
                }

                this.schemaURLsToPackageMap.put(schemaURLAndPackage[0], schemaURLAndPackage[1]);
            }

            String canonicalSchemaURLMapString = this.properties.getProperty("NCIP2TranslatorConfiguration.CanonicalSchemaURLMap", NCIP2TranslatorConfiguration.CANONICAL_SCHEMA_URL_MAP_DEFAULT);
            if (canonicalSchemaURLMapString != null) {
                this.canonicalSchemaURLMap = new HashMap();
                canonicalSchemaURLArray = canonicalSchemaURLMapString.split(",");
                String[] var12 = canonicalSchemaURLArray;
                var7 = canonicalSchemaURLArray.length;

                for(int var13 = 0; var13 < var7; ++var13) {
                    String aliasAndSchemaURLString = var12[var13];
                    String[] aliasAndSchemaURL = aliasAndSchemaURLString.split("=");
                    if (aliasAndSchemaURL.length != 2) {
                        throw new ToolkitException("NCIP2TranslatorConfiguration.CanonicalSchemaURLMap has invalid format: '" + canonicalSchemaURLMapString + "'; format should be 'aliasURL1=canonicalURL1,aliasURL2=canonicalURL1'. E.g. '" + NCIP2TranslatorConfiguration.CANONICAL_SCHEMA_URL_MAP_DEFAULT + "'.");
                    }

                    this.canonicalSchemaURLMap.put(aliasAndSchemaURL[0], aliasAndSchemaURL[1]);
                }
            }
        }

    }

    public Map<String, String> getSchemaURLsToPackageMap() {
        return this.schemaURLsToPackageMap;
    }

    public void setSchemaURLsToPackageMap(Map<String, String> urlsToPackageMap) {
        this.schemaURLsToPackageMap = urlsToPackageMap;
    }

    public Map<String, String> getCanonicalSchemaURLMap() {
        return this.canonicalSchemaURLMap;
    }

    public void setCanonicalSchemaURLMap(Map<String, String> aliasToCanonicalSchemaURLMap) {
        this.canonicalSchemaURLMap = aliasToCanonicalSchemaURLMap;
    }
}
