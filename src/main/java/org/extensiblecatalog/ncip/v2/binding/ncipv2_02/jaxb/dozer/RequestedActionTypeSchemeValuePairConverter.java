package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.RequestedActionType;

public class RequestedActionTypeSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, RequestedActionType> {
    public RequestedActionTypeSchemeValuePairConverter() {
        super(SchemeValuePair.class, RequestedActionType.class);
    }
}
