package org.extensiblecatalog.ncip.v2.binding.jaxb;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.JAXBElement;
import org.dozer.MappingException;
import org.extensiblecatalog.ncip.v2.service.PhysicalAddressType;
import org.extensiblecatalog.ncip.v2.service.ReflectionHelper;
import org.extensiblecatalog.ncip.v2.service.ToolkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JAXBHelper {
    private static final Logger logger = LoggerFactory.getLogger(JAXBHelper.class);

    public JAXBHelper() {
    }

    public static String getMessageName(Object msg) throws InvocationTargetException, IllegalAccessException, ToolkitException {
        String msgName = null;
        Class objClass = msg.getClass();
        Field[] fields = objClass.getDeclaredFields();
        Field[] var4 = fields;
        int var5 = fields.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Field f = var4[var6];
            Method getterMethod = ReflectionHelper.findMethod(objClass, "get" + f.getName(), new Class[0]);
            if (getterMethod != null) {
                Object innerObj = getterMethod.invoke(msg);
                if (innerObj != null) {
                    if (!ReflectionHelper.isCollection(innerObj.getClass())) {
                        Method getAnyMethod = ReflectionHelper.findMethod(innerObj.getClass(), "getAny", new Class[0]);
                        if (getAnyMethod != null) {
                            List<Object> anyObjList = (List)getAnyMethod.invoke(innerObj);
                            if (anyObjList != null && !anyObjList.isEmpty()) {
                                msgName = anyObjList.get(0).getClass().getSimpleName();
                            } else {
                                msgName = innerObj.getClass().getSimpleName();
                            }
                        } else {
                            msgName = innerObj.getClass().getSimpleName();
                        }
                        break;
                    }

                    Collection coll = (Collection)innerObj;
                    if (!coll.isEmpty()) {
                        Object collectionObj = coll.iterator().next();
                        msgName = collectionObj.getClass().getSimpleName();
                        break;
                    }
                }
            }
        }

        return msgName;
    }

    public static String getScheme(Object jaxbObject) {
        try {
            String result = (String)ReflectionHelper.findMethod(jaxbObject.getClass(), "getScheme", new Class[0]).invoke(jaxbObject);
            return result;
        } catch (IllegalAccessException var3) {
            throw new MappingException(var3);
        } catch (InvocationTargetException var4) {
            throw new MappingException(var4);
        }
    }

    public static String getValue(Object jaxbObject) {
        try {
            String result = (String)ReflectionHelper.findMethod(jaxbObject.getClass(), "getValue", new Class[0]).invoke(jaxbObject);
            return result;
        } catch (IllegalAccessException var3) {
            throw new MappingException(var3);
        } catch (InvocationTargetException var4) {
            throw new MappingException(var4);
        }
    }

    public static void setScheme(JAXBElement element, String scheme) {
        setScheme(element.getValue(), scheme);
    }

    public static void setScheme(Object jaxbObject, String scheme) {
        try {
            ReflectionHelper.findMethod(jaxbObject.getClass(), "setScheme", new Class[]{String.class}).invoke(jaxbObject, scheme);
        } catch (IllegalAccessException var3) {
            throw new MappingException(var3);
        } catch (InvocationTargetException var4) {
            throw new MappingException(var4);
        }
    }

    public static void setValue(JAXBElement element, String value) {
        setValue(element.getValue(), value);
    }

    public static void setValue(Object jaxbObject, String value) {
        try {
            ReflectionHelper.findMethod(jaxbObject.getClass(), "setValue", new Class[]{String.class}).invoke(jaxbObject, value);
        } catch (IllegalAccessException var3) {
            throw new MappingException(var3);
        } catch (InvocationTargetException var4) {
            throw new MappingException(var4);
        }
    }

    public static List<Object> getAnyList(Object extension) {
        Method getAnyMethod = ReflectionHelper.findMethod(extension.getClass(), "getAny", new Class[0]);
        if (getAnyMethod != null) {
            try {
                List<Object> result = (List)getAnyMethod.invoke(extension);
                return result;
            } catch (IllegalAccessException var4) {
                throw new MappingException(var4);
            } catch (InvocationTargetException var5) {
                throw new MappingException(var5);
            }
        } else {
            throw new MappingException("Object " + extension.getClass() + " does not appear to be an Ext element (no 'getAny' method).");
        }
    }

    public static void addToExtension(Object extension, Object obj) {
        List<Object> list = getAnyList(extension);
        list.add(obj);
    }

    public static void addAllToExtension(Object extension, List<Object> listToAdd) {
        List<Object> list = getAnyList(extension);
        list.addAll(listToAdd);
    }

    public static <JAXBSVP> JAXBSVP createJAXBSchemeValuePair(Class<JAXBSVP> jaxbSVPClass, String scheme, String value) throws IllegalAccessException, InstantiationException {
        JAXBSVP jaxbSVP = jaxbSVPClass.newInstance();
        setScheme(jaxbSVP, scheme);
        setValue(jaxbSVP, value);
        return jaxbSVP;
    }
}
