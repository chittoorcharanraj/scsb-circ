package org.extensiblecatalog.ncip.v2.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.extensiblecatalog.ncip.v2.service.ApplicationProfileType;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultNCIPServiceValidatorConfiguration extends BaseToolkitConfiguration implements NCIPServiceValidatorConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(DefaultNCIPServiceValidatorConfiguration.class);
    protected String serviceValidatorClassName;
    protected Protocol protocol;
    protected DefaultNCIPVersion version;
    protected List<ApplicationProfileType> applicationProfileTypes;
    protected boolean requireApplicationProfileType;
    protected String[] namespaceURIs;
    protected String defaultNamespace;
    protected boolean addDefaultNamespaceURI;
    protected List<String> supportedSchemaURLs;
    protected boolean validateMessagesAgainstSchema;
    protected Map<String, Boolean> parserFeatures;
    protected String serviceContextClassName;

    public DefaultNCIPServiceValidatorConfiguration() throws ToolkitException {
        this.serviceValidatorClassName = ServiceValidatorConfiguration.SERVICE_VALIDATOR_CLASS_NAME_DEFAULT;
        this.protocol = Protocol.NCIP;
        this.version = DefaultNCIPVersion.VERSION_2_0;
        this.applicationProfileTypes = new ArrayList(1);
        this.requireApplicationProfileType = false;
        this.namespaceURIs = "http://www.niso.org/2008/ncip".split(",");
        this.defaultNamespace = "http://www.niso.org/2008/ncip";
        this.addDefaultNamespaceURI = false;
        this.supportedSchemaURLs = ToolkitHelper.createStringList("ncip_v2_02.xsd");
        this.validateMessagesAgainstSchema = true;
        this.parserFeatures = new HashMap();
        this.serviceContextClassName = ServiceValidatorConfiguration.SERVICE_VALIDATOR_SERVICE_CONTEXT_CLASS_NAME_DEFAULT;
    }

    public DefaultNCIPServiceValidatorConfiguration(String appName) throws ToolkitException {
        this(appName, (Properties)null);
    }

    public DefaultNCIPServiceValidatorConfiguration(Properties properties) throws ToolkitException {
        this((String)null, properties);
    }

    public DefaultNCIPServiceValidatorConfiguration(String appName, Properties properties) throws ToolkitException {
        super(appName, properties);
        this.serviceValidatorClassName = ServiceValidatorConfiguration.SERVICE_VALIDATOR_CLASS_NAME_DEFAULT;
        this.protocol = Protocol.NCIP;
        this.version = DefaultNCIPVersion.VERSION_2_0;
        this.applicationProfileTypes = new ArrayList(1);
        this.requireApplicationProfileType = false;
        this.namespaceURIs = "http://www.niso.org/2008/ncip".split(",");
        this.defaultNamespace = "http://www.niso.org/2008/ncip";
        this.addDefaultNamespaceURI = false;
        this.supportedSchemaURLs = ToolkitHelper.createStringList("ncip_v2_02.xsd");
        this.validateMessagesAgainstSchema = true;
        this.parserFeatures = new HashMap();
        this.serviceContextClassName = ServiceValidatorConfiguration.SERVICE_VALIDATOR_SERVICE_CONTEXT_CLASS_NAME_DEFAULT;
        String classNameString = null;
        String nameString = null;
        String profileString = null;
        String namespaceURIsString = null;
        String defaultNamespaceString = null;
        String addDefaultNamespaceString = null;
        String supportedSchemaURLsString = null;
        String validateMessagesAgainstSchemaString = null;
        String parserFeaturesString = null;
        String serviceContextClassNameString = null;
        if (this.properties != null) {
            classNameString = this.properties.getProperty("ServiceValidatorConfiguration.ClassName", ServiceValidatorConfiguration.SERVICE_VALIDATOR_CLASS_NAME_DEFAULT);
            nameString = this.properties.getProperty("NCIPServiceValidatorConfiguration.Protocol", "NCIP");
            profileString = this.properties.getProperty("NCIPServiceValidatorConfiguration.ProtocolProfile", NCIPServiceValidatorConfiguration.PROTOCOL_PROFILE_DEFAULT);
            namespaceURIsString = this.properties.getProperty("NCIPServiceValidatorConfiguration.NamespaceURIs", "http://www.niso.org/2008/ncip");
            defaultNamespaceString = this.properties.getProperty("NCIPServiceValidatorConfiguration.DefaultNamespaceURI", "http://www.niso.org/2008/ncip");
            addDefaultNamespaceString = this.properties.getProperty("NCIPServiceValidatorConfiguration.AddDefaultNamespaceURI", "false");
            supportedSchemaURLsString = this.properties.getProperty("NCIPServiceValidatorConfiguration.SupportedSchemaURLs", "ncip_v2_02.xsd");
            validateMessagesAgainstSchemaString = this.properties.getProperty("NCIPServiceValidatorConfiguration.ValidateMessagesAgainstSchema", "true");
            parserFeaturesString = this.properties.getProperty("NCIPServiceValidatorConfiguration.ParserFeatures", NCIPServiceValidatorConfiguration.PARSER_FEATURES_DEFAULT);
            serviceContextClassNameString = this.properties.getProperty("ServiceValidatorConfiguration.ServiceContextClassName", NCIPServiceValidatorConfiguration.SERVICE_VALIDATOR_SERVICE_CONTEXT_CLASS_NAME_DEFAULT);
        }

        if (classNameString != null) {
            this.serviceValidatorClassName = classNameString;
        }

        if (nameString != null) {
            Protocol tempProtocol = Protocol.valueOf(nameString);
            if (tempProtocol != null) {
                this.protocol = tempProtocol;
            } else {
                logger.warn("Protocol '" + nameString + "' is not valid; using default of '" + Protocol.NCIP.getName() + "'.");
                this.protocol = Protocol.NCIP;
            }
        }

        this.version = (DefaultNCIPVersion)ProtocolVersionFactory.buildProtocolVersion(properties);
        if (profileString != null) {
            ApplicationProfileType tempProfile = this.protocol.getProfile(profileString);
            if (tempProfile != null) {
                this.applicationProfileTypes.add(tempProfile);
            } else {
                logger.warn("ApplicationProfileType '" + profileString + "' is not recognized; ignoring this value.");
            }
        }

        String[] parserFeaturesArray;
        if (namespaceURIsString != null) {
            parserFeaturesArray = namespaceURIsString.split(",");
            if (parserFeaturesArray != null && parserFeaturesArray.length > 0) {
                this.namespaceURIs = parserFeaturesArray;
            } else {
                logger.warn("NamespaceURIs is empty; using default.");
            }
        }

        if (defaultNamespaceString != null) {
            this.defaultNamespace = defaultNamespaceString;
        }

        if (addDefaultNamespaceString != null) {
            this.addDefaultNamespaceURI = Boolean.parseBoolean(addDefaultNamespaceString);
        }

        if (supportedSchemaURLsString != null) {
            List<String> schemaURLsList = ToolkitHelper.createStringList(supportedSchemaURLsString);
            if (schemaURLsList != null && !schemaURLsList.isEmpty()) {
                this.supportedSchemaURLs = schemaURLsList;
            } else {
                logger.warn("SchemaURLs is empty; no XML validation will be performed.");
            }
        }

        if (validateMessagesAgainstSchemaString != null) {
            this.validateMessagesAgainstSchema = Boolean.parseBoolean(validateMessagesAgainstSchemaString);
        }

        if (parserFeaturesString != null) {
            parserFeaturesArray = parserFeaturesString.split(",");
            if (parserFeaturesArray.length > 0) {
                String[] var14 = parserFeaturesArray;
                int var15 = parserFeaturesArray.length;

                for(int var16 = 0; var16 < var15; ++var16) {
                    String parserFeature = var14[var16];
                    String[] featureHalves = parserFeature.split("=");
                    if (featureHalves.length == 2) {
                        this.parserFeatures.put(featureHalves[0], Boolean.parseBoolean(featureHalves[1]));
                    } else {
                        logger.warn("ParserFeatures element '" + parserFeature + "' lacks an equals sign or has more than one.");
                    }
                }
            } else {
                logger.warn("ParserFeatures is empty.");
            }
        }

        if (serviceContextClassNameString != null) {
            this.serviceContextClassName = serviceContextClassNameString;
        }

    }

    public void setServiceValidatorClassName(String serviceValidatorClassName) {
        this.serviceValidatorClassName = serviceValidatorClassName;
    }

    public String getComponentClassName() {
        return this.serviceValidatorClassName;
    }

    public void setComponentClassName(String componentClassName) {
        this.serviceValidatorClassName = componentClassName;
    }

    public void setVersion(DefaultNCIPVersion version) {
        this.version = version;
    }

    public DefaultNCIPVersion getVersion() {
        return this.version;
    }

    public void setApplicationProfileTypes(List<ApplicationProfileType> applicationProfileTypes) {
        this.applicationProfileTypes = applicationProfileTypes;
    }

    public List<ApplicationProfileType> getApplicationProfileTypes() {
        return this.applicationProfileTypes;
    }

    public boolean requireApplicationProfileType() {
        return this.requireApplicationProfileType;
    }

    public void setNamespaceURIs(String[] namespaceURIs) {
        this.namespaceURIs = namespaceURIs;
    }

    public String[] getNamespaceURIs() {
        return this.namespaceURIs;
    }

    public String getDefaultNamespaceURI() {
        return this.defaultNamespace;
    }

    public boolean addDefaultNamespaceURI() {
        return this.addDefaultNamespaceURI;
    }

    public void setSupportedSchemaURLs(List<String> supportedSchemaURLs) {
        this.supportedSchemaURLs = supportedSchemaURLs;
    }

    public List<String> getSupportedSchemaURLs() {
        return this.supportedSchemaURLs;
    }

    public boolean validateMessagesAgainstSchema() {
        return this.validateMessagesAgainstSchema;
    }

    public void setParserFeatures(Map<String, Boolean> parserFeatures) {
        this.parserFeatures = parserFeatures;
    }

    public Map<String, Boolean> getParserFeatures() {
        return this.parserFeatures;
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public boolean isRequireApplicationProfileType() {
        return this.requireApplicationProfileType;
    }

    public void setRequireApplicationProfileType(boolean requireApplicationProfileType) {
        this.requireApplicationProfileType = requireApplicationProfileType;
    }

    public String getDefaultNamespace() {
        return this.defaultNamespace;
    }

    public void setDefaultNamespace(String defaultNamespace) {
        this.defaultNamespace = defaultNamespace;
    }

    public boolean isAddDefaultNamespaceURI() {
        return this.addDefaultNamespaceURI;
    }

    public void setAddDefaultNamespaceURI(boolean addDefaultNamespaceURI) {
        this.addDefaultNamespaceURI = addDefaultNamespaceURI;
    }

    public boolean isValidateMessagesAgainstSchema() {
        return this.validateMessagesAgainstSchema;
    }

    public void setValidateMessagesAgainstSchema(boolean validateMessagesAgainstSchema) {
        this.validateMessagesAgainstSchema = validateMessagesAgainstSchema;
    }

    public String getServiceContextClassName() {
        return this.serviceContextClassName;
    }

    public void setServiceContextClassName(String serviceContextClassName) {
        this.serviceContextClassName = serviceContextClassName;
    }
}
