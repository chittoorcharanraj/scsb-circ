package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElectronicAddressType extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(PhysicalAddressType.class);
    private static final List<ElectronicAddressType> VALUES_LIST = new CopyOnWriteArrayList();

    public ElectronicAddressType(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public ElectronicAddressType(String value) {
        super(value);
        VALUES_LIST.add(this);
    }

    public static ElectronicAddressType find(String scheme, String value) throws ServiceException {
        return (ElectronicAddressType)find(scheme, value, VALUES_LIST, ElectronicAddressType.class);
    }
}
