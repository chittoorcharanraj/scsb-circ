package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Language extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(Language.class);
    private static final List<Language> VALUES_LIST = new CopyOnWriteArrayList();

    public Language(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public static Language find(String scheme, String value) throws ServiceException {
        return (Language)find(scheme, value, VALUES_LIST, Language.class);
    }
}
