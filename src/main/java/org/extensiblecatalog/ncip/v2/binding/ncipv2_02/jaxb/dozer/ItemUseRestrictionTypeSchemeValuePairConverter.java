package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.ItemUseRestrictionType;

public class ItemUseRestrictionTypeSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, ItemUseRestrictionType> {
    public ItemUseRestrictionTypeSchemeValuePairConverter() {
        super(SchemeValuePair.class, ItemUseRestrictionType.class);
    }
}
