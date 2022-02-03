package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseJAXBElementSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.UserIdentifierType;

public class UserIdentifierTypeJAXBElementSchemeValuePairConverter extends BaseJAXBElementSchemeValuePairConverter<SchemeValuePair, UserIdentifierType> {
    public UserIdentifierTypeJAXBElementSchemeValuePairConverter() {
        super(SchemeValuePair.class, UserIdentifierType.class);
    }
}
