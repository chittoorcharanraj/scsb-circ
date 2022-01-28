package org.extensiblecatalog.ncip.v2.common;

import org.extensiblecatalog.ncip.v2.service.AgencyElementType;
import org.extensiblecatalog.ncip.v2.service.AgencyId;
import org.extensiblecatalog.ncip.v2.service.ApplicationProfileType;
import org.extensiblecatalog.ncip.v2.service.FromSystemId;
import org.extensiblecatalog.ncip.v2.service.ItemElementType;
import org.extensiblecatalog.ncip.v2.service.PickupLocation;
import org.extensiblecatalog.ncip.v2.service.RequestElementType;
import org.extensiblecatalog.ncip.v2.service.RequestIdentifierType;
import org.extensiblecatalog.ncip.v2.service.ToSystemId;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.extensiblecatalog.ncip.v2.service.UserElementType;
/*
import org.extensiblecatalog.ncip.v2.service.Version1AcceptItemProcessingError;
import org.extensiblecatalog.ncip.v2.service.Version1AgencyAddressRoleType;
import org.extensiblecatalog.ncip.v2.service.Version1AgencyElementType;
import org.extensiblecatalog.ncip.v2.service.Version1AuthenticationDataFormatType;
import org.extensiblecatalog.ncip.v2.service.Version1AuthenticationInputType;
import org.extensiblecatalog.ncip.v2.service.Version1BibliographicItemIdentifierCode;
import org.extensiblecatalog.ncip.v2.service.Version1BibliographicLevel;
import org.extensiblecatalog.ncip.v2.service.Version1BibliographicRecordIdentifierCode;
import org.extensiblecatalog.ncip.v2.service.Version1CancelRequestItemProcessingError;
import org.extensiblecatalog.ncip.v2.service.Version1CheckInItemProcessingError;
import org.extensiblecatalog.ncip.v2.service.Version1CheckOutItemProcessingError;
import org.extensiblecatalog.ncip.v2.service.Version1CirculationStatus;
import org.extensiblecatalog.ncip.v2.service.Version1ComponentIdentifierType;
import org.extensiblecatalog.ncip.v2.service.Version1CurrencyCode;
import org.extensiblecatalog.ncip.v2.service.Version1ElectronicAddressType;
import org.extensiblecatalog.ncip.v2.service.Version1ElectronicDataFormatType;
import org.extensiblecatalog.ncip.v2.service.Version1FiscalActionType;
import org.extensiblecatalog.ncip.v2.service.Version1FiscalTransactionType;
import org.extensiblecatalog.ncip.v2.service.Version1GeneralProcessingError;
import org.extensiblecatalog.ncip.v2.service.Version1ItemDescriptionLevel;
import org.extensiblecatalog.ncip.v2.service.Version1ItemElementType;
import org.extensiblecatalog.ncip.v2.service.Version1ItemIdentifierType;
import org.extensiblecatalog.ncip.v2.service.Version1ItemUseRestrictionType;
import org.extensiblecatalog.ncip.v2.service.Version1Language;
import org.extensiblecatalog.ncip.v2.service.Version1LocationType;
import org.extensiblecatalog.ncip.v2.service.Version1LookupItemProcessingError;
import org.extensiblecatalog.ncip.v2.service.Version1LookupRequestProcessingError;
import org.extensiblecatalog.ncip.v2.service.Version1LookupUserProcessingError;
import org.extensiblecatalog.ncip.v2.service.Version1MediumType;
import org.extensiblecatalog.ncip.v2.service.Version1MessagingError;
import org.extensiblecatalog.ncip.v2.service.Version1OrganizationNameType;
import org.extensiblecatalog.ncip.v2.service.Version1PaymentMethodType;
import org.extensiblecatalog.ncip.v2.service.Version1PhysicalAddressType;
import org.extensiblecatalog.ncip.v2.service.Version1PhysicalConditionType;
import org.extensiblecatalog.ncip.v2.service.Version1RenewItemProcessingError;
import org.extensiblecatalog.ncip.v2.service.Version1RequestElementType;
import org.extensiblecatalog.ncip.v2.service.Version1RequestItemProcessingError;
import org.extensiblecatalog.ncip.v2.service.Version1RequestScopeType;
import org.extensiblecatalog.ncip.v2.service.Version1RequestStatusType;
import org.extensiblecatalog.ncip.v2.service.Version1RequestType;
import org.extensiblecatalog.ncip.v2.service.Version1RequestedActionType;
import org.extensiblecatalog.ncip.v2.service.Version1SecurityMarker;
import org.extensiblecatalog.ncip.v2.service.Version1UnstructuredAddressType;
import org.extensiblecatalog.ncip.v2.service.Version1UpdateRequestItemProcessingError;
import org.extensiblecatalog.ncip.v2.service.Version1UserAddressRoleType;
import org.extensiblecatalog.ncip.v2.service.Version1UserElementType;
import org.extensiblecatalog.ncip.v2.service.Version1UserIdentifierType;
*/

public interface CoreConfiguration extends ToolkitConfiguration {
    String CORE_PROPERTIES_FILE_TITLE_KEY = "CoreConfiguration.PropertiesFileTitle";
    String CORE_PROPERTIES_FILE_TITLE_DEFAULT = null;
    String CORE_LOCAL_PROPERTIES_FILE_TITLE_KEY = "CoreConfiguration.LocalPropertiesFileTitle";
    String CORE_LOCAL_PROPERTIES_FILE_TITLE_DEFAULT = null;
    String CORE_CONFIG_CLASS_NAME_KEY = "CoreConfiguration.ConfigClass";
    String CORE_CONFIG_CLASS_NAME_DEFAULT = DefaultCoreConfiguration.class.getName();
    String CORE_PROPERTIES_FILENAME_KEY = "CoreConfiguration.PropertiesFile";
    String CORE_PROPERTIES_FILENAME_DEFAULT = "core.properties";
    String CORE_LOCAL_PROPERTIES_FILENAME_KEY = "CoreConfiguration.LocalPropertiesFile";
    String CORE_LOCAL_PROPERTIES_FILENAME_DEFAULT = "${ToolkitConfiguration.AppName}core.properties";
    String CORE_CONFIG_PROPERTIES_FILE_OVERRIDE_KEY = "CoreConfiguration.PropertiesFileOverride";
    String CORE_CONFIG_PROPERTIES_FILE_OVERRIDE_DEFAULT = null;
    String CORE_CONFIG_FILE_NAME_KEY = "CoreConfiguration.SpringConfigFile";
    String CORE_CONFIG_FILE_NAME_DEFAULT = null;
    String CORE_CLASS_NAME_KEY = "CoreConfiguration.ClassName";
    String CORE_CLASS_NAME_DEFAULT = null;
    String CORE_LOGGING_CONFIG_FILE_NAME_KEY = "CoreConfiguration.LoggingConfigFile";
    String CORE_LOGGING_CONFIG_FILE_NAME_DEFAULT = "/WEB-INF/classes/log4j.properties";
    String CORE_LOGGING_CONFIG_FILE_NAME_IN_WAR_KEY = "CoreConfiguration.LoggingConfigFileInWar";
    String CORE_LOGGING_CONFIG_FILE_NAME_IN_WAR_DEFAULT = "log4j.properties";
    String CORE_LOGGING_DIR_KEY = "CoreConfiguration.LoggingDir";
    String CORE_LOGGING_DIR_DEFAULT = "logs/";
    String CORE_TOMCAT_LOGGING_DIR_DEFAULT = "../logs/";
    String CORE_JETTY_LOGGING_DIR_DEFAULT = "logs/";
    String CORE_INCLUDE_STACK_TRACES_IN_PROBLEM_RESPONSES_KEY = "CoreConfiguration.IncludeStackTracesInProblemResponses";
    String CORE_INCLUDE_STACK_TRACES_IN_PROBLEM_RESPONSES_DEFAULT = "False";
    String CORE_SCHEME_VALUE_PAIR_CLASSES_LIST_KEY = "CoreConfiguration.SVPClasses";
    //String CORE_SCHEME_VALUE_PAIR_CLASSES_LIST_DEFAULT = Version1AcceptItemProcessingError.class.getName() + "," + Version1AgencyAddressRoleType.class.getName() + "," + Version1AgencyElementType.class.getName() + "," + Version1AuthenticationDataFormatType.class.getName() + "," + Version1AuthenticationInputType.class.getName() + "," + Version1BibliographicItemIdentifierCode.class.getName() + "," + Version1BibliographicLevel.class.getName() + "," + Version1BibliographicRecordIdentifierCode.class.getName() + "," + Version1CancelRequestItemProcessingError.class.getName() + "," + Version1CheckInItemProcessingError.class.getName() + "," + Version1CheckOutItemProcessingError.class.getName() + "," + Version1CirculationStatus.class.getName() + "," + Version1ComponentIdentifierType.class.getName() + "," + Version1CurrencyCode.class.getName() + "," + Version1ElectronicAddressType.class.getName() + "," + Version1ElectronicDataFormatType.class.getName() + "," + Version1FiscalActionType.class.getName() + "," + Version1FiscalTransactionType.class.getName() + "," + Version1GeneralProcessingError.class.getName() + "," + Version1ItemDescriptionLevel.class.getName() + "," + Version1ItemElementType.class.getName() + "," + Version1ItemIdentifierType.class.getName() + "," + Version1ItemUseRestrictionType.class.getName() + "," + Version1Language.class.getName() + "," + Version1LocationType.class.getName() + "," + Version1LookupItemProcessingError.class.getName() + "," + Version1LookupRequestProcessingError.class.getName() + "," + Version1LookupUserProcessingError.class.getName() + "," + Version1MediumType.class.getName() + "," + Version1MessagingError.class.getName() + "," + Version1OrganizationNameType.class.getName() + "," + Version1PaymentMethodType.class.getName() + "," + Version1PhysicalAddressType.class.getName() + "," + Version1PhysicalConditionType.class.getName() + "," + Version1RenewItemProcessingError.class.getName() + "," + Version1RequestedActionType.class.getName() + "," + Version1RequestElementType.class.getName() + "," + Version1RequestItemProcessingError.class.getName() + "," + Version1RequestScopeType.class.getName() + "," + Version1RequestStatusType.class.getName() + "," + Version1RequestType.class.getName() + "," + Version1SecurityMarker.class.getName() + "," + Version1UnstructuredAddressType.class.getName() + "," + Version1UserAddressRoleType.class.getName() + "," + Version1UpdateRequestItemProcessingError.class.getName() + "," + Version1UserElementType.class.getName() + "," + Version1UserIdentifierType.class.getName();
    String CORE_SCHEME_VALUE_PAIR_ADDED_CLASSES_LIST_KEY = "CoreConfiguration.AddedSVPClasses";
    String CORE_SCHEME_VALUE_PAIR_ADDED_CLASSES_LIST_DEFAULT = null;
    String CORE_SCHEME_VALUE_PAIR_ALLOW_ANY_CLASSES_LIST_KEY = "CoreConfiguration.SVPClassesAllowAny";
    String CORE_SCHEME_VALUE_PAIR_ALLOW_ANY_CLASSES_LIST_DEFAULT = AgencyId.class.getName() + "," + ApplicationProfileType.class.getName() + "," + FromSystemId.class.getName() + "," + PickupLocation.class.getName() + "," + RequestIdentifierType.class.getName() + "," + ToSystemId.class.getName();
    String CORE_SCHEME_VALUE_PAIR_ADDED_ALLOW_ANY_CLASSES_LIST_KEY = "CoreConfiguration.AddedSVPClassesAllowAny";
    String CORE_SCHEME_VALUE_PAIR_ADDED_ALLOW_ANY_CLASSES_LIST_DEFAULT = null;
    String CORE_SCHEME_VALUE_PAIR_ALLOW_NULL_SCHEME_CLASSES_LIST_KEY = "CoreConfiguration.SVPClassesAllowNullScheme";
    String CORE_SCHEME_VALUE_PAIR_ALLOW_NULL_SCHEME_CLASSES_LIST_DEFAULT = AgencyElementType.class.getName() + "," + ItemElementType.class.getName() + "," + RequestElementType.class.getName() + "," + UserElementType.class.getName();
    String CORE_SCHEME_VALUE_PAIR_ADDED_ALLOW_NULL_SCHEME_CLASSES_LIST_KEY = "CoreConfiguration.AddedSVPClassesAllowNullScheme";
    String CORE_SCHEME_VALUE_PAIR_ADDED_ALLOW_NULL_SCHEME_CLASSES_LIST_DEFAULT = null;

    ConnectorConfiguration getConnectorConfiguration() throws ToolkitException;

    MessageHandlerConfiguration getMessageHandlerConfiguration() throws ToolkitException;

    ServiceValidatorConfiguration getServiceValidatorConfiguration() throws ToolkitException;

    TranslatorConfiguration getTranslatorConfiguration() throws ToolkitException;

    StatisticsBeanConfiguration getStatisticsBeanConfiguration() throws ToolkitException;

    ProtocolVersionConfiguration getProtocolVersionConfiguration() throws ToolkitException;

    boolean isConfigurationSet(String var1) throws ToolkitException;

    ToolkitConfiguration getConfiguration(String var1) throws ToolkitException;

    boolean getIncludeStackTracesInProblemResponses();

    void setIncludeStackTracesInProblemResponses(boolean var1);
}
