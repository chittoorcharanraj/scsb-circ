package org.extensiblecatalog.ncip.v2.common;

public interface NCIPProtocolVersionConfiguration extends ProtocolVersionConfiguration {
    String PROTOCOL_VERSION_VERSION_ATTRIBUTE_KEY = "NCIPProtocolVersionConfiguration.VersionAttribute";
    String PROTOCOL_VERSION_VERSION_ATTRIBUTE_DEFAULT = "http://www.niso.org/schemas/ncip/v2_0/imp1/xsd/ncip_v2_0.xsd";
    String PROTOCOL_VERSION_CANONICAL_VERSION_ATTRIBUTE_KEY = "NCIPProtocolVersionConfiguration.CanonicalVersionAttribute";
    String PROTOCOL_VERSION_CANONICAL_VERSION_ATTRIBUTE_DEFAULT = "http://www.niso.org/schemas/ncip/v2_0/imp1/xsd/ncip_v2_0.xsd";

    String getVersionAttribute();

    DefaultNCIPVersion getCanonicalVersion();
}
