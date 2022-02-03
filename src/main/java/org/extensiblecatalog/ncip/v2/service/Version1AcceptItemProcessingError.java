package org.extensiblecatalog.ncip.v2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Version1AcceptItemProcessingError extends ProblemType {
    private static final Logger logger = LoggerFactory.getLogger(PhysicalAddressType.class);
    public static final String VERSION_1_ACCEPT_ITEM_PROCESSING_ERROR = "http://www.niso.org/ncip/v1_0/schemes/processingerrortype/acceptitemprocessingerror.scm";
    public static final Version1AcceptItemProcessingError CANNOT_ACCEPT_ITEM = new Version1AcceptItemProcessingError("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/acceptitemprocessingerror.scm", "Cannot Accept Item");
    public static final Version1AcceptItemProcessingError CANNOT_GUARANTEE_RESTRICTIONS_ON_USE = new Version1AcceptItemProcessingError("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/acceptitemprocessingerror.scm", "Cannot Guarantee Restrictions On Use");
    public static final Version1AcceptItemProcessingError ELEMENT_RULE_VIOLATED = new Version1AcceptItemProcessingError("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/acceptitemprocessingerror.scm", "Element Rule Violated");
    public static final Version1AcceptItemProcessingError UNKNOWN_ITEM = new Version1AcceptItemProcessingError("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/acceptitemprocessingerror.scm", "Unknown Item");
    public static final Version1AcceptItemProcessingError UNKNOWN_REQUEST = new Version1AcceptItemProcessingError("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/acceptitemprocessingerror.scm", "Unknown Request");
    public static final Version1AcceptItemProcessingError UNKNOWN_USER = new Version1AcceptItemProcessingError("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/acceptitemprocessingerror.scm", "Unknown User");
    public static final Version1AcceptItemProcessingError USER_INELIGIBLE_TO_CHECK_OUT_THIS_ITEM = new Version1AcceptItemProcessingError("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/acceptitemprocessingerror.scm", "User Ineligible To Check Out This Item");

    public static void loadAll() {
        logger.debug("Loading Version1AcceptItemProcessingError.");
    }

    public Version1AcceptItemProcessingError(String scheme, String value) {
        super(scheme, value);
    }
}
