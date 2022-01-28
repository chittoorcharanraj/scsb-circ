package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProblemType extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(ProblemType.class);
    private static final List<ProblemType> VALUES_LIST = new CopyOnWriteArrayList();

    public ProblemType(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public ProblemType(String value) {
        super(value);
        VALUES_LIST.add(this);
    }

    public static ProblemType find(String scheme, String value) throws ServiceException {
        return (ProblemType)find(scheme, value, VALUES_LIST, ProblemType.class);
    }
}
