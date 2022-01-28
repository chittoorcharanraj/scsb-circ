package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemUseRestrictionType extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(ItemUseRestrictionType.class);
    private static final List<ItemUseRestrictionType> VALUES_LIST = new CopyOnWriteArrayList();

    public ItemUseRestrictionType(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public static ItemUseRestrictionType find(String scheme, String value) throws ServiceException {
        return (ItemUseRestrictionType)find(scheme, value, VALUES_LIST, ItemUseRestrictionType.class);
    }
}
