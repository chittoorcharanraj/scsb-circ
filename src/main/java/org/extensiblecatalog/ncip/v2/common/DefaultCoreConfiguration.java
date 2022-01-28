//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.common;

import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultCoreConfiguration extends BaseToolkitConfiguration implements CoreConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(DefaultCoreConfiguration.class);
    protected String coreClassName;
    protected ConnectorConfiguration connectorConfig;
    protected MessageHandlerConfiguration messageHandlerConfig;
    protected ServiceValidatorConfiguration serviceValidatorConfig;
    protected TranslatorConfiguration translatorConfig;
    protected StatisticsBeanConfiguration statisticsBeanConfig;
    protected ProtocolVersionConfiguration protocolVersionConfig;
    protected boolean includeStackTracesInProblemResponses;

    public DefaultCoreConfiguration() throws ToolkitException {
        this.coreClassName = CoreConfiguration.CORE_CLASS_NAME_DEFAULT;
        this.includeStackTracesInProblemResponses = Boolean.parseBoolean("False");
    }

    public DefaultCoreConfiguration(String appName) throws ToolkitException {
        this(appName, (Properties)null);
    }

    public DefaultCoreConfiguration(Properties properties) throws ToolkitException {
        this((String)null, properties);
    }

    public DefaultCoreConfiguration(String appName, Properties properties) throws ToolkitException {
        super(appName, properties);
        this.coreClassName = CoreConfiguration.CORE_CLASS_NAME_DEFAULT;
        this.includeStackTracesInProblemResponses = Boolean.parseBoolean("False");
        if (this.properties != null) {
            String stackTracesPropertyString = null;
            stackTracesPropertyString = this.properties.getProperty("CoreConfiguration.IncludeStackTracesInProblemResponses", "False");
            if (stackTracesPropertyString != null) {
                this.includeStackTracesInProblemResponses = Boolean.parseBoolean(stackTracesPropertyString);
            }

           // String svpClassNamesCSV = this.properties.getProperty("CoreConfiguration.SVPClasses", CoreConfiguration.CORE_SCHEME_VALUE_PAIR_CLASSES_LIST_DEFAULT);
            String addedSVPClassNamesCSV = this.properties.getProperty("CoreConfiguration.AddedSVPClasses");
            String allowAnyClassNamesCSV = this.properties.getProperty("CoreConfiguration.SVPClassesAllowAny", CoreConfiguration.CORE_SCHEME_VALUE_PAIR_ALLOW_ANY_CLASSES_LIST_DEFAULT);
            String addedAllowAnyClassNamesCSV = this.properties.getProperty("CoreConfiguration.AddedSVPClassesAllowAny");
            String allowNullSchemeClassNamesCSV = this.properties.getProperty("CoreConfiguration.SVPClassesAllowNullScheme", CoreConfiguration.CORE_SCHEME_VALUE_PAIR_ALLOW_NULL_SCHEME_CLASSES_LIST_DEFAULT);
            String addedAllowNullSchemeClassNamesCSV = this.properties.getProperty("CoreConfiguration.AddedSVPClassesAllowNullScheme");

            try {
                SchemeLoader.init(addedSVPClassNamesCSV, allowAnyClassNamesCSV, addedAllowAnyClassNamesCSV, allowNullSchemeClassNamesCSV, addedAllowNullSchemeClassNamesCSV);
            } catch (InvocationTargetException var11) {
                throw new ToolkitException("InvocationTargetException calling SchemeLoader.init", var11);
            } catch (ClassNotFoundException var12) {
                throw new ToolkitException("ClassNotFoundException calling SchemeLoader.init", var12);
            } catch (NoSuchMethodException var13) {
                throw new ToolkitException("NoSuchMethodException calling SchemeLoader.init", var13);
            } catch (IllegalAccessException var14) {
                throw new ToolkitException("IllegalAccessException calling SchemeLoader.init", var14);
            }
        } else {
            throw new ToolkitException("Properties parameter must not be null.");
        }
    }

    public boolean isConfigurationSet(String componentName) throws ToolkitException {
        if (componentName.compareTo(Core.COMPONENT_NAME) == 0) {
            return true;
        } else if (componentName.compareTo(Connector.COMPONENT_NAME) == 0) {
            return this.connectorConfig != null;
        } else if (componentName.compareTo(MessageHandler.COMPONENT_NAME) == 0) {
            return this.messageHandlerConfig != null;
        } else if (componentName.compareTo(ProtocolVersion.COMPONENT_NAME) == 0) {
            return this.protocolVersionConfig != null;
        } else if (componentName.compareTo(ServiceValidator.COMPONENT_NAME) == 0) {
            return this.serviceValidatorConfig != null;
        } else if (componentName.compareTo(StatisticsBean.COMPONENT_NAME) == 0) {
            return this.statisticsBeanConfig != null;
        } else if (componentName.compareTo(Translator.COMPONENT_NAME) == 0) {
            return this.translatorConfig != null;
        } else {
            throw new ToolkitException("No matching component for '" + componentName + "'.");
        }
    }

    public ToolkitConfiguration getConfiguration(String componentName) throws ToolkitException {
        if (componentName.compareTo(Core.COMPONENT_NAME) == 0) {
            return this;
        } else if (componentName.compareTo(Connector.COMPONENT_NAME) == 0) {
            return this.getConnectorConfiguration();
        } else if (componentName.compareTo(MessageHandler.COMPONENT_NAME) == 0) {
            return this.getMessageHandlerConfiguration();
        } else if (componentName.compareTo(ProtocolVersion.COMPONENT_NAME) == 0) {
            return this.getProtocolVersionConfiguration();
        } else if (componentName.compareTo(ProtocolVersion.COMPONENT_NAME) == 0) {
            return this.getProtocolVersionConfiguration();
        } else if (componentName.compareTo(ServiceValidator.COMPONENT_NAME) == 0) {
            return this.getServiceValidatorConfiguration();
        } else if (componentName.compareTo(StatisticsBean.COMPONENT_NAME) == 0) {
            return this.getStatisticsBeanConfiguration();
        } else if (componentName.compareTo(Translator.COMPONENT_NAME) == 0) {
            return this.getTranslatorConfiguration();
        } else {
            throw new ToolkitException("No matching component for '" + componentName + "'.");
        }
    }

    public String getComponentClassName() {
        return this.coreClassName;
    }

    public void setComponentClassName(String componentClassName) {
        this.coreClassName = componentClassName;
    }

    public ConnectorConfiguration getConnectorConfiguration() throws ToolkitException {
        synchronized(this) {
            if (this.connectorConfig == null) {
                this.connectorConfig = ConnectorConfigurationFactory.buildConfiguration(this.appName, this.properties);
            }
        }

        return this.connectorConfig;
    }

    public MessageHandlerConfiguration getMessageHandlerConfiguration() throws ToolkitException {
        synchronized(this) {
            if (this.messageHandlerConfig == null) {
                this.messageHandlerConfig = MessageHandlerConfigurationFactory.buildConfiguration(this.appName, this.properties);
            }
        }

        return this.messageHandlerConfig;
    }

    public ServiceValidatorConfiguration getServiceValidatorConfiguration() throws ToolkitException {
        synchronized(this) {
            if (this.serviceValidatorConfig == null) {
                this.serviceValidatorConfig = ServiceValidatorConfigurationFactory.buildConfiguration(this.appName, this.properties);
            }
        }

        return this.serviceValidatorConfig;
    }

    public TranslatorConfiguration getTranslatorConfiguration() throws ToolkitException {
        synchronized(this) {
            if (this.translatorConfig == null) {
                this.translatorConfig = TranslatorConfigurationFactory.buildConfiguration(this.appName, this.properties);
            }
        }

        return this.translatorConfig;
    }

    public StatisticsBeanConfiguration getStatisticsBeanConfiguration() throws ToolkitException {
        synchronized(this) {
            if (this.statisticsBeanConfig == null) {
                this.statisticsBeanConfig = StatisticsBeanConfigurationFactory.buildConfiguration(this.appName, this.properties);
            }
        }

        return this.statisticsBeanConfig;
    }

    public ProtocolVersionConfiguration getProtocolVersionConfiguration() throws ToolkitException {
        synchronized(this) {
            if (this.protocolVersionConfig == null) {
                this.protocolVersionConfig = ProtocolVersionConfigurationFactory.buildConfiguration(this.appName, this.properties);
            }
        }

        return this.protocolVersionConfig;
    }

    public boolean getIncludeStackTracesInProblemResponses() {
        return this.includeStackTracesInProblemResponses;
    }

    public void setIncludeStackTracesInProblemResponses(boolean setting) {
        this.includeStackTracesInProblemResponses = setting;
    }
}
