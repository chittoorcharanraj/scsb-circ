package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.UserIdentifierType;

public class UserIdentifierTypeSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, UserIdentifierType> {
    public UserIdentifierTypeSchemeValuePairConverter() {
        super(SchemeValuePair.class, UserIdentifierType.class);
    }
}
