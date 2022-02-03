package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.RequestIdentifierType;

public class RequestIdentifierTypeSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, RequestIdentifierType> {
    public RequestIdentifierTypeSchemeValuePairConverter() {
        super(SchemeValuePair.class, RequestIdentifierType.class);
    }
}
