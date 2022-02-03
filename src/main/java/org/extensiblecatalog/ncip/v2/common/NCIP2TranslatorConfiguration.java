package org.extensiblecatalog.ncip.v2.common;

import java.util.Map;

public interface NCIP2TranslatorConfiguration extends TranslatorConfiguration {
    String SCHEMA_URLS_TO_PACKAGE_MAP_KEY = "NCIP2TranslatorConfiguration.SchemaURLsToPackageMap";
    String SCHEMA_URLS_TO_PACKAGE_MAP_DEFAULT = "ncip_v2_01.xsd=org.extensiblecatalog.ncip.v2.binding.ncipv2_01.jaxb.elements,ncip_v2_02.xsd=org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements,ncip_v2_01_ils-di_extensions.xsd=org.extensiblecatalog.ncip.v2.binding.ilsdiv1_0.jaxb.elements";
    String CANONICAL_SCHEMA_URL_MAP_KEY = "NCIP2TranslatorConfiguration.CanonicalSchemaURLMap";
    String CANONICAL_SCHEMA_URL_MAP_DEFAULT = null;

    Map<String, String> getSchemaURLsToPackageMap();

    void setSchemaURLsToPackageMap(Map<String, String> var1);

    Map<String, String> getCanonicalSchemaURLMap();

    void setCanonicalSchemaURLMap(Map<String, String> var1);
}
