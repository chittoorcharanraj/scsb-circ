package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemIdentifierType extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(ItemIdentifierType.class);
    private static final List<ItemIdentifierType> VALUES_LIST = new CopyOnWriteArrayList();

    public ItemIdentifierType(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public static ItemIdentifierType find(String scheme, String value) throws ServiceException {
        return (ItemIdentifierType)find(scheme, value, VALUES_LIST, ItemIdentifierType.class);
    }
}
