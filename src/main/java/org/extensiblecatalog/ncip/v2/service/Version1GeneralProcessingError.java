package org.extensiblecatalog.ncip.v2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Version1GeneralProcessingError extends ProblemType {
    private static final Logger logger = LoggerFactory.getLogger(Version1GeneralProcessingError.class);
    public static final String VERSION_1_GENERAL_PROCESSING_ERROR = "http://www.niso.org/ncip/v1_0/schemes/processingerrortype/generalprocessingerror.scm";
    public static final Version1GeneralProcessingError AGENCY_AUTHENTICATION_FAILED = new Version1GeneralProcessingError("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/generalprocessingerror.scm", "Agency Authentication Failed");
    public static final Version1GeneralProcessingError INVALID_AMOUNT = new Version1GeneralProcessingError("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/generalprocessingerror.scm", "Invalid Amount");
    public static final Version1GeneralProcessingError INVALID_DATE = new Version1GeneralProcessingError("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/generalprocessingerror.scm", "Invalid Date");
    public static final Version1GeneralProcessingError NEEDED_DATA_MISSING = new Version1GeneralProcessingError("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/generalprocessingerror.scm", "Needed Data Missing");
    public static final Version1GeneralProcessingError SYSTEM_AUTHENTICATION_FAILED = new Version1GeneralProcessingError("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/generalprocessingerror.scm", "System Authentication Failed");
    public static final Version1GeneralProcessingError TEMPORARY_PROCESSING_FAILURE = new Version1GeneralProcessingError("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/generalprocessingerror.scm", "Temporary Processing Failure");
    public static final Version1GeneralProcessingError UNAUTHORIZED_COMBINATION_OF_ELEMENT_VALUES_FOR_AGENCY = new Version1GeneralProcessingError("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/generalprocessingerror.scm", "Unauthorized Combination Of Element Values For Agency");
    public static final Version1GeneralProcessingError UNAUTHORIZED_COMBINATION_OF_ELEMENT_VALUES_FOR_SYSTEM = new Version1GeneralProcessingError("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/generalprocessingerror.scm", "Unauthorized Combination Of Element Values For System");
    public static final Version1GeneralProcessingError UNAUTHORIZED_SERVICE_FOR_AGENCY = new Version1GeneralProcessingError("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/generalprocessingerror.scm", "Unauthorized Service For Agency");
    public static final Version1GeneralProcessingError UNAUTHORIZED_SERVICE_FOR_SYSTEM = new Version1GeneralProcessingError("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/generalprocessingerror.scm", "Unauthorized Service For System");
    public static final Version1GeneralProcessingError UNKNOWN_AGENCY = new Version1GeneralProcessingError("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/generalprocessingerror.scm", "Unknown Agency");
    public static final Version1GeneralProcessingError UNKNOWN_SYSTEM = new Version1GeneralProcessingError("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/generalprocessingerror.scm", "Unknown System");
    public static final Version1GeneralProcessingError UNSUPPORTED_SERVICE = new Version1GeneralProcessingError("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/generalprocessingerror.scm", "Unsupported Service");

    public static void loadAll() {
        logger.debug("Loading Version1GeneralProcessingError.");
    }

    public Version1GeneralProcessingError(String scheme, String value) {
        super(scheme, value);
    }
}
