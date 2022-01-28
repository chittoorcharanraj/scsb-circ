package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PickupLocation extends SchemeValuePair {
   private static final Logger logger = LoggerFactory.getLogger(PickupLocation.class);
   private static final List<PickupLocation> VALUES_LIST = new CopyOnWriteArrayList();

    public PickupLocation(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public PickupLocation(String value) {
        super(value);
        VALUES_LIST.add(this);
    }

    public static PickupLocation find(String scheme, String value) throws ServiceException {
        return (PickupLocation)find(scheme, value, VALUES_LIST, PickupLocation.class);
    }
}
