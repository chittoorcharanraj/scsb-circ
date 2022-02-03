package org.extensiblecatalog.ncip.v2.binding.jaxb;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.extensiblecatalog.ncip.v2.common.NCIP2TranslatorConfiguration;
import org.extensiblecatalog.ncip.v2.common.NCIPServiceContext;
import org.extensiblecatalog.ncip.v2.common.ToolkitHelper;
import org.extensiblecatalog.ncip.v2.common.TranslatorConfiguration;
import org.extensiblecatalog.ncip.v2.service.PhysicalAddressType;
import org.extensiblecatalog.ncip.v2.service.ServiceContext;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

public class MarshallerFactory {
    private static final Logger logger = LoggerFactory.getLogger(MarshallerFactory.class);
    protected final Map<String, Schema> schemasByCanonicalURLsCSVList = new HashMap();
    protected Map<String, String> canonicalSchemaURLMap = new HashMap();
    protected Map<String, String> schemaURLsToPackageMap = new HashMap();

    public MarshallerFactory() throws ToolkitException {
    }

    public MarshallerFactory(TranslatorConfiguration config) {
        NCIP2TranslatorConfiguration ncipConfig = (NCIP2TranslatorConfiguration)config;
        Map<String, String> schemaURLsToPackageMap = ncipConfig.getSchemaURLsToPackageMap();
        if (schemaURLsToPackageMap != null && !schemaURLsToPackageMap.isEmpty()) {
            this.schemaURLsToPackageMap = schemaURLsToPackageMap;
        }

        Map<String, String> canonicalSchemaURLMap = ncipConfig.getCanonicalSchemaURLMap();
        if (canonicalSchemaURLMap != null && !canonicalSchemaURLMap.isEmpty()) {
            this.canonicalSchemaURLMap = canonicalSchemaURLMap;
        }

    }

    public void setSchemaURLsToPackageMap(Map<String, String> schemaURLsToPackageMap) {
        this.schemaURLsToPackageMap = schemaURLsToPackageMap;
    }

    public void setCanonicalSchemaURLMap(Map<String, String> canonicalSchemaURLMap) {
        this.canonicalSchemaURLMap = canonicalSchemaURLMap;
    }

    protected JAXBContext getJAXBContext(List<String> schemaURLsList) {
        List<String> packageNameList = new ArrayList();
        if (schemaURLsList != null && !schemaURLsList.isEmpty()) {
            Iterator var4 = schemaURLsList.iterator();

            while(var4.hasNext()) {
                String schemaURL = (String)var4.next();
                String packageName = this.getPackageNameForSchemaURL(schemaURL);
                if (packageName != null && !packageName.isEmpty() && !packageNameList.contains(packageName)) {
                    packageNameList.add(packageName);
                }
            }
        }

        String colonSeparatedPackageNames = ToolkitHelper.concatenateStrings(packageNameList, ":");

        try {
            JAXBContext jaxbContext = JAXBContextFactory.getJAXBContext(colonSeparatedPackageNames);
            return jaxbContext;
        } catch (ToolkitException var7) {
            logger.error("Exception getting JAXBContext:", var7);
            throw new ExceptionInInitializerError(var7);
        }
    }

    public Marshaller getMarshaller(ServiceContext serviceContext) throws ToolkitException {
        if (serviceContext instanceof NCIPServiceContext) {
            NCIPServiceContext ncipServiceContext = (NCIPServiceContext)serviceContext;

            try {
                List<String> schemaURLsList = ncipServiceContext.getSchemaURLs();
                Marshaller marshaller = this.getJAXBContext(schemaURLsList).createMarshaller();
                if (ncipServiceContext.validateMessagesAgainstSchema()) {
                    Schema schema = this.getSchema(ncipServiceContext.getSchemaURLs());
                    if (schema != null) {
                        marshaller.setSchema(schema);
                    }
                }

                MarshallerFactory.PreferredMapper mapper = new MarshallerFactory.PreferredMapper(ncipServiceContext);
                marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", mapper);
                return marshaller;
            } catch (JAXBException var6) {
                throw new ToolkitException("JAXBException creating Marshaller.", var6);
            }
        } else {
            throw new ToolkitException("ServiceContext of '" + serviceContext.getClass().getName() + "' not supported; must be an instance of NCIPServiceContext.");
        }
    }

    public Unmarshaller getUnmarshaller(ServiceContext serviceContext) throws ToolkitException {
        if (serviceContext instanceof NCIPServiceContext) {
            try {
                NCIPServiceContext ncipServiceContext = (NCIPServiceContext)serviceContext;
                Unmarshaller unmarshaller = this.getJAXBContext(ncipServiceContext.getSchemaURLs()).createUnmarshaller();
                if (ncipServiceContext.validateMessagesAgainstSchema()) {
                    Schema schema = this.getSchema(ncipServiceContext.getSchemaURLs());
                    if (schema != null) {
                        unmarshaller.setSchema(schema);
                    }
                }

                return unmarshaller;
            } catch (JAXBException var5) {
                throw new ToolkitException("JAXBException creating Unmarshaller.", var5);
            }
        } else {
            throw new ToolkitException("ServiceContext of '" + serviceContext.getClass().getName() + "' not supported; must be an instance of NCIPServiceContext.");
        }
    }

    protected Schema getSchema(List<String> schemaURLs) {
        Schema schema = null;
        if (schemaURLs != null && !schemaURLs.isEmpty()) {
            List<String> canonicalSchemaURLsList = new ArrayList(schemaURLs.size());
            Iterator var4 = schemaURLs.iterator();

            while(var4.hasNext()) {
                String schemaURL = (String)var4.next();
                canonicalSchemaURLsList.add(this.canonicalizeSchemaURL(schemaURL));
            }

            Collections.sort(canonicalSchemaURLsList);
            String schemaURLsCSV = ToolkitHelper.concatenateStrings(canonicalSchemaURLsList, ",");
            if (this.schemasByCanonicalURLsCSVList.containsKey(schemaURLsCSV)) {
                schema = (Schema)this.schemasByCanonicalURLsCSVList.get(schemaURLsCSV);
            } else {
                schema = loadSchema(schemaURLs);
                this.schemasByCanonicalURLsCSVList.put(schemaURLsCSV, schema);
            }
        }

        return schema;
    }

    protected String canonicalizeSchemaURL(String inSchemaURL) {
        String canonicalSchemaURL = inSchemaURL;
        if (this.canonicalSchemaURLMap.containsKey(inSchemaURL)) {
            canonicalSchemaURL = (String)this.canonicalSchemaURLMap.get(inSchemaURL);
        }

        return canonicalSchemaURL;
    }

    protected String getPackageNameForSchemaURL(String schemaURL) {
        String canonicalSchemaURL = this.canonicalizeSchemaURL(schemaURL);
        return (String)this.schemaURLsToPackageMap.get(canonicalSchemaURL);
    }

    protected static Schema loadSchema(List<String> schemaURLs) {
        Schema schema = null;
        if (schemaURLs != null && schemaURLs.size() > 0) {
            int schemaCount = schemaURLs.size();
            logger.debug(schemaCount + " schema URLs were found for validating messages.");
            StreamSource[] schemaSources = new StreamSource[schemaCount];

            try {
                int schemaIndex = 0;
                Iterator var5 = schemaURLs.iterator();

                while(var5.hasNext()) {
                    String schemaURL = (String)var5.next();
                    StreamSource streamSource;
                    String systemId;
                    if (schemaURL.startsWith("http")) {
                        logger.info("Loading schema '" + schemaURL + "' as a network resource.");
                        URL url = new URL(schemaURL);
                        streamSource = new StreamSource(url.openStream());
                        systemId = url.toURI().toString();
                    } else {
                        logger.info("Loading schema '" + schemaURL + "' as a resource via ClassLoader or as a file.");
                        streamSource = new StreamSource(ToolkitHelper.getResourceOrFile(schemaURL));
                        systemId = schemaURL;
                    }

                    logger.info("Setting system id to '" + systemId + "'.");
                    streamSource.setSystemId(systemId);
                    schemaSources[schemaIndex++] = streamSource;
                    logger.info("Loaded schema '" + schemaURL + "'.");
                }

                SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
                logger.info("Setting schema sources.");
                schema = schemaFactory.newSchema(schemaSources);
            } catch (SAXException var10) {
                logger.warn("SAXException creating the Schema object for marshaling.", var10);
            } catch (MalformedURLException var11) {
                logger.warn("MalformedURLException creating the Schema object for marshaling.", var11);
            } catch (URISyntaxException var12) {
                logger.warn("URISyntaxException creating the Schema object for marshaling.", var12);
            } catch (IOException var13) {
                logger.warn("IOException creating the Schema object for marshaling.", var13);
            }

            if (schema == null) {
                logger.warn("Schema is null; messages will not be validated against the schema.");
            }
        } else {
            logger.warn("supportedSchemaURLs is null or the list is empty; messages can not be validated against the schema.");
        }

        return schema;
    }

    public class PreferredMapper extends NamespacePrefixMapper {
        protected String[] namespaceURIs;
        protected String defaultNamespace;

        public PreferredMapper(NCIPServiceContext serviceContext) {
            this.namespaceURIs = serviceContext.getNamespaceURIs();
            String[] var3 = this.namespaceURIs;
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String uri = var3[var5];
                uri.intern();
            }

            this.defaultNamespace = serviceContext.getDefaultNamespace();
            this.defaultNamespace.intern();
        }

        public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
            return this.defaultNamespace != null && !requirePrefix && namespaceUri != null && this.defaultNamespace.equals(namespaceUri) ? "" : null;
        }

        public String[] getPreDeclaredNamespaceUris() {
            return this.namespaceURIs;
        }
    }
}
