package org.extensiblecatalog.ncip.v2.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceHelper {
    private static final String INITIATION_DATA_SUFFIX = "InitiationData";
    private static final int LENGTH_OF_INITIATION_DATA_LITERAL = "InitiationData".length();
    private static final int LENGTH_OF_RESPONSE_DATA_LITERAL = "ResponseData".length();
    private static final int LENGTH_OF_DATA_LITERAL = "Data".length();
    protected static final Map<Class, Method> findMethodsByClass = new HashMap();

    private ServiceHelper() {
    }

    public static List<Problem> createUnsupportedServiceProblems(NCIPData ncipData) {
        return generateProblems(Version1GeneralProcessingError.UNSUPPORTED_SERVICE, getServiceName(ncipData), (String)null, (String)null);
    }

    public static List<Problem> generateProblems(ProblemType type, String elementXPath, String value, String details) {
        List<Problem> problems = new ArrayList();
        Problem problem = new Problem();
        problem.setProblemType(type);
        if (elementXPath != null) {
            problem.setProblemElement(elementXPath);
        }

        if (details != null) {
            problem.setProblemDetail(details);
        }

        if (value != null) {
            problem.setProblemValue(value);
        }

        problems.add(problem);
        return problems;
    }

    public static List<Problem> generateProblems(ProblemType type, String elementXPath, String value, String details, Throwable exception) {
        List<Problem> problems = generateProblems(type, elementXPath, value, details + System.getProperties().get("line.separator") + convertExceptionToString(exception));
        return problems;
    }

    public static String convertExceptionToString(Throwable e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.getBuffer().toString();
    }

    public static String getServiceName(NCIPData ncipData) {
        String serviceName;
        if (ncipData != null) {
            int lengthOfSuffix = ncipData instanceof NCIPInitiationData ? LENGTH_OF_INITIATION_DATA_LITERAL : LENGTH_OF_RESPONSE_DATA_LITERAL;
            String dataClassName = ncipData.getClass().getSimpleName();
            serviceName = dataClassName.substring(0, dataClassName.length() - lengthOfSuffix);
        } else {
            serviceName = "null";
        }

        return serviceName;
    }

    public static Class constructInitiationDataClass(String serviceName) throws ClassNotFoundException {
        String initDataClassName = NCIPService.class.getPackage().getName() + "." + serviceName + "InitiationData";
        return Class.forName(initDataClassName);
    }

    public static String getElementName(Class<?> svcClass) {
        String msgClassSimpleName = svcClass.getSimpleName();
        if (msgClassSimpleName.matches(".*InitiationData$")) {
            return msgClassSimpleName.substring(0, msgClassSimpleName.length() - LENGTH_OF_INITIATION_DATA_LITERAL);
        } else {
            return msgClassSimpleName.matches(".*ResponseData$") ? msgClassSimpleName.substring(0, msgClassSimpleName.length() - LENGTH_OF_DATA_LITERAL) : msgClassSimpleName;
        }
    }

    public static String getMessageName(NCIPData ncipData) {
        int lengthOfSuffix = ncipData instanceof NCIPInitiationData ? LENGTH_OF_INITIATION_DATA_LITERAL : LENGTH_OF_DATA_LITERAL;
        String dataClassName = ncipData.getClass().getSimpleName();
        return dataClassName.substring(0, dataClassName.length() - lengthOfSuffix);
    }

    public static String formatSVP(SchemeValuePair svp) {
        return svp == null ? "" : (svp.getScheme() == null ? "" : svp.getScheme() + ", ") + svp.getValue();
    }

    public static AgencyId createAgencyId(String agencyIdString) {
        int lastSlashOffset = agencyIdString.lastIndexOf(47);
        AgencyId agencyId;
        if (lastSlashOffset >= 0) {
            agencyId = new AgencyId(agencyIdString.substring(0, lastSlashOffset), agencyIdString.substring(lastSlashOffset + 1));
        } else {
            agencyId = new AgencyId(agencyIdString);
        }

        return agencyId;
    }

    public static List<Problem> getProblems(NCIPResponseData responseData) throws InvocationTargetException, IllegalAccessException {
        List<Problem> problems = null;
        Method getProblemsMethod = ReflectionHelper.findMethod(responseData.getClass(), "getProblems", new Class[0]);
        if (getProblemsMethod != null) {
            problems = (List)getProblemsMethod.invoke(responseData);
        }

        return problems;
    }

    public static <SVCSVP extends SchemeValuePair> SVCSVP findSchemeValuePair(Class<? extends SchemeValuePair> svcSVPClass, String scheme, String value) throws ToolkitException {
        try {
            Method findMethod = getFindMethod(svcSVPClass);
            SVCSVP result = (SVCSVP)findMethod.invoke((Object)null, scheme, value);
            return result;
        } catch (IllegalAccessException var5) {
            throw new ToolkitException(var5);
        } catch (InvocationTargetException var6) {
            throw new ToolkitException(var6);
        }
    }

    public static Method getFindMethod(Class<? extends SchemeValuePair> SVPClass) throws ToolkitException {
        Method findMethod = (Method)findMethodsByClass.get(SVPClass);
        if (findMethod == null) {
            try {
                findMethod = SVPClass.getMethod("find", String.class, String.class);
                findMethodsByClass.put(SVPClass, findMethod);
            } catch (NoSuchMethodException var3) {
                throw new ToolkitException("Exception finding SchemeValuePair.find method:", var3);
            }
        }

        return findMethod;
    }
}
