package org.extensiblecatalog.ncip.v2.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AgencyElementType extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(AgencyElementType.class);
    private static final List<AgencyElementType> VALUES_LIST = new CopyOnWriteArrayList();

    public AgencyElementType(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public static AgencyElementType find(String scheme, String value) throws ServiceException {
        return (AgencyElementType)find(scheme, value, VALUES_LIST, AgencyElementType.class);
    }

    public static Iterator<AgencyElementType> iterator() {
        return VALUES_LIST.iterator();
    }
}
