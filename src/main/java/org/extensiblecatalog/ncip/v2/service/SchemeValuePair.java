package org.extensiblecatalog.ncip.v2.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SchemeValuePair {
    private static final Logger logger = LoggerFactory.getLogger(SchemeValuePair.class);
    protected static final Map<String, Boolean> CLASSES_ALLOWING_NULL_SCHEME = new HashMap();
    protected static final Map<String, SchemeValueBehavior> BEHAVIOR_BY_CLASS_NAME_MAP = new HashMap();
    protected static final Map<String, String> SCHEME_URI_ALIAS_MAP = new HashMap();
    protected String scheme;
    protected String value;

    public static void allowNullScheme(String... classNames) {
        String[] var1 = classNames;
        int var2 = classNames.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            String className = var1[var3];
            CLASSES_ALLOWING_NULL_SCHEME.put(className, Boolean.TRUE);
        }

    }

    public static void mapBehavior(String className, SchemeValueBehavior behavior) {
        BEHAVIOR_BY_CLASS_NAME_MAP.put(className, behavior);
    }

    public static void setSchemeURIAlias(String canonicalURI, String aliasURI) {
        SCHEME_URI_ALIAS_MAP.put(aliasURI, canonicalURI);
    }

    protected static String canonicalizeSchemeURI(String scheme) {
        if (scheme != null) {
            String newScheme = (String)SCHEME_URI_ALIAS_MAP.get(scheme);
            if (newScheme != null) {
                scheme = newScheme;
            }
        }

        return scheme;
    }

    public SchemeValuePair(String scheme, String value) {
        this.scheme = scheme;
        this.value = value;
    }

    public SchemeValuePair(String value) {
        this.value = value;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getValue() {
        return this.value;
    }

    protected static <SVP extends SchemeValuePair> SchemeValuePair find(String scheme, String value, List<SVP> values, Class<SVP> svpClass) throws ServiceException {
        SchemeValuePair match = searchList(scheme, value, values);
        if (match == null) {
            SchemeValueBehavior behavior = (SchemeValueBehavior)BEHAVIOR_BY_CLASS_NAME_MAP.get(svpClass.getName());
            if (behavior == null) {
                behavior = SchemeValueBehavior.UNSET;
            }

            match = behavior.applyBehavior(scheme, value, values, svpClass);
        }

        return match;
    }

    static <SVP extends SchemeValuePair> SVP searchList(String scheme, String value, List<SVP> values) {
        SVP match = null;
        if (value != null && value.length() > 0) {
            Iterator var4 = values.iterator();

            while(var4.hasNext()) {
                SVP svp = (SVP)var4.next();
                if (svp.matches(scheme, value)) {
                    match = svp;
                    break;
                }
            }
        }

        return match;
    }

    static <SVP extends SchemeValuePair> SVP addIfAbsent(String scheme, String value, List<SVP> values, Class<SVP> svpClass) throws ServiceException {
        synchronized(values) {
            SVP match = searchList(scheme, value, values);
            if (match == null) {
                logger.info("Adding SchemeValuePair(" + scheme + ", " + value + ") to " + svpClass.getName());
                Class[] parmTypes = new Class[]{String.class, String.class};

                try {
                    Constructor<SVP> ctor = svpClass.getConstructor(parmTypes);
                    Object[] parmInstances = new Object[]{scheme, value};
                    match = (SVP)ctor.newInstance(parmInstances);
                } catch (NoSuchMethodException var10) {
                    throw new ServiceException(ServiceError.RUNTIME_ERROR, var10);
                } catch (InvocationTargetException var11) {
                    throw new ServiceException(ServiceError.RUNTIME_ERROR, var11);
                } catch (InstantiationException var12) {
                    throw new ServiceException(ServiceError.RUNTIME_ERROR, var12);
                } catch (IllegalAccessException var13) {
                    throw new ServiceException(ServiceError.RUNTIME_ERROR, var13);
                }

                values.add(match);
            } else {
                logger.debug("Skipping adding (" + match.getScheme() + ", " + match.getValue() + ") because it's already been added.");
            }

            return match;
        }
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SchemeValuePair)) {
            return false;
        } else if (!this.isComparableSVPSubclass(o)) {
            return false;
        } else {
            SchemeValuePair svpO = (SchemeValuePair)o;
            return this.matches(svpO.getScheme(), svpO.getValue());
        }
    }

    protected Class getImmediateSVPSubclass(Class svpClass) {
        Class immediateSubclass;
        for(immediateSubclass = svpClass; !immediateSubclass.getSuperclass().equals(SchemeValuePair.class); immediateSubclass = immediateSubclass.getSuperclass()) {
        }

        return immediateSubclass;
    }

    public boolean isComparableSVPSubclass(Object o) {
        if (!o.getClass().equals(this.getClass())) {
            Class oImmediateSubClass = this.getImmediateSVPSubclass(o.getClass());
            Class thisImmediateSubClass = this.getImmediateSVPSubclass(this.getClass());
            if (!oImmediateSubClass.equals(thisImmediateSubClass)) {
                return false;
            }
        }

        return true;
    }

    public boolean matches(SchemeValuePair svp) {
        return this.isComparableSVPSubclass(svp) ? this.matches(svp.getScheme(), svp.getValue()) : false;
    }

    public boolean matches(String scheme, String value) {
        boolean thisClassAllowsNullScheme = this.areNullSchemesAllowed();
        if (this.getScheme() != null) {
            String thisSchemeCanonical = canonicalizeSchemeURI(this.getScheme());
            if (scheme != null) {
                String svpOSchemeCanonical = canonicalizeSchemeURI(scheme);
                return thisSchemeCanonical.compareToIgnoreCase(svpOSchemeCanonical) == 0 ? this.compareValue(value) : false;
            } else {
                return thisClassAllowsNullScheme ? this.compareValue(value) : false;
            }
        } else if (scheme != null) {
            return thisClassAllowsNullScheme ? this.compareValue(value) : false;
        } else {
            return this.compareValue(value);
        }
    }

    protected boolean compareValue(String value) {
        if (this.getValue() != null) {
            if (value != null) {
                return this.getValue().compareToIgnoreCase(value) == 0;
            } else {
                return false;
            }
        } else {
            return value == null;
        }
    }

    public boolean areNullSchemesAllowed() {
        if (CLASSES_ALLOWING_NULL_SCHEME.containsKey(this.getClass().getName())) {
            return true;
        } else {
            Class immediateSubclass = this.getImmediateSVPSubclass(this.getClass());
            return CLASSES_ALLOWING_NULL_SCHEME.containsKey(immediateSubclass.getName());
        }
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }

    static {
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/acceptitemprocessingerror.scm", "http://www.niso.org/ncip/v2_0/schemes/processingerrortype/acceptitemprocessingerror.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/agencyaddressroletype/agencyaddressroletype.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/agencyaddressroletype/agencyaddressroletype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/schemes/agencyelementtype/agencyelementtype.scm", "http://www.niso.org/ncip/v2_0/schemes/agencyelementtype/agencyelementtype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/authenticationinputtype/authenticationinputtype.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/authenticationinputtype/authenticationinputtype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/bibliographicitemidentifiercode/bibliographicitemidentifiercode.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/bibliographicitemidentifiercode/bibliographicitemidentifiercode.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/bibliographiclevel/bibliographiclevel.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/bibliographiclevel/bibliographiclevel.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/bibliographicrecordidentifiercode/bibliographicrecordidentifiercode.scm", "http://www.niso.org/ncip/v2_0/schemes/bibliographicrecordidentifiercode/bibliographicrecordidentifiercode.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/bibliographicrecordidentifiercode/bibliographicrecordidentifiercode.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/bibliographicrecordidentifiercode/bibliographicrecordidentifiercode.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/cancelrequestitemprocessingerror.scm", "http://www.niso.org/ncip/v2_0/schemes/processingerrortype/cancelrequestitemprocessingerror.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/checkinitemprocessingerror.scm", "http://www.niso.org/ncip/v2_0/schemes/processingerrortype/checkinitemprocessingerror.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/checkoutitemprocessingerror.scm", "http://www.niso.org/ncip/v2_0/schemes/processingerrortype/checkoutitemprocessingerror.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/circulationstatus/circulationstatus.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/circulationstatus/circulationstatus.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/componentidentifiertype/componentidentifiertype.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/componentidentifiertype/componentidentifiertype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/fiscalactiontype/fiscalactiontype.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/fiscalactiontype/fiscalactiontype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/fiscaltransactiontype/fiscaltransactiontype.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/fiscaltransactiontype/fiscaltransactiontype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/generalprocessingerror.scm", "http://www.niso.org/ncip/v2_0/schemes/processingerrortype/generalprocessingerror.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/itemdescriptionlevel/itemdescriptionlevel.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/itemdescriptionlevel/itemdescriptionlevel.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/schemes/itemelementtype/itemelementtype.scm", "http://www.niso.org/ncip/v2_0/schemes/itemelementtype/itemelementtype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/visibleitemidentifiertype/visibleitemidentifiertype.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/visibleitemidentifiertype/visibleitemidentifiertype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/itemuserestrictiontype/itemuserestrictiontype.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/itemuserestrictiontype/itemuserestrictiontype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/locationtype/locationtype.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/locationtype/locationtype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/lookupitemprocessingerror.scm", "http://www.niso.org/ncip/v2_0/schemes/processingerrortype/lookupitemprocessingerror.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/lookupuserprocessingerror.scm", "http://www.niso.org/ncip/v2_0/schemes/processingerrortype/lookupuserprocessingerror.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/mediumtype/mediumtype.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/mediumtype/mediumtype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/schemes/messagingerrortype/messagingerrortype.scm", "http://www.niso.org/ncip/v2_0/schemes/messagingerrortype/messagingerrortype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/organizationnametype/organizationnametype.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/organizationnametype/organizationnametype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/paymentmethodtype/paymentmethodtype.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/paymentmethodtype/paymentmethodtype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/physicaladdresstype/physicaladdresstype.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/physicaladdresstype/physicaladdresstype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/physicalconditiontype/physicalconditiontype.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/physicalconditiontype/physicalconditiontype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/renewitemprocessingerror.scm", "http://www.niso.org/ncip/v2_0/schemes/processingerrortype/renewitemprocessingerror.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/schemes/requestelementtype/requestelementtype.scm", "http://www.niso.org/ncip/v2_0/schemes/requestelementtype/requestelementtype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/requestitemprocessingerror.scm", "http://www.niso.org/ncip/v2_0/schemes/processingerrortype/requestitemprocessingerror.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/requestscopetype/requestscopetype.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/requestscopetype/requestscopetype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/requeststatustype/requeststatustype.scm", "http://www.niso.org/ncip/v2_0/schemes/requeststatustype/requeststatustype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/requeststatustype/requeststatustype.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/requeststatustype/requeststatustype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/requesttype/requesttype.scm", "http://www.niso.org/ncip/v2_0/schemes/requesttype/requesttype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/requesttype/requesttype.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/requesttype/requesttype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/requestedactiontype/requestedactiontype.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/requestedactiontype/requestedactiontype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/securitymarker/securitymarker.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/securitymarker/securitymarker.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/imp1/schemes/unstructuredaddresstype/unstructuredaddresstype.scm", "http://www.niso.org/ncip/v2_0/imp1/schemes/unstructuredaddresstype/unstructuredaddresstype.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/schemes/processingerrortype/updaterequestitemprocessingerror.scm", "http://www.niso.org/ncip/v2_0/schemes/processingerrortype/updaterequestitemprocessingerror.scm");
        setSchemeURIAlias("http://www.niso.org/ncip/v1_0/schemes/userelementtype/userelementtype.scm", "http://www.niso.org/ncip/v2_0/schemes/userelementtype/userelementtype.scm");
    }
}
