//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PhysicalAddressType extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(PhysicalAddressType.class);
    private static final List<PhysicalAddressType> VALUES_LIST = new CopyOnWriteArrayList();

    public PhysicalAddressType(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public static PhysicalAddressType find(String scheme, String value) throws ServiceException {
        return (PhysicalAddressType)find(scheme, value, VALUES_LIST, PhysicalAddressType.class);
    }
}
