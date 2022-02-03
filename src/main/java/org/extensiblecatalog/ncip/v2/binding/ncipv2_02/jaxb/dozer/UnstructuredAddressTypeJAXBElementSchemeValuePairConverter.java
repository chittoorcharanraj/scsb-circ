package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseJAXBElementSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.UnstructuredAddressType;

public class UnstructuredAddressTypeJAXBElementSchemeValuePairConverter extends BaseJAXBElementSchemeValuePairConverter<SchemeValuePair, UnstructuredAddressType> {
    public UnstructuredAddressTypeJAXBElementSchemeValuePairConverter() {
        super(SchemeValuePair.class, UnstructuredAddressType.class);
    }
}
