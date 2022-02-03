package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseJAXBElementSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.FromSystemId;

public class FromSystemIdJAXBElementSchemeValuePairConverter extends BaseJAXBElementSchemeValuePairConverter<SchemeValuePair, FromSystemId> {
    public FromSystemIdJAXBElementSchemeValuePairConverter() {
        super(SchemeValuePair.class, FromSystemId.class);
    }
}
