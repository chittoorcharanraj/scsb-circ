package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.SecurityMarker;

public class SecurityMarkerSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, SecurityMarker> {
    public SecurityMarkerSchemeValuePairConverter() {
        super(SchemeValuePair.class, SecurityMarker.class);
    }
}
