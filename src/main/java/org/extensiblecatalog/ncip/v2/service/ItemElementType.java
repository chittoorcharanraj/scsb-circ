package org.extensiblecatalog.ncip.v2.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemElementType extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(ItemElementType.class);
    private static final List<ItemElementType> VALUES_LIST = new CopyOnWriteArrayList();

    public ItemElementType(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public static ItemElementType find(String scheme, String value) throws ServiceException {
        return (ItemElementType)find(scheme, value, VALUES_LIST, ItemElementType.class);
    }

    public static Iterator<ItemElementType> iterator() {
        return VALUES_LIST.iterator();
    }
}
