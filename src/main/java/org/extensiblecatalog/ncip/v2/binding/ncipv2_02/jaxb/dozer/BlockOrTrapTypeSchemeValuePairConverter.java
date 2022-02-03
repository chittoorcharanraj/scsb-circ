package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.BlockOrTrapType;

public class BlockOrTrapTypeSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, BlockOrTrapType> {
    public BlockOrTrapTypeSchemeValuePairConverter() {
        super(SchemeValuePair.class, BlockOrTrapType.class);
    }
}
