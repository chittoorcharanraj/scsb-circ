package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseJAXBElementSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.ItemUseRestrictionType;

public class ItemUseRestrictionTypeJAXBElementSchemeValuePairConverter extends BaseJAXBElementSchemeValuePairConverter<SchemeValuePair, ItemUseRestrictionType> {
    public ItemUseRestrictionTypeJAXBElementSchemeValuePairConverter() {
        super(SchemeValuePair.class, ItemUseRestrictionType.class);
    }
}
