package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.ElectronicAddressType;

public class ElectronicAddressTypeSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, ElectronicAddressType> {
    public ElectronicAddressTypeSchemeValuePairConverter() {
        super(SchemeValuePair.class, ElectronicAddressType.class);
    }
}
