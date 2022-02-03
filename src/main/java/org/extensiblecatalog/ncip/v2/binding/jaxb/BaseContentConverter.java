package org.extensiblecatalog.ncip.v2.binding.jaxb;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;
import org.dozer.MappingException;
import org.extensiblecatalog.ncip.v2.service.*;
import org.extensiblecatalog.ncip.v2.service.NCIPMessage.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;

public abstract class BaseContentConverter<JAXBSVPCLASS, EXTCLASS> extends DozerConverter<Object, Object> implements MapperAware {
    private static final Logger logger = LoggerFactory.getLogger(BaseContentConverter.class);
    protected final Class<JAXBSVPCLASS> jaxbSVPClass;
    protected final Class<EXTCLASS> jaxbExtensionClass;
    protected final String jaxbPackageNameWithPeriod;
    protected final String svcPackageNameWithPeriod;
    protected final Map<String, Method> objectFactoryMethodsByName = new HashMap();
    protected final Map<String, Constructor> defaultCtorsByClassName = new HashMap();
    protected Map<String, JAXBSVPCLASS> svpAgencyElementTypeFields;
    protected Map<String, JAXBSVPCLASS> svpItemElementTypeFields;
    protected Map<String, JAXBSVPCLASS> svpRequestElementTypeFields;
    protected Map<String, JAXBSVPCLASS> svpUserElementTypeFields;
    protected static final Map<String, List<String>> elementOrderByParentElementName = new HashMap();
    protected static final Map<String, List<String>> extensionElementsByParentObjectName = new HashMap();
    protected static final List<String> cancelRequestItemElementOrder = new ArrayList();
    protected static final List<String> cancelRequestItemResponseElementOrder;
    protected static final List<String> chronologyLevelInstanceElementOrder;
    protected static final List<String> destinationElementOrder;
    protected static final List<String> enumerationLevelInstanceElementOrder;
    protected static final List<String> itemRequestCancelledElementOrder;
    protected static final List<String> itemShippedElementOrder;
    protected static final List<String> lookupItemResponseElementOrder;
    protected static final List<String> lookupRequestResponseElementOrder;
    protected static final List<String> personalNameInformationElementOrder;
    protected static final List<String> requestedItemElementOrder;
    protected static final List<String> requestedItemExtensions;
    protected static final List<String> requestItemElementOrder;
    protected static final List<String> requestItemExtensions;
    protected static final List<String> requestItemResponseElementOrder;
    protected static final List<String> requestItemResponseExtensions;
    protected static final List<String> structuredAddressElementOrder;
    protected static final List<String> structuredHoldingsDataElementOrder;
    protected Mapper mapper;

    protected Map<String, JAXBSVPCLASS> createMap(Iterator<? extends SchemeValuePair> iterator) {
        HashMap map;
        String fieldName;
        Object jaxbSVP;
        for(map = new HashMap(); iterator.hasNext(); map.put(fieldName, jaxbSVP)) {
            SchemeValuePair svcSVP = (SchemeValuePair)iterator.next();
            String scheme = svcSVP.getScheme();
            String value = svcSVP.getValue();
            fieldName = convertToFieldName(value);

            try {
                jaxbSVP = JAXBHelper.createJAXBSchemeValuePair(this.jaxbSVPClass, scheme, value);
            } catch (IllegalAccessException var9) {
                throw new MappingException(var9);
            } catch (InstantiationException var10) {
                throw new MappingException(var10);
            }
        }

        return map;
    }

    public BaseContentConverter(Class<JAXBSVPCLASS> jaxbSVPClass, Class<EXTCLASS> jaxbExtensionClass) {
        super(Object.class, Object.class);
        this.jaxbSVPClass = jaxbSVPClass;
        this.jaxbExtensionClass = jaxbExtensionClass;
        this.jaxbPackageNameWithPeriod = jaxbSVPClass.getPackage().getName() + ".";
        this.svcPackageNameWithPeriod = SchemeValuePair.class.getPackage().getName() + ".";
        this.svpAgencyElementTypeFields = this.createMap(AgencyElementType.iterator());
        this.svpItemElementTypeFields = this.createMap(ItemElementType.iterator());
        this.svpRequestElementTypeFields = this.createMap(RequestElementType.iterator());
        this.svpUserElementTypeFields = this.createMap(UserElementType.iterator());
    }

    protected static String convertToFieldName(String value) {
        return value.replaceAll(" ", "");
    }

    protected Object mapToSVCObject(Object jaxbFieldObj) {
        Object svcFieldObj = null;
        String elementName = this.getElementName(jaxbFieldObj);
        String svcClassName = this.svcPackageNameWithPeriod + elementName;

        try {
            Class<?> svcFieldClass = Class.forName(svcClassName);
            svcFieldObj = this.mapper.map(jaxbFieldObj, svcFieldClass);
        } catch (ClassNotFoundException var6) {
            logger.warn("Primitive type " + jaxbFieldObj.getClass().getName() + " not mapped.");
        }

        return svcFieldObj;
    }

    protected Object mapToJAXBObject(Object svcFieldObj, String createMethodName, Object svcObj) {
        Object jaxbFieldObj = null;
        Class svcClass = svcFieldObj.getClass();
        if (!MessageType.class.isAssignableFrom(svcClass)) {
            if (BigDecimal.class.isAssignableFrom(svcClass)) {
                jaxbFieldObj = this.callObjectFactory(createMethodName, svcObj);
            } else if (String.class.isAssignableFrom(svcClass)) {
                jaxbFieldObj = this.callObjectFactory(createMethodName, svcObj);
            } else if (GregorianCalendar.class.isAssignableFrom(svcClass)) {
                XMLGregorianCalendar xmlGregorianCalendar;
                try {
                    xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar)svcObj);
                } catch (DatatypeConfigurationException var12) {
                    throw new MappingException("Could not convert this date: " + svcObj.toString(), var12);
                }

                jaxbFieldObj = this.callObjectFactory(createMethodName, xmlGregorianCalendar);
            } else if (SchemeValuePair.class.isAssignableFrom(svcClass)) {
                SchemeValuePair svcSVP = (SchemeValuePair)svcObj;

                Object jaxbSVP;
                try {
                    jaxbSVP = JAXBHelper.createJAXBSchemeValuePair(this.jaxbSVPClass, svcSVP.getScheme(), svcSVP.getValue());
                } catch (IllegalAccessException var10) {
                    throw new MappingException(var10);
                } catch (InstantiationException var11) {
                    throw new MappingException(var11);
                }

                jaxbFieldObj = this.callObjectFactory(createMethodName, jaxbSVP);
            } else {
                String elementName = svcClass.getSimpleName();
                String jaxbClassName = this.jaxbPackageNameWithPeriod + elementName;

                try {
                    Class<?> jaxbClass = Class.forName(jaxbClassName);
                    jaxbFieldObj = this.mapper.map(svcFieldObj, jaxbClass);
                } catch (ClassNotFoundException var9) {
                    throw new MappingException("Exception creating JAXB object.", var9);
                }
            }
        }

        return jaxbFieldObj;
    }

    protected Object callObjectFactory(String createMethodName, Object srcObj) {
        Method objFactoryMethod = this.getObjectFactoryMethod(createMethodName, srcObj.getClass());

        try {
            Object jaxbObject = objFactoryMethod.invoke(this.getObjectFactory(), srcObj);
            return jaxbObject;
        } catch (IllegalAccessException var6) {
            throw new MappingException("Exception creating JAXB object.", var6);
        } catch (InvocationTargetException var7) {
            throw new MappingException("Exception creating JAXB object.", var7);
        }
    }

    protected String makeCreateMethodName(String getMethodName) {
        String createMethodName = getMethodName;
        if (getMethodName.endsWith("s")) {
            createMethodName = getMethodName.substring(0, getMethodName.length() - 2);
        }

        if (createMethodName.startsWith("get")) {
            createMethodName = createMethodName.substring(3);
        }

        if (!createMethodName.startsWith("create")) {
            createMethodName = "create" + createMethodName;
        }

        return createMethodName;
    }

    protected Method getObjectFactoryMethod(String methodName, Class srcObjClass) {
        Method method = (Method)this.objectFactoryMethodsByName.get(methodName);
        if (method == null) {
            method = ReflectionHelper.findMethod(this.getObjectFactory().getClass(), methodName, new Class[]{srcObjClass});
            this.objectFactoryMethodsByName.put(methodName, method);
        }

        return method;
    }

    public Object convertTo(Object srcObj, Object destObj) {
        return this.determineObjectTypeAndConvert(srcObj, destObj);
    }

    public Object convertFrom(Object srcObj, Object destObj) {
        return this.determineObjectTypeAndConvert(srcObj, destObj);
    }

    protected Object determineObjectTypeAndConvert(Object srcObj, Object destObj) {
        if (srcObj != null) {
            if (srcObj.getClass().getPackage().getName().compareTo(SchemeValuePair.class.getPackage().getName()) == 0) {
                destObj = this.convertToJAXBFromSVC(srcObj, destObj);
            } else {
                if (!srcObj.getClass().getPackage().getName().contains(".jaxb.")) {
                    throw new MappingException("The source object does not appear to be a member of Service package or of a JAXB bindings package.");
                }

                destObj = this.convertFromJAXBToSVC(srcObj, destObj);
            }
        } else {
            destObj = null;
        }

        return destObj;
    }

    public Object convertFromJAXBToSVC(Object srcJAXBObj, Object destSVCObj) {
        Object result = null;
        if (srcJAXBObj != null) {
            Class jaxbClass = srcJAXBObj.getClass();
            Class svcClass = this.getSVCClassForElement(jaxbClass.getSimpleName());

            try {
                Constructor svcCtor = svcClass.getConstructor();
                Object svcObj = svcCtor.newInstance();
                Method getContentMethod = jaxbClass.getMethod("getContent");
                List<Object> contentList = (List)getContentMethod.invoke(srcJAXBObj);
                Iterator var10 = contentList.iterator();

                while(var10.hasNext()) {
                    Object jaxbFieldObj = var10.next();
                    this.mapAndSetSVCFieldFromJAXBFieldObject(jaxbFieldObj, svcObj);
                }

                result = svcObj;
            } catch (NoSuchMethodException var12) {
                throw new MappingException("Exception creating service object.", var12);
            } catch (InvocationTargetException var13) {
                throw new MappingException("Exception creating service object.", var13);
            } catch (IllegalAccessException var14) {
                throw new MappingException("Exception creating service object.", var14);
            } catch (InstantiationException var15) {
                throw new MappingException("Exception creating service object.", var15);
            }
        }

        return result;
    }

    void mapAndSetSVCFieldFromJAXBFieldObject(Object jaxbFieldObj, Object svcObj) {
        String elementName = this.getElementName(jaxbFieldObj);
        Field field = ReflectionHelper.findField(svcObj.getClass(), elementName);
        if (field != null) {
            Class<?> svcFieldClass = field.getType();
            if (List.class.isAssignableFrom(svcFieldClass)) {
                this.mapAndSetSVCListFieldFromJAXBObject(jaxbFieldObj, svcObj, elementName);
            } else {
                this.mapAndSetSVCObjectFieldFromJAXBObject(jaxbFieldObj, svcFieldClass, svcObj, elementName);
            }
        } else if (elementName.compareTo("Ext") == 0) {
            this.mapSVCFieldFromExtension(jaxbFieldObj, svcObj, field);
        } else {
            logger.debug("content list contained an element (" + elementName + ") for which no similarly-named field was found on the service object (" + svcObj.getClass().getName() + "); skipping that field.");
        }

    }

    String getExtensionName(Object jaxbObj) {
        String extensionName;
        if (jaxbObj instanceof JAXBElement) {
            JAXBElement jaxbElement = (JAXBElement)jaxbObj;
            extensionName = jaxbElement.getName().getLocalPart();
        } else if (jaxbObj instanceof Node) {
            extensionName = ((Node)jaxbObj).getLocalName();
        } else {
            extensionName = jaxbObj.getClass().getSimpleName();
        }

        return extensionName;
    }

    void mapSVCFieldFromExtension(Object jaxbFieldObj, Object svcObj, Field field) {
        Iterator var5 = JAXBHelper.getAnyList(jaxbFieldObj).iterator();

        while(var5.hasNext()) {
            Object innerJAXBObj = var5.next();
            String extensionName = this.getExtensionName(innerJAXBObj);
            field = ReflectionHelper.findField(svcObj.getClass(), extensionName);
            if (field != null) {
                Class<?> svcFieldClass = field.getType();
                Object svcFieldObj = this.mapper.map(innerJAXBObj, svcFieldClass);
                Method setMethod = ReflectionHelper.findMethod(svcObj.getClass(), "set" + extensionName, new Class[]{svcFieldClass});

                try {
                    setMethod.invoke(svcObj, svcFieldObj);
                } catch (IllegalAccessException var12) {
                    throw new MappingException("Exception invoking set method on service object.", var12);
                } catch (InvocationTargetException var13) {
                    throw new MappingException("Exception invoking set method on service object.", var13);
                }
            } else {
                logger.debug("content list contained an extension element (" + extensionName + ") for which no similarly-named field was found on the service object (" + svcObj.getClass().getName() + "); skipping that field.");
            }
        }

    }

    void mapAndSetSVCListFieldFromJAXBObject(Object jaxbFieldObj, Object svcObj, String fieldName) {
        Object svcFieldObj = this.mapToSVCObject(jaxbFieldObj);
        Method getMethod = ReflectionHelper.findMethod(svcObj.getClass(), "get" + fieldName + "s", new Class[0]);

        try {
            List<Object> svcList = (List)getMethod.invoke(svcObj);
            if (svcList == null) {
                svcList = new ArrayList();
                Method setMethod = ReflectionHelper.findMethod(svcObj.getClass(), "set" + fieldName + "s", new Class[]{List.class});

                try {
                    setMethod.invoke(svcObj, svcList);
                } catch (IllegalAccessException var9) {
                    throw new MappingException("Exception invoking set method on service object.", var9);
                } catch (InvocationTargetException var10) {
                    throw new MappingException("Exception invoking set method on service object.", var10);
                }
            }

            ((List)svcList).add(svcFieldObj);
        } catch (IllegalAccessException var11) {
            throw new MappingException("Exception invoking get method on service object.", var11);
        } catch (InvocationTargetException var12) {
            throw new MappingException("Exception invoking get method on service object.", var12);
        }
    }

    void mapAndSetSVCObjectFieldFromJAXBObject(Object jaxbFieldObj, Class<?> svcFieldClass, Object svcObj, String fieldName) {
        Object svcFieldObj = this.mapper.map(jaxbFieldObj, svcFieldClass);
        Method setMethod = ReflectionHelper.findMethod(svcObj.getClass(), "set" + fieldName, new Class[]{svcFieldClass});

        try {
            setMethod.invoke(svcObj, svcFieldObj);
        } catch (IllegalAccessException var8) {
            throw new MappingException("Exception invoking set method on service object.", var8);
        } catch (InvocationTargetException var9) {
            throw new MappingException("Exception invoking set method on service object.", var9);
        }
    }

    String getElementName(Object jaxbFieldObj) {
        String elementName;
        if (jaxbFieldObj instanceof JAXBElement) {
            JAXBElement jaxbElement = (JAXBElement)jaxbFieldObj;
            elementName = jaxbElement.getName().getLocalPart();
        } else {
            elementName = jaxbFieldObj.getClass().getSimpleName();
        }

        return elementName;
    }

    public Object convertToJAXBFromSVC(Object srcSVCObj, Object destJAXBObj) {
        Object result = null;
        if (srcSVCObj != null) {
            Class svcClass = srcSVCObj.getClass();
            String elementName = ServiceHelper.getElementName(svcClass);
            Class jaxbClass = this.getJAXBClassForElement(elementName);

            try {
                Object jaxbObj = jaxbClass.getConstructor().newInstance();
                Method getContentMethod = jaxbObj.getClass().getMethod("getContent");
                List<Object> workingJAXBContentList = new ArrayList();
                List<Object> jaxbExtensionList = new ArrayList();
                Method[] svcMethods = srcSVCObj.getClass().getMethods();
                Method[] var12 = svcMethods;
                int var13 = svcMethods.length;

                for(int var14 = 0; var14 < var13; ++var14) {
                    Method svcGetMethod = var12[var14];
                    this.mapJAXBFieldFromSVCObject(svcGetMethod, srcSVCObj, workingJAXBContentList, jaxbExtensionList, elementName);
                }

                List<Object> jaxbContentList = (List)getContentMethod.invoke(jaxbObj);
                jaxbContentList.clear();
                if (!workingJAXBContentList.isEmpty()) {
                    this.sortContentList(jaxbContentList, workingJAXBContentList, elementName);
                }

                if (!jaxbExtensionList.isEmpty()) {
                    this.sortExtensionList(jaxbExtensionList, jaxbContentList, elementName);
                }

                result = jaxbObj;
            } catch (InstantiationException var16) {
                throw new MappingException("Exception creating JAXB object.", var16);
            } catch (IllegalAccessException var17) {
                throw new MappingException("Exception creating JAXB object.", var17);
            } catch (InvocationTargetException var18) {
                throw new MappingException("Exception creating JAXB object.", var18);
            } catch (NoSuchMethodException var19) {
                throw new MappingException("Exception creating JAXB object.", var19);
            }
        }

        return result;
    }

    void sortExtensionList(List<Object> jaxbExtensionList, List<Object> jaxbContentList, String elementName) {
        ContentMappingComparator comparator = new ContentMappingComparator((List)extensionElementsByParentObjectName.get(elementName));
        Collections.sort(jaxbExtensionList, comparator);
        EXTCLASS ext = this.createExtension();
        JAXBHelper.addAllToExtension(ext, jaxbExtensionList);
        jaxbContentList.add(ext);
    }

    void sortContentList(List<Object> jaxbContentList, List<Object> workingJAXBContentList, String elementName) {
        ContentMappingComparator comparator = new ContentMappingComparator((List)elementOrderByParentElementName.get(elementName));
        Collections.sort(workingJAXBContentList, comparator);
        jaxbContentList.addAll(workingJAXBContentList);
    }

    void mapJAXBFieldFromSVCObject(Method svcGetMethod, Object srcSVCObj, List<Object> workingJAXBContentList, List<Object> jaxbExtensionList, String elementName) {
        if (svcGetMethod.getName().startsWith("get")) {
            logger.debug("Method " + svcGetMethod.getName() + " is a getter.");
            if (svcGetMethod.getParameterTypes().length == 0) {
                Object svcFieldObj;
                try {
                    svcFieldObj = svcGetMethod.invoke(srcSVCObj);
                } catch (IllegalAccessException var8) {
                    throw new MappingException("Exception invoking get method on service object.", var8);
                } catch (InvocationTargetException var9) {
                    throw new MappingException("Exception invoking get method on service object.", var9);
                }

                if (svcFieldObj != null) {
                    Class svcFieldClass = svcGetMethod.getReturnType();
                    this.mapJAXBFieldFromSVCField(srcSVCObj, svcGetMethod, svcFieldClass, svcFieldObj, workingJAXBContentList, jaxbExtensionList, elementName);
                }
            } else {
                logger.debug("Method " + svcGetMethod.getName() + " has parameters; skipping.");
            }
        }

    }

    void mapJAXBFieldFromSVCField(Object srcSVCObj, Method svcGetMethod, Class<?> svcFieldClass, Object svcFieldObj, List<Object> workingJAXBContentList, List<Object> jaxbExtensionList, String elementName) {
        if (SchemeValuePair.class.getName().compareTo(svcFieldClass.getName()) == 0) {
            throw new MappingException("BaseContentConverter found field named '" + svcGetMethod.getName().substring("get".length()) + "' of type SchemeValuePair in " + srcSVCObj.getClass() + "; this field should have a more narrow type.");
        } else {
            if (svcFieldClass.getName().compareToIgnoreCase(Class.class.getName()) == 0) {
                logger.debug("Skipping " + svcGetMethod.getName() + " - this is not actually a data field.");
            } else if (List.class.isAssignableFrom(svcFieldClass)) {
                this.mapList(svcGetMethod, (List)svcFieldObj, workingJAXBContentList);
            } else if (!Boolean.TYPE.isInstance(svcFieldObj) && !Boolean.class.isInstance(svcFieldObj)) {
                this.mapExtension(svcGetMethod, svcFieldObj, jaxbExtensionList, workingJAXBContentList, elementName);
            } else {
                Boolean svcFieldBoolean = (Boolean)svcFieldObj;
                this.mapBoolean(svcGetMethod, svcFieldBoolean);
            }

        }
    }

    void mapList(Method svcGetMethod, List svcFieldObjList, List<Object> workingJAXBContentList) {
        Iterator var4 = svcFieldObjList.iterator();

        while(var4.hasNext()) {
            Object innerSVCFieldObj = var4.next();
            String createMethodName = this.makeCreateMethodName(svcGetMethod.getName());
            Object jaxbFieldObj = this.mapToJAXBObject(innerSVCFieldObj, createMethodName, innerSVCFieldObj);
            if (jaxbFieldObj != null) {
                workingJAXBContentList.add(jaxbFieldObj);
            }
        }

    }

    void mapBoolean(Method svcGetMethod, Boolean svcFieldValue) {
        List<JAXBSVPCLASS> agencyElementTypeList = new ArrayList();
        List<JAXBSVPCLASS> itemElementTypeList = new ArrayList();
        List<JAXBSVPCLASS> requestElementTypeList = new ArrayList();
        List<JAXBSVPCLASS> userElementTypeList = new ArrayList();
        String fieldName = svcGetMethod.getName().substring(3);
        if (svcFieldValue) {
            if (this.getAgencyElementType(fieldName) != null) {
                agencyElementTypeList.add(this.getAgencyElementType(fieldName));
            } else if (this.getItemElementType(fieldName) != null) {
                itemElementTypeList.add(this.getItemElementType(fieldName));
            } else if (this.getRequestElementType(fieldName) != null) {
                requestElementTypeList.add(this.getRequestElementType(fieldName));
            } else {
                if (this.getUserElementType(fieldName) == null) {
                    throw new MappingException("Boolean field " + fieldName + " not recognized.");
                }

                userElementTypeList.add(this.getUserElementType(fieldName));
            }
        }

    }

    void mapExtension(Method svcGetMethod, Object svcFieldObj, List<Object> jaxbExtensionList, List<Object> workingJAXBContentList, String elementName) {
        String createMethodName = this.makeCreateMethodName(svcGetMethod.getName());
        Object jaxbFieldObj = this.mapToJAXBObject(svcFieldObj, createMethodName, svcFieldObj);
        if (jaxbFieldObj != null) {
            List<String> extensionElementsList = (List)extensionElementsByParentObjectName.get(elementName);
            String fieldName = svcGetMethod.getName().substring(3);
            if (extensionElementsList != null && !extensionElementsList.isEmpty() && extensionElementsList.contains(fieldName)) {
                jaxbExtensionList.add(jaxbFieldObj);
            } else {
                workingJAXBContentList.add(jaxbFieldObj);
            }
        } else {
            logger.debug("Got null jaxbFieldObj back from mapping of " + svcFieldObj);
        }

    }

    Class<?> getSVCClassForElement(String elementName) {
        try {
            Class<?> svcClass = (Class)this.getElementNamesToServiceClassMap().get(elementName);
            if (svcClass == null) {
                String className = this.svcPackageNameWithPeriod + elementName;
                svcClass = Class.forName(className);
            }

            return svcClass;
        } catch (ClassNotFoundException var4) {
            throw new MappingException("Could not find service-package class for element name '" + elementName + "'.");
        }
    }

    Class<?> getJAXBClassForElement(String elementName) {
        try {
            Class<?> jaxbClass = (Class)this.getElementNamesToJAXBClassMap().get(elementName);
            if (jaxbClass == null) {
                String className = this.jaxbPackageNameWithPeriod + elementName;
                jaxbClass = Class.forName(className);
            }

            return jaxbClass;
        } catch (ClassNotFoundException var4) {
            throw new MappingException("Could not find JAXB package class for element name '" + elementName + "'.");
        }
    }

    public JAXBSVPCLASS getAgencyElementType(String fieldName) {
        return this.svpAgencyElementTypeFields.get(fieldName);
    }

    public JAXBSVPCLASS getItemElementType(String fieldName) {
        return this.svpItemElementTypeFields.get(fieldName);
    }

    public JAXBSVPCLASS getRequestElementType(String fieldName) {
        return this.svpRequestElementTypeFields.get(fieldName);
    }

    public JAXBSVPCLASS getUserElementType(String fieldName) {
        return this.svpUserElementTypeFields.get(fieldName);
    }

    protected abstract EXTCLASS createExtension();

    protected abstract Object getObjectFactory();

    protected abstract Map<String, Class<?>> getElementNamesToServiceClassMap();

    protected abstract Map<String, Class<?>> getElementNamesToJAXBClassMap();

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    static {
        cancelRequestItemElementOrder.add("InitiationHeader");
        cancelRequestItemElementOrder.add("MandatedAction");
        cancelRequestItemElementOrder.add("UserId");
        cancelRequestItemElementOrder.add("AuthenticationInput");
        cancelRequestItemElementOrder.add("RequestId");
        cancelRequestItemElementOrder.add("ItemId");
        cancelRequestItemElementOrder.add("RequestType");
        cancelRequestItemElementOrder.add("RequestScopeType");
        cancelRequestItemElementOrder.add("AcknowledgedFeeAmount");
        cancelRequestItemElementOrder.add("PaidFeeAmount");
        cancelRequestItemElementOrder.add("ItemElementType");
        cancelRequestItemElementOrder.add("UserElementType");
        cancelRequestItemResponseElementOrder = new ArrayList();
        cancelRequestItemResponseElementOrder.add("ResponseHeader");
        cancelRequestItemResponseElementOrder.add("Problem");
        cancelRequestItemResponseElementOrder.add("RequestId");
        cancelRequestItemResponseElementOrder.add("ItemId");
        cancelRequestItemResponseElementOrder.add("UserId");
        cancelRequestItemResponseElementOrder.add("FiscalTransactionInformation");
        cancelRequestItemResponseElementOrder.add("ItemOptionalFields");
        cancelRequestItemResponseElementOrder.add("UserOptionalFields");
        chronologyLevelInstanceElementOrder = new ArrayList();
        chronologyLevelInstanceElementOrder.add("ChronologyLevel");
        chronologyLevelInstanceElementOrder.add("ChronologyCaption");
        chronologyLevelInstanceElementOrder.add("ChronologyValue");
        destinationElementOrder = new ArrayList();
        destinationElementOrder.add("BinNumber");
        destinationElementOrder.add("Location");
        enumerationLevelInstanceElementOrder = new ArrayList();
        enumerationLevelInstanceElementOrder.add("EnumerationLevel");
        enumerationLevelInstanceElementOrder.add("EnumerationCaption");
        enumerationLevelInstanceElementOrder.add("EnumerationValue");
        itemRequestCancelledElementOrder = new ArrayList();
        itemRequestCancelledElementOrder.add("InitiationHeader");
        itemRequestCancelledElementOrder.add("UserId");
        itemRequestCancelledElementOrder.add("RequestId");
        itemRequestCancelledElementOrder.add("ItemId");
        itemRequestCancelledElementOrder.add("RequestType");
        itemRequestCancelledElementOrder.add("RequestScopeType");
        itemRequestCancelledElementOrder.add("FiscalTransactionInformation");
        itemRequestCancelledElementOrder.add("ItemOptionalFields");
        itemRequestCancelledElementOrder.add("UserOptionalFields");
        itemShippedElementOrder = new ArrayList();
        itemShippedElementOrder.add("InitiationHeader");
        itemShippedElementOrder.add("RequestId");
        itemShippedElementOrder.add("ItemId");
        itemShippedElementOrder.add("UserId");
        itemShippedElementOrder.add("DateShipped");
        itemShippedElementOrder.add("ShippingInformation");
        itemShippedElementOrder.add("ItemOptionalFields");
        itemShippedElementOrder.add("UserOptionalFields");
        lookupItemResponseElementOrder = new ArrayList();
        lookupItemResponseElementOrder.add("ResponseHeader");
        lookupItemResponseElementOrder.add("Problem");
        lookupItemResponseElementOrder.add("RequestId");
        lookupItemResponseElementOrder.add("ItemId");
        lookupItemResponseElementOrder.add("HoldPickupDate");
        lookupItemResponseElementOrder.add("DateRecalled");
        lookupItemResponseElementOrder.add("ItemTransaction");
        lookupItemResponseElementOrder.add("ItemOptionalFields");
        lookupRequestResponseElementOrder = new ArrayList();
        lookupRequestResponseElementOrder.add("ResponseHeader");
        lookupRequestResponseElementOrder.add("Problem");
        lookupRequestResponseElementOrder.add("RequestId");
        lookupRequestResponseElementOrder.add("ItemId");
        lookupRequestResponseElementOrder.add("UserId");
        lookupRequestResponseElementOrder.add("RequestType");
        lookupRequestResponseElementOrder.add("RequestScopeType");
        lookupRequestResponseElementOrder.add("RequestStatusType");
        lookupRequestResponseElementOrder.add("HoldQueuePosition");
        lookupRequestResponseElementOrder.add("ShippingInformation");
        lookupRequestResponseElementOrder.add("EarliestDateNeeded");
        lookupRequestResponseElementOrder.add("NeedBeforeDate");
        lookupRequestResponseElementOrder.add("PickupDate");
        lookupRequestResponseElementOrder.add("PickupLocation");
        lookupRequestResponseElementOrder.add("PickupExpiryDate");
        lookupRequestResponseElementOrder.add("DateOfUserRequest");
        lookupRequestResponseElementOrder.add("DateAvailable");
        lookupRequestResponseElementOrder.add("AcknowledgedFeeAmount");
        lookupRequestResponseElementOrder.add("PaidFeeAmount");
        lookupRequestResponseElementOrder.add("ItemOptionalFields");
        lookupRequestResponseElementOrder.add("UserOptionalFields");
        personalNameInformationElementOrder = new ArrayList();
        personalNameInformationElementOrder.add("StructuredPersonalUserName");
        personalNameInformationElementOrder.add("UnstructuredPersonalUserName");
        requestedItemElementOrder = new ArrayList();
        requestedItemExtensions = new ArrayList();
        requestedItemElementOrder.add("RequestId");
        requestedItemElementOrder.add("ItemId");
        requestedItemElementOrder.add("BibliographicId");
        requestedItemElementOrder.add("RequestType");
        requestedItemElementOrder.add("RequestStatusType");
        requestedItemElementOrder.add("DatePlaced");
        requestedItemElementOrder.add("PickupDate");
        requestedItemElementOrder.add("PickupLocation");
        requestedItemElementOrder.add("PickupExpiryDate");
        requestedItemElementOrder.add("ReminderLevel");
        requestedItemElementOrder.add("HoldQueuePosition");
        requestedItemElementOrder.add("Title");
        requestedItemElementOrder.add("MediumType");
        requestedItemElementOrder.add("Ext");
        requestedItemExtensions.add("BibliographicDescription");
        requestedItemExtensions.add("EarliestDateNeeded");
        requestedItemExtensions.add("HoldQueueLength");
        requestedItemExtensions.add("NeedBeforeDate");
        requestedItemExtensions.add("SuspensionStartDate");
        requestedItemExtensions.add("SuspensionEndDate");
        requestItemElementOrder = new ArrayList();
        requestItemExtensions = new ArrayList();
        requestItemElementOrder.add("InitiationHeader");
        requestItemElementOrder.add("MandatedAction");
        requestItemElementOrder.add("UserId");
        requestItemElementOrder.add("AuthenticationInput");
        requestItemElementOrder.add("BibliographicId");
        requestItemElementOrder.add("ItemId");
        requestItemElementOrder.add("RequestId");
        requestItemElementOrder.add("RequestType");
        requestItemElementOrder.add("RequestScopeType");
        requestItemElementOrder.add("ItemOptionalFields");
        requestItemElementOrder.add("ShippingInformation");
        requestItemElementOrder.add("EarliestDateNeeded");
        requestItemElementOrder.add("NeedBeforeDate");
        requestItemElementOrder.add("PickupLocation");
        requestItemElementOrder.add("PickupExpiryDate");
        requestItemElementOrder.add("AcknowledgedFeeAmount");
        requestItemElementOrder.add("PaidFeeAmount");
        requestItemElementOrder.add("AcknowledgedItemUseRestrictionType");
        requestItemElementOrder.add("ItemElementType");
        requestItemElementOrder.add("UserElementType");
        requestItemElementOrder.add("Ext");
        requestItemExtensions.add("BibliographicDescription");
        requestItemExtensions.add("DesiredEdition");
        requestItemExtensions.add("EditionSubstitutionType");
        requestItemExtensions.add("MaxFeeAmount");
        requestItemExtensions.add("SuspensionStartDate");
        requestItemExtensions.add("SuspensionEndDate");
        requestItemExtensions.add("UserNote");
        requestItemExtensions.add("UserOptionalFields");
        requestItemResponseElementOrder = new ArrayList();
        requestItemResponseExtensions = new ArrayList();
        requestItemResponseElementOrder.add("ResponseHeader");
        requestItemResponseElementOrder.add("Problem");
        requestItemResponseElementOrder.add("RequiredFeeAmount");
        requestItemResponseElementOrder.add("RequiredItemUseRestrictionType");
        requestItemResponseElementOrder.add("RequestId");
        requestItemResponseElementOrder.add("ItemId");
        requestItemResponseElementOrder.add("UserId");
        requestItemResponseElementOrder.add("RequestType");
        requestItemResponseElementOrder.add("RequestScopeType");
        requestItemResponseElementOrder.add("ShippingInformation");
        requestItemResponseElementOrder.add("DateAvailable");
        requestItemResponseElementOrder.add("HoldPickupDate");
        requestItemResponseElementOrder.add("FiscalTransactionInformation");
        requestItemResponseElementOrder.add("ItemOptionalFields");
        requestItemResponseElementOrder.add("UserOptionalFields");
        requestItemResponseExtensions.add("HoldQueueLength");
        requestItemResponseExtensions.add("HoldQueuePosition");
        structuredAddressElementOrder = new ArrayList();
        structuredAddressElementOrder.add("LocationWithinBuilding");
        structuredAddressElementOrder.add("HouseName");
        structuredAddressElementOrder.add("Street");
        structuredAddressElementOrder.add("PostOfficeBox");
        structuredAddressElementOrder.add("District");
        structuredAddressElementOrder.add("Line1");
        structuredAddressElementOrder.add("Line2");
        structuredAddressElementOrder.add("Locality");
        structuredAddressElementOrder.add("Region");
        structuredAddressElementOrder.add("Country");
        structuredAddressElementOrder.add("PostalCode");
        structuredAddressElementOrder.add("CareOf");
        structuredHoldingsDataElementOrder = new ArrayList();
        structuredHoldingsDataElementOrder.add("HoldingsEnumeration");
        structuredHoldingsDataElementOrder.add("HoldingsChronology");
        elementOrderByParentElementName.put("CancelRequestItem", cancelRequestItemElementOrder);
        elementOrderByParentElementName.put("CancelRequestItemResponse", cancelRequestItemResponseElementOrder);
        elementOrderByParentElementName.put("ChronologyLevelInstance", chronologyLevelInstanceElementOrder);
        elementOrderByParentElementName.put("Destination", destinationElementOrder);
        elementOrderByParentElementName.put("EnumerationLevelInstance", enumerationLevelInstanceElementOrder);
        elementOrderByParentElementName.put("ItemRequestCancelled", itemRequestCancelledElementOrder);
        elementOrderByParentElementName.put("ItemShipped", itemShippedElementOrder);
        elementOrderByParentElementName.put("LookupItemResponse", lookupItemResponseElementOrder);
        elementOrderByParentElementName.put("LookupRequestResponse", lookupRequestResponseElementOrder);
        elementOrderByParentElementName.put("PersonalNameInformation", personalNameInformationElementOrder);
        elementOrderByParentElementName.put("RequestedItem", requestedItemElementOrder);
        elementOrderByParentElementName.put("RequestItem", requestItemElementOrder);
        elementOrderByParentElementName.put("RequestItemResponse", requestItemResponseElementOrder);
        elementOrderByParentElementName.put("StructuredAddress", structuredAddressElementOrder);
        elementOrderByParentElementName.put("StructuredHoldingsData", structuredHoldingsDataElementOrder);
        extensionElementsByParentObjectName.put("RequestedItem", requestedItemExtensions);
        extensionElementsByParentObjectName.put("RequestItem", requestItemExtensions);
        extensionElementsByParentObjectName.put("RequestItemResponse", requestItemResponseExtensions);
    }
}
