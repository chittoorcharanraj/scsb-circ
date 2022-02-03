package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.PickupLocation;

public class PickupLocationSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, PickupLocation> {
    public PickupLocationSchemeValuePairConverter() {
        super(SchemeValuePair.class, PickupLocation.class);
    }
}
