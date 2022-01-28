package org.extensiblecatalog.ncip.v2.common;

import java.util.List;
import java.util.Map;
import org.extensiblecatalog.ncip.v2.service.ApplicationProfileType;

public interface NCIPServiceValidatorConfiguration extends ServiceValidatorConfiguration {
    String PROTOCOL_NAME_KEY = "NCIPServiceValidatorConfiguration.Protocol";
    String PROTOCOL_NAME_DEFAULT = "NCIP";
    String PROTOCOL_PROFILE_KEY = "NCIPServiceValidatorConfiguration.ProtocolProfile";
    String PROTOCOL_PROFILE_DEFAULT = null;
    String NAMESPACE_URIS_KEY = "NCIPServiceValidatorConfiguration.NamespaceURIs";
    String NAMESPACE_URIS_DEFAULT = "http://www.niso.org/2008/ncip";
    String DEFAULT_NAMESPACE_URI_KEY = "NCIPServiceValidatorConfiguration.DefaultNamespaceURI";
    String DEFAULT_NAMESPACE_URI_DEFAULT = "http://www.niso.org/2008/ncip";
    String SUPPORTED_SCHEMA_URLS_KEY = "NCIPServiceValidatorConfiguration.SupportedSchemaURLs";
    String SUPPORTED_SCHEMA_URLS_DEFAULT = "ncip_v2_02.xsd";
    String VALIDATE_MESSAGES_AGAINST_SCHEMA_KEY = "NCIPServiceValidatorConfiguration.ValidateMessagesAgainstSchema";
    String VALIDATE_MESSAGES_AGAINST_SCHEMA_DEFAULT = "true";
    String ADD_DEFAULT_NAMESPACE_URI_KEY = "NCIPServiceValidatorConfiguration.AddDefaultNamespaceURI";
    String ADD_DEFAULT_NAMESPACE_URI_DEFAULT = "false";
    String REQUIRE_APPLICATION_PROFILE_TYPE_KEY = "NCIPServiceValidatorConfiguration.RequireApplicationProfileType";
    String REQUIRE_APPLICATION_PROFILE_TYPE_DEFAULT = "False";
    String APPLICATION_PROFILE_TYPES_KEY = "NCIPServiceValidatorConfiguration.ApplicationProfileTypes";
    String APPLICATION_PROFILE_TYPES_DEFAULT = null;
    String PARSER_FEATURES_KEY = "NCIPServiceValidatorConfiguration.ParserFeatures";
    String PARSER_FEATURES_DEFAULT = null;

    DefaultNCIPVersion getVersion();

    List<ApplicationProfileType> getApplicationProfileTypes();

    boolean requireApplicationProfileType();

    String[] getNamespaceURIs();

    String getDefaultNamespaceURI();

    boolean addDefaultNamespaceURI();

    List<String> getSupportedSchemaURLs();

    boolean validateMessagesAgainstSchema();

    Map<String, Boolean> getParserFeatures();

    String getServiceContextClassName();

    void setServiceContextClassName(String var1);
}
