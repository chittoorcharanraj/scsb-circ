package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.RequestType;

public class RequestTypeSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, RequestType> {
    public RequestTypeSchemeValuePairConverter() {
        super(SchemeValuePair.class, RequestType.class);
    }
}
