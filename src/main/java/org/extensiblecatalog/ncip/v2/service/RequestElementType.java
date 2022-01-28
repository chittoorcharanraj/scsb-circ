package org.extensiblecatalog.ncip.v2.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestElementType extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(RequestElementType.class);
    private static final List<RequestElementType> VALUES_LIST = new CopyOnWriteArrayList();

    public RequestElementType(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public static RequestElementType find(String scheme, String value) throws ServiceException {
        return (RequestElementType)find(scheme, value, VALUES_LIST, RequestElementType.class);
    }

    public static Iterator<RequestElementType> iterator() {
        return VALUES_LIST.iterator();
    }
}
