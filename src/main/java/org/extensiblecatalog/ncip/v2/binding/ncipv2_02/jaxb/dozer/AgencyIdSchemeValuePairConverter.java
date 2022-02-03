package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.AgencyId;

public class AgencyIdSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, AgencyId> {
    public AgencyIdSchemeValuePairConverter() {
        super(SchemeValuePair.class, AgencyId.class);
    }
}
