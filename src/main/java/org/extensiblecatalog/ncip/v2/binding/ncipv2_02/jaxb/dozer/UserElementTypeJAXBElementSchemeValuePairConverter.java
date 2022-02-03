package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseJAXBElementSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.UserElementType;

public class UserElementTypeJAXBElementSchemeValuePairConverter extends BaseJAXBElementSchemeValuePairConverter<SchemeValuePair, UserElementType> {
    public UserElementTypeJAXBElementSchemeValuePairConverter() {
        super(SchemeValuePair.class, UserElementType.class);
    }
}
