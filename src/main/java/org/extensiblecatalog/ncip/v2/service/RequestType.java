package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestType extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(RequestType.class);
    private static final List<RequestType> VALUES_LIST = new CopyOnWriteArrayList();

    public RequestType(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public static RequestType find(String scheme, String value) throws ServiceException {
        return (RequestType)find(scheme, value, VALUES_LIST, RequestType.class);
    }
}
