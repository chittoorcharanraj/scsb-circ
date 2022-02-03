package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.UserLanguage;

public class UserLanguageSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, UserLanguage> {
    public UserLanguageSchemeValuePairConverter() {
        super(SchemeValuePair.class, UserLanguage.class);
    }
}
