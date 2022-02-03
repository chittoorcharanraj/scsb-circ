package org.extensiblecatalog.ncip.v2.common;

import java.util.Properties;
import org.apache.logging.log4j.Level;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultTranslatorConfiguration extends BaseToolkitConfiguration implements TranslatorConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(DefaultTranslatorConfiguration.class);
    protected String translatorClassName;
    protected boolean logMessages;
    protected Level messagesLoggingLevel;

    public DefaultTranslatorConfiguration() throws ToolkitException {
        this.translatorClassName = "org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer.NCIPv2_02JAXBDozerTranslator";
        this.logMessages = true;
        this.messagesLoggingLevel = Level.DEBUG;
    }

    public DefaultTranslatorConfiguration(Properties properties) throws ToolkitException {
        this((String)null, properties);
    }

    public DefaultTranslatorConfiguration(String appName) throws ToolkitException {
        this(appName, (Properties)null);
    }

    public DefaultTranslatorConfiguration(String appName, Properties properties) throws ToolkitException {
        super(appName, properties);
        this.translatorClassName = "org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer.NCIPv2_02JAXBDozerTranslator";
        this.logMessages = true;
        this.messagesLoggingLevel = Level.DEBUG;
        String translatorClassNameOverride = null;
        String logMessagesString = null;
        String messageLoggingLevelString = null;
        if (properties != null) {
            translatorClassNameOverride = properties.getProperty("TranslatorConfiguration.ClassName", "org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer.NCIPv2_02JAXBDozerTranslator");
            logMessagesString = properties.getProperty("TranslatorConfiguration.LogMessages", "false");
            messageLoggingLevelString = properties.getProperty("TranslatorConfiguration.MessagesLoggingLevel", "INFO");
        }

        if (translatorClassNameOverride != null) {
            this.translatorClassName = translatorClassNameOverride;
        }

        if (logMessagesString != null) {
            this.logMessages = Boolean.parseBoolean(logMessagesString);
        }

        if (messageLoggingLevelString != null) {
            Level tempMessagesLoggingLevel = Level.toLevel(messageLoggingLevelString);
            if (tempMessagesLoggingLevel != null) {
                this.messagesLoggingLevel = tempMessagesLoggingLevel;
            } else {
                logger.warn("TranslatorConfiguration.MessagesLoggingLevel of '" + messageLoggingLevelString + "' is invalid; using default of '" + "INFO" + "' instead.");
                this.messagesLoggingLevel = Level.toLevel("INFO");
            }
        } else {
            this.messagesLoggingLevel = Level.DEBUG;
        }

    }

    public String getComponentClassName() {
        return this.translatorClassName;
    }

    public void setComponentClassName(String componentClassName) {
        this.translatorClassName = componentClassName;
    }

    public boolean getLogMessages() {
        return this.logMessages;
    }

    public Level getMessagesLoggingLevel() {
        return this.messagesLoggingLevel;
    }

    public void setLogMessages(boolean logMessages) {
        this.logMessages = logMessages;
    }

    public void setMessagesLoggingLevel(Level messagesLoggingLevel) {
        this.messagesLoggingLevel = messagesLoggingLevel;
    }
}
