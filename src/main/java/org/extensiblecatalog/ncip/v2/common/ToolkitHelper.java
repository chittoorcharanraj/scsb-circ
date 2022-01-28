package org.extensiblecatalog.ncip.v2.common;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Map.Entry;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.extensiblecatalog.ncip.v2.service.ServiceError;
import org.extensiblecatalog.ncip.v2.service.ServiceException;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ToolkitHelper {
    private static final Logger logger = LoggerFactory.getLogger(ToolkitHelper.class);

    public ToolkitHelper() {
    }

    public static String convertStreamToString(InputStream inStream) throws ToolkitException {
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream, "UTF-8"));

            int n;
            while((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException var13) {
            throw new ToolkitException("UnsupportedEncodingException: ", var13);
        } catch (IOException var14) {
            throw new ToolkitException("IOException: .", var14);
        } finally {
            try {
                inStream.close();
            } catch (IOException var12) {
                logger.warn("IOException:", var12);
            }

        }

        return writer.toString();
    }

    public static void prettyPrintXML(InputStream msgStream, Writer outWriter) throws ServiceException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        Document document;
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(msgStream);
            document = db.parse(is);
        } catch (ParserConfigurationException var11) {
            throw new ServiceException(ServiceError.RUNTIME_ERROR, var11);
        } catch (SAXException var12) {
            throw new ServiceException(ServiceError.RUNTIME_ERROR, var12);
        } catch (IOException var13) {
            throw new ServiceException(ServiceError.RUNTIME_ERROR, var13);
        }

        try {
            msgStream.close();
        } catch (IOException var10) {
            throw new ServiceException(ServiceError.RUNTIME_ERROR, var10);
        }

        DOMImplementation domImplementation = document.getImplementation();
        if (domImplementation.hasFeature("LS", "3.0") && domImplementation.hasFeature("Core", "2.0")) {
            DOMImplementationLS domImplementationLS = (DOMImplementationLS)domImplementation.getFeature("LS", "3.0");
            LSSerializer lsSerializer = domImplementationLS.createLSSerializer();
            DOMConfiguration domConfiguration = lsSerializer.getDomConfig();
            if (domConfiguration.canSetParameter("format-pretty-print", Boolean.TRUE)) {
                lsSerializer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE);
                LSOutput lsOutput = domImplementationLS.createLSOutput();
                lsOutput.setEncoding("UTF-8");
                lsOutput.setCharacterStream(outWriter);
                lsSerializer.write(document, lsOutput);

                try {
                    outWriter.close();
                } catch (IOException var9) {
                    logger.warn("Error closing outWriter", var9);
                }

            } else {
                throw new ServiceException(ServiceError.RUNTIME_ERROR, "DOMConfiguration 'format-pretty-print' parameter isn't settable.");
            }
        } else {
            throw new ServiceException(ServiceError.RUNTIME_ERROR, "DOM 3.0 LS and/or DOM 2.0 Core not supported.");
        }
    }

    public static InputStream getResourceOrFile(String resourceOrFileName) {
        return getResourceOrFile(resourceOrFileName, true);
    }

    public static InputStream getResourceOrFile(String resourceOrFileName, boolean logExceptionStackTrace) {
        InputStream inputStream = ToolkitHelper.class.getClassLoader().getResourceAsStream(resourceOrFileName);
        if (inputStream == null) {
            try {
                logger.debug("Resource '" + resourceOrFileName + "' not found; trying as file.");
                inputStream = new FileInputStream(resourceOrFileName);
            } catch (FileNotFoundException var4) {
                if (logExceptionStackTrace) {
                    logger.debug("FileNotFoundException loading file '" + resourceOrFileName + "'; returning null.", var4);
                } else {
                    logger.debug("FileNotFoundException loading file '" + resourceOrFileName + "'; returning null.");
                }
            }
        }

        return (InputStream)inputStream;
    }

    public static List<String> createStringList(String csvString) {
        Object result;
        if (csvString != null && !csvString.isEmpty()) {
            String[] schemaURLs = csvString.split(", ?");
            result = Arrays.asList(schemaURLs);
        } else {
            result = new ArrayList(0);
        }

        return (List)result;
    }

    public static String concatenateStrings(List<String> strings, String separator) {
        String result = "";
        if (strings != null && !strings.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator var4 = strings.iterator();

            while(var4.hasNext()) {
                String s = (String)var4.next();
                sb.append(s).append(separator);
            }

            result = sb.toString();
            result = result.substring(0, result.length() - separator.length());
        }

        return result;
    }

    public static void setPropertiesFromClasspathOrFilesystem(Properties properties, String propertiesFileName) {
        logger.debug("Trying to load " + propertiesFileName);
        InputStream inputStream = getResourceOrFile(propertiesFileName, false);
        if (inputStream != null) {
            try {
                logger.debug("Adding properties from " + propertiesFileName);
                Properties newProperties = new Properties();
                newProperties.load(inputStream);
                if (logger.isDebugEnabled()) {
                    logger.debug("New properties from '" + propertiesFileName + "':");
                    dumpProperties(logger, newProperties);
                    logger.debug("Properties that will be replaced from '" + propertiesFileName + "':");
                    logReplacedProperties(logger, properties, newProperties);
                }

                properties.putAll(newProperties);
            } catch (IOException var4) {
                logger.warn("IOException loading properties from file '" + propertiesFileName + "'.", var4);
            }
        }

    }

    public static void dumpProperties(Logger log, Properties properties) {
        Iterator var2 = properties.entrySet().iterator();

        while(var2.hasNext()) {
            Entry<Object, Object> entry = (Entry)var2.next();
            log.debug(entry.getKey() + "=" + entry.getValue());
        }

    }

    public static void logReplacedProperties(Logger log, Properties existingProperties, Properties newProperties) {
        boolean replacementsFound = false;
        Iterator var4 = newProperties.entrySet().iterator();

        while(var4.hasNext()) {
            Entry<Object, Object> entry = (Entry)var4.next();
            if (existingProperties.contains(entry.getKey())) {
                replacementsFound = true;
                log.debug("For key '" + entry.getKey() + "', existing value of '" + existingProperties.get(entry.getKey()) + "' will be replaced by '" + entry.getValue() + ".");
            }
        }

        if (!replacementsFound) {
            log.debug("No keys in the new properties matched the keys of existing properties.");
        }

    }
}
