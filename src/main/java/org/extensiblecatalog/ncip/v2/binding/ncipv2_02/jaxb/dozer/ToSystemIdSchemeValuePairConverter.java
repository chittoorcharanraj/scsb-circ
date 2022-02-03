package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.ToSystemId;

public class ToSystemIdSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, ToSystemId> {
    public ToSystemIdSchemeValuePairConverter() {
        super(SchemeValuePair.class, ToSystemId.class);
    }
}
