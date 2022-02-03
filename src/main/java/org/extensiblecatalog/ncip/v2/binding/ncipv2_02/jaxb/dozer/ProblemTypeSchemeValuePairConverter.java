package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.ProblemType;

public class ProblemTypeSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, ProblemType> {
    public ProblemTypeSchemeValuePairConverter() {
        super(SchemeValuePair.class, ProblemType.class);
    }
}
