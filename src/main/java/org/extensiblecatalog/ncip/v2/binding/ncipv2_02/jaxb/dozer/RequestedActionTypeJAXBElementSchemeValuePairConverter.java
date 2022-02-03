package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseJAXBElementSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.RequestedActionType;

public class RequestedActionTypeJAXBElementSchemeValuePairConverter extends BaseJAXBElementSchemeValuePairConverter<SchemeValuePair, RequestedActionType> {
    public RequestedActionTypeJAXBElementSchemeValuePairConverter() {
        super(SchemeValuePair.class, RequestedActionType.class);
    }
}
