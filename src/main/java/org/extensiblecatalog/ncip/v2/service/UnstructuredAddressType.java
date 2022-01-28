package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnstructuredAddressType extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(UnstructuredAddressType.class);
    private static final List<UnstructuredAddressType> VALUES_LIST = new CopyOnWriteArrayList();

    public UnstructuredAddressType(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public static UnstructuredAddressType find(String scheme, String value) throws ServiceException {
        return (UnstructuredAddressType)find(scheme, value, VALUES_LIST, UnstructuredAddressType.class);
    }
}
