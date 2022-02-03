package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseJAXBElementSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.UserPrivilegeStatusType;

public class UserPrivilegeStatusTypeJAXBElementSchemeValuePairConverter extends BaseJAXBElementSchemeValuePairConverter<SchemeValuePair, UserPrivilegeStatusType> {
    public UserPrivilegeStatusTypeJAXBElementSchemeValuePairConverter() {
        super(SchemeValuePair.class, UserPrivilegeStatusType.class);
    }
}
