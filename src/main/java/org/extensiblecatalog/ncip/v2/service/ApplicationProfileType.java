package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationProfileType extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationProfileType.class);
    private static final List<ApplicationProfileType> VALUES_LIST = new CopyOnWriteArrayList();

    public ApplicationProfileType(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public static ApplicationProfileType find(String scheme, String value) throws ServiceException {
        return (ApplicationProfileType)find(scheme, value, VALUES_LIST, ApplicationProfileType.class);
    }
}
