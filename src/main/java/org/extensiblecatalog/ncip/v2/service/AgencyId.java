package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AgencyId extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(AgencyId.class);
    private static final List<AgencyId> VALUES_LIST = new CopyOnWriteArrayList();

    public AgencyId(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public AgencyId(String value) {
        super(value);
        VALUES_LIST.add(this);
    }

    public static AgencyId find(String scheme, String value) throws ServiceException {
        return (AgencyId)find(scheme, value, VALUES_LIST, AgencyId.class);
    }
}
