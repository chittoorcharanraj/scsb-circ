package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseJAXBElementSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.UserAddressRoleType;

public class UserAddressRoleTypeJAXBElementSchemeValuePairConverter extends BaseJAXBElementSchemeValuePairConverter<SchemeValuePair, UserAddressRoleType> {
    public UserAddressRoleTypeJAXBElementSchemeValuePairConverter() {
        super(SchemeValuePair.class, UserAddressRoleType.class);
    }
}
