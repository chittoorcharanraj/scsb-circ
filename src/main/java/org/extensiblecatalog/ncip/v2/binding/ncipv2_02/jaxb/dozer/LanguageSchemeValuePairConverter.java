package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.Language;

public class LanguageSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, Language> {
    public LanguageSchemeValuePairConverter() {
        super(SchemeValuePair.class, Language.class);
    }
}
