package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import org.extensiblecatalog.ncip.v2.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.UserAddressRoleType;

public class UserAddressRoleTypeSchemeValuePairConverter extends BaseSchemeValuePairConverter<SchemeValuePair, UserAddressRoleType> {
    public UserAddressRoleTypeSchemeValuePairConverter() {
        super(SchemeValuePair.class, UserAddressRoleType.class);
    }
}
