package org.extensiblecatalog.ncip.v2.binding.jaxb.dozer;

import java.util.List;
import java.util.Properties;
import org.extensiblecatalog.ncip.v2.common.DefaultNCIP2TranslatorConfiguration;
import org.extensiblecatalog.ncip.v2.common.ToolkitHelper;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JAXBDozerNCIP2TranslatorConfiguration extends DefaultNCIP2TranslatorConfiguration implements DozerTranslatorConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(JAXBDozerNCIP2TranslatorConfiguration.class);
    protected List<String> mappingFileNamesList;

    public JAXBDozerNCIP2TranslatorConfiguration() throws ToolkitException {
        this((String)null, (Properties)null);
    }

    public JAXBDozerNCIP2TranslatorConfiguration(String appName) throws ToolkitException {
        this(appName, (Properties)null);
    }

    public JAXBDozerNCIP2TranslatorConfiguration(Properties properties) throws ToolkitException {
        this((String)null, properties);
    }

    public JAXBDozerNCIP2TranslatorConfiguration(String appName, Properties properties) throws ToolkitException {
        super(appName, properties);
        if (properties != null) {
            String mappingFileNamesListString = this.properties.getProperty("DozerTranslatorConfiguration.MappingFiles", "ncipv2_02_mappings.xml");
            if (mappingFileNamesListString == null) {
                throw new ToolkitException("Property DozerTranslatorConfiguration.MappingFiles is null and  DozerTranslatorConfiguration.MAPPING_FILES_DEFAULT is null.");
            }

            this.mappingFileNamesList = ToolkitHelper.createStringList(mappingFileNamesListString);
        }

    }

    public List<String> getMappingFiles() {
        return this.mappingFileNamesList;
    }

    public void setMappingFiles(List<String> mappingFileNamesList) {
        this.mappingFileNamesList = mappingFileNamesList;
    }
}
