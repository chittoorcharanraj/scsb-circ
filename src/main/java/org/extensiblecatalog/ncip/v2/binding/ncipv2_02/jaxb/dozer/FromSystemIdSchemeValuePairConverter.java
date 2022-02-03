package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.FromSystemId;

public class FromSystemIdSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, FromSystemId> {
    public FromSystemIdSchemeValuePairConverter() {
        super(SchemeValuePair.class, FromSystemId.class);
    }
}
