package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestIdentifierType extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(RequestIdentifierType.class);
    private static final List<RequestIdentifierType> VALUES_LIST = new CopyOnWriteArrayList();

    public RequestIdentifierType(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public static RequestIdentifierType find(String scheme, String value) throws ServiceException {
        return (RequestIdentifierType)find(scheme, value, VALUES_LIST, RequestIdentifierType.class);
    }
}
