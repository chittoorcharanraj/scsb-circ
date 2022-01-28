//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserLanguage extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(UserLanguage.class);
    private static final List<UserLanguage> VALUES_LIST = new CopyOnWriteArrayList();

    public UserLanguage(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public static UserLanguage find(String scheme, String value) throws ServiceException {
        return (UserLanguage)find(scheme, value, VALUES_LIST, UserLanguage.class);
    }
}
