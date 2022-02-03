package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.UnstructuredAddressType;

public class UnstructuredAddressTypeSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, UnstructuredAddressType> {
    public UnstructuredAddressTypeSchemeValuePairConverter() {
        super(SchemeValuePair.class, UnstructuredAddressType.class);
    }
}
