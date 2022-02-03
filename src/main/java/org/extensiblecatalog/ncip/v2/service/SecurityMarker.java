package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecurityMarker extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(SecurityMarker.class);
    private static final List<SecurityMarker> VALUES_LIST = new CopyOnWriteArrayList();

    public SecurityMarker(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public static SecurityMarker find(String scheme, String value) throws ServiceException {
        return (SecurityMarker)find(scheme, value, VALUES_LIST, SecurityMarker.class);
    }
}
