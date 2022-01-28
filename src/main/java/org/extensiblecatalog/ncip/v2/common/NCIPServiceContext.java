package org.extensiblecatalog.ncip.v2.common;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.extensiblecatalog.ncip.v2.service.ApplicationProfileType;
import org.extensiblecatalog.ncip.v2.service.NCIPMessage;
import org.extensiblecatalog.ncip.v2.service.ServiceContext;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.extensiblecatalog.ncip.v2.service.ValidationException;

public class NCIPServiceContext implements ServiceContext {
    protected Properties properties;
    protected DefaultNCIPVersion version;
    protected List<ApplicationProfileType> applicationProfileTypes;
    protected boolean requireApplicationProfileType = false;
    protected String[] namespaceURIs;
    protected String defaultNamespace;
    protected boolean addDefaultNamespace = false;
    protected List<String> schemaURLs;
    protected boolean validateMessagesAgainstSchema = true;
    protected Map<String, Boolean> parserFeatures;

    public NCIPServiceContext() {
    }

    public NCIPServiceContext(ServiceValidatorConfiguration config) throws ToolkitException {
        if (config instanceof NCIPServiceValidatorConfiguration) {
            NCIPServiceValidatorConfiguration ncipConfig = (NCIPServiceValidatorConfiguration)config;
            this.version = ncipConfig.getVersion();
            this.requireApplicationProfileType = ncipConfig.requireApplicationProfileType();
            this.applicationProfileTypes = ncipConfig.getApplicationProfileTypes();
            this.namespaceURIs = ncipConfig.getNamespaceURIs();
            this.defaultNamespace = ncipConfig.getDefaultNamespaceURI();
            this.addDefaultNamespace = ncipConfig.addDefaultNamespaceURI();
            this.schemaURLs = ncipConfig.getSupportedSchemaURLs();
            this.validateMessagesAgainstSchema = ncipConfig.validateMessagesAgainstSchema();
            this.parserFeatures = ncipConfig.getParserFeatures();
        } else {
            throw new ToolkitException(NCIPServiceContext.class.getName() + " constructor called with " + config.getClass().getName() + ", which is not an instance of " + NCIPServiceValidatorConfiguration.class.getName());
        }
    }

    public boolean requiresApplicationProfileType() {
        return this.requireApplicationProfileType;
    }

    public boolean addDefaultNamespace() {
        return this.addDefaultNamespace;
    }

    public List<ApplicationProfileType> getApplicationProfileTypes() {
        return this.applicationProfileTypes;
    }

    public Map<String, Boolean> getParserFeatures() {
        return this.parserFeatures;
    }

    public DefaultNCIPVersion getVersion() {
        return this.version;
    }

    public void setVersion(DefaultNCIPVersion version) {
        this.version = version;
    }

    public void validateBeforeMarshalling(NCIPMessage ncipMessage) throws ValidationException {
        if ((ncipMessage.getVersion() == null || ncipMessage.getVersion().isEmpty()) && this.version != null) {
            ncipMessage.setVersion(this.version.getVersionAttribute());
        }

    }

    public void validateAfterUnmarshalling(NCIPMessage ncipMessage) throws ValidationException {
        if ((ncipMessage.getVersion() == null || ncipMessage.getVersion().isEmpty()) && this.version != null) {
            ncipMessage.setVersion(this.version.getVersionAttribute());
        }

    }

    public String[] getNamespaceURIs() {
        return this.namespaceURIs;
    }

    public String getDefaultNamespace() {
        return this.defaultNamespace;
    }

    public List<String> getSchemaURLs() {
        return this.schemaURLs;
    }

    public boolean validateMessagesAgainstSchema() {
        return this.validateMessagesAgainstSchema;
    }
}
