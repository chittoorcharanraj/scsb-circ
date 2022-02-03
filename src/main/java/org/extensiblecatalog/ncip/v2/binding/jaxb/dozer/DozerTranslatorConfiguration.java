package org.extensiblecatalog.ncip.v2.binding.jaxb.dozer;

import java.util.List;
import org.extensiblecatalog.ncip.v2.common.TranslatorConfiguration;

public interface DozerTranslatorConfiguration extends TranslatorConfiguration {
    String MAPPING_FILES_KEY = "DozerTranslatorConfiguration.MappingFiles";
    String MAPPING_FILES_DEFAULT = "ncipv2_02_mappings.xml";

    List<String> getMappingFiles();

    void setMappingFiles(List<String> var1);
}
