package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseJAXBElementSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.ItemIdentifierType;

public class ItemIdentifierTypeJAXBElementSchemeValuePairConverter extends BaseJAXBElementSchemeValuePairConverter<SchemeValuePair, ItemIdentifierType> {
    public ItemIdentifierTypeJAXBElementSchemeValuePairConverter() {
        super(SchemeValuePair.class, ItemIdentifierType.class);
    }
}
