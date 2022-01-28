//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserPrivilegeStatusType extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(UserPrivilegeStatusType.class);
    private static final List<UserPrivilegeStatusType> VALUES_LIST = new CopyOnWriteArrayList();

    public UserPrivilegeStatusType(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public static UserPrivilegeStatusType find(String scheme, String value) throws ServiceException {
        return (UserPrivilegeStatusType)find(scheme, value, VALUES_LIST, UserPrivilegeStatusType.class);
    }
}
