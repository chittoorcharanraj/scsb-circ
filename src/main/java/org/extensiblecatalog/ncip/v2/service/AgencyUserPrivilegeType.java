package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AgencyUserPrivilegeType extends SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(AgencyUserPrivilegeType.class);
    private static final List<AgencyUserPrivilegeType> VALUES_LIST = new CopyOnWriteArrayList();

    public AgencyUserPrivilegeType(String scheme, String value) {
        super(scheme, value);
        VALUES_LIST.add(this);
    }

    public static AgencyUserPrivilegeType find(String scheme, String value) throws ServiceException {
        return (AgencyUserPrivilegeType)find(scheme, value, VALUES_LIST, AgencyUserPrivilegeType.class);
    }
}
