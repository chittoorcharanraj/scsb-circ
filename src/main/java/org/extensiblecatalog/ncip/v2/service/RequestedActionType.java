package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestedActionType extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(RequestedActionType.class);
    private static final List<RequestedActionType> VALUES_LIST = new CopyOnWriteArrayList();

    public RequestedActionType(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public static RequestedActionType find(String scheme, String value) throws ServiceException {
        return (RequestedActionType)find(scheme, value, VALUES_LIST, RequestedActionType.class);
    }
}
