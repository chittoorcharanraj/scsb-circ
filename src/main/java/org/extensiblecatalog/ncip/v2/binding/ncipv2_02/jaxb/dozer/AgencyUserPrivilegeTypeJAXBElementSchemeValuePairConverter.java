package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseJAXBElementSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.AgencyUserPrivilegeType;

public class AgencyUserPrivilegeTypeJAXBElementSchemeValuePairConverter extends BaseJAXBElementSchemeValuePairConverter<SchemeValuePair, AgencyUserPrivilegeType> {
    public AgencyUserPrivilegeTypeJAXBElementSchemeValuePairConverter() {
        super(SchemeValuePair.class, AgencyUserPrivilegeType.class);
    }
}
