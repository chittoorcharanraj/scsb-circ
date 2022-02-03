package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseJAXBElementSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.BlockOrTrapType;

public class BlockOrTrapTypeJAXBElementSchemeValuePairConverter extends BaseJAXBElementSchemeValuePairConverter<SchemeValuePair, BlockOrTrapType> {
    public BlockOrTrapTypeJAXBElementSchemeValuePairConverter() {
        super(SchemeValuePair.class, BlockOrTrapType.class);
    }
}
