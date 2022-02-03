package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;

public class NCIPv2_02SchemeValuePairConverter extends BaseSchemeValuePairConverter {
    public NCIPv2_02SchemeValuePairConverter() {
        super(SchemeValuePair.class, org.extensiblecatalog.ncip.v2.service.SchemeValuePair.class);
    }
}
