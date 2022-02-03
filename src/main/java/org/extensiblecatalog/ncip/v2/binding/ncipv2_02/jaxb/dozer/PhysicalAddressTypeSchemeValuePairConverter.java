package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.PhysicalAddressType;

public class PhysicalAddressTypeSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, PhysicalAddressType> {
    public PhysicalAddressTypeSchemeValuePairConverter() {
        super(SchemeValuePair.class, PhysicalAddressType.class);
    }
}
