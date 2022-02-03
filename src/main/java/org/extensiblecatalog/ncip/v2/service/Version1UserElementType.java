package org.extensiblecatalog.ncip.v2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Version1UserElementType extends UserElementType {
    private static final Logger logger = LoggerFactory.getLogger(Version1UserElementType.class);
    public static final String VERSION_1_USER_ELEMENT_TYPE = "http://www.niso.org/ncip/v1_0/schemes/userelementtype/userelementtype.scm";
    public static final Version1UserElementType AUTHENTICATION_INPUT = new Version1UserElementType("http://www.niso.org/ncip/v1_0/schemes/userelementtype/userelementtype.scm", "Authentication Input");
    public static final Version1UserElementType BLOCK_OR_TRAP = new Version1UserElementType("http://www.niso.org/ncip/v1_0/schemes/userelementtype/userelementtype.scm", "Block Or Trap");
    public static final Version1UserElementType DATE_OF_BIRTH = new Version1UserElementType("http://www.niso.org/ncip/v1_0/schemes/userelementtype/userelementtype.scm", "Date Of Birth");
    public static final Version1UserElementType NAME_INFORMATION = new Version1UserElementType("http://www.niso.org/ncip/v1_0/schemes/userelementtype/userelementtype.scm", "Name Information");
    public static final Version1UserElementType USER_ADDRESS_INFORMATION = new Version1UserElementType("http://www.niso.org/ncip/v1_0/schemes/userelementtype/userelementtype.scm", "User Address Information");
    public static final Version1UserElementType USER_LANGUAGE = new Version1UserElementType("http://www.niso.org/ncip/v1_0/schemes/userelementtype/userelementtype.scm", "User Language");
    public static final Version1UserElementType USER_PRIVILEGE = new Version1UserElementType("http://www.niso.org/ncip/v1_0/schemes/userelementtype/userelementtype.scm", "User Privilege");
    public static final Version1UserElementType USER_ID = new Version1UserElementType("http://www.niso.org/ncip/v1_0/schemes/userelementtype/userelementtype.scm", "User Id");
    public static final Version1UserElementType PREVIOUS_USER_ID = new Version1UserElementType("http://www.niso.org/ncip/v1_0/schemes/userelementtype/userelementtype.scm", "Previous User Id");

    public static void loadAll() {
        logger.debug("Loading Version1UserElementType.");
    }

    public Version1UserElementType(String scheme, String value) {
        super(scheme, value);
    }
}
