package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserAddressRoleType extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(UserAddressRoleType.class);
    private static final List<UserAddressRoleType> VALUES_LIST = new CopyOnWriteArrayList();

    public UserAddressRoleType(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public UserAddressRoleType(String value) {
        super(value);
        VALUES_LIST.add(this);
    }

    public static UserAddressRoleType find(String scheme, String value) throws ServiceException {
        return (UserAddressRoleType)find(scheme, value, VALUES_LIST, UserAddressRoleType.class);
    }
}
