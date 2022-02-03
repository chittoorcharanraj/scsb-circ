package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocationType extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(LocationType.class);
    private static final List<LocationType> VALUES_LIST = new CopyOnWriteArrayList();

    public LocationType(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public static LocationType find(String scheme, String value) throws ServiceException {
        return (LocationType)find(scheme, value, VALUES_LIST, LocationType.class);
    }
}
