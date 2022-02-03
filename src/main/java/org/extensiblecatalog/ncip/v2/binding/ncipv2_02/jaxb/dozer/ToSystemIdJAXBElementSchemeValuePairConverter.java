package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseJAXBElementSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.ToSystemId;

public class ToSystemIdJAXBElementSchemeValuePairConverter extends BaseJAXBElementSchemeValuePairConverter<SchemeValuePair, ToSystemId> {
    public ToSystemIdJAXBElementSchemeValuePairConverter() {
        super(SchemeValuePair.class, ToSystemId.class);
    }
}
