package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseJAXBElementSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.ElectronicAddressType;

public class ElectronicAddressTypeJAXBElementSchemeValuePairConverter extends BaseJAXBElementSchemeValuePairConverter<SchemeValuePair, ElectronicAddressType> {
    public ElectronicAddressTypeJAXBElementSchemeValuePairConverter() {
        super(SchemeValuePair.class, ElectronicAddressType.class);
    }
}
