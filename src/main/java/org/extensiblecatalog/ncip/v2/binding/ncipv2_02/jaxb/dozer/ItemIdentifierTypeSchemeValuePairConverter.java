package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.ItemIdentifierType;

public class ItemIdentifierTypeSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, ItemIdentifierType> {
    public ItemIdentifierTypeSchemeValuePairConverter() {
        super(SchemeValuePair.class, ItemIdentifierType.class);
    }
}
