package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.AgencyUserPrivilegeType;

public class AgencyUserPrivilegeTypeSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, AgencyUserPrivilegeType> {
    public AgencyUserPrivilegeTypeSchemeValuePairConverter() {
        super(SchemeValuePair.class, AgencyUserPrivilegeType.class);
    }
}
