package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.LocationType;

public class LocationTypeSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, LocationType> {
    public LocationTypeSchemeValuePairConverter() {
        super(SchemeValuePair.class, LocationType.class);
    }
}
