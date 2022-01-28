package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserIdentifierType extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(UserIdentifierType.class);
    private static final List<UserIdentifierType> VALUES_LIST = new CopyOnWriteArrayList();

    public UserIdentifierType(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public UserIdentifierType(String value) {
        super(value);
        VALUES_LIST.add(this);
    }

    public static UserIdentifierType find(String scheme, String value) throws ServiceException {
        return (UserIdentifierType)find(scheme, value, VALUES_LIST, UserIdentifierType.class);
    }
}
