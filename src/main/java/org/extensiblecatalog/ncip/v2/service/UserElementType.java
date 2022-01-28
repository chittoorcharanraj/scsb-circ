//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserElementType extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(UserElementType.class);
    private static final List<UserElementType> VALUES_LIST = new CopyOnWriteArrayList();

    public UserElementType(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public static UserElementType find(String scheme, String value) throws ServiceException {
        return (UserElementType)find(scheme, value, VALUES_LIST, UserElementType.class);
    }

    public static Iterator<UserElementType> iterator() {
        return VALUES_LIST.iterator();
    }
}
