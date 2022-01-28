package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SchemeValueBehavior {
    private static final Logger logger = LoggerFactory.getLogger(SchemeValueBehavior.class);
    public static final SchemeValueBehavior UNSET = new SchemeValueBehavior() {
        <SVP extends SchemeValuePair> SVP applyBehavior(String scheme, String value, List<SVP> values, Class<SVP> svpClass) throws ServiceException {
            throw new ServiceException(ServiceError.INVALID_SCHEME_VALUE, "No match found for scheme '" + scheme + "', value '" + value + "' in " + svpClass.getName() + "; configuration option for defining values for this class is unset.");
        }
    };
    public static final SchemeValueBehavior DEFINED_ONLY = new SchemeValueBehavior() {
        <SVP extends SchemeValuePair> SVP applyBehavior(String scheme, String value, List<SVP> values, Class<SVP> svpClass) throws ServiceException {
            throw new ServiceException(ServiceError.INVALID_SCHEME_VALUE, "No match found for scheme '" + scheme + "', value '" + value + "' in " + svpClass.getName() + "; configuration option for defining values for this class is 'DEFINED_ONLY'.");
        }
    };
    public static final SchemeValueBehavior ALLOW_ANY = new SchemeValueBehavior() {
        <SVP extends SchemeValuePair> SVP applyBehavior(String scheme, String value, List<SVP> values, Class<SVP> svpClass) throws ServiceException {
            return SchemeValuePair.addIfAbsent(scheme, value, values, svpClass);
        }
    };

    public SchemeValueBehavior() {
    }

    abstract <SVP extends SchemeValuePair> SVP applyBehavior(String var1, String var2, List<SVP> var3, Class<SVP> var4) throws ServiceException;
}
