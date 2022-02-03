package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import java.util.ArrayList;
import java.util.List;
import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairToBooleanConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;

public class NCIPv2_02SchemeValuePairToBooleanConverter extends BaseSchemeValuePairToBooleanConverter {
    private static final List<SchemeValuePair> jaxbSVPList = new ArrayList();

    public NCIPv2_02SchemeValuePairToBooleanConverter() {
        super(jaxbSVPList.getClass(), SchemeValuePair.class);
    }
}
