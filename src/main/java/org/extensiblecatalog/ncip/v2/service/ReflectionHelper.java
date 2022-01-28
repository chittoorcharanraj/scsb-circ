package org.extensiblecatalog.ncip.v2.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ReflectionHelper {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionHelper.class);

    private ReflectionHelper() {
    }

    public static Field findField(Class objClass, String fieldName) {
        logger.debug("Looking for field " + fieldName + " in " + objClass.getName());
        Field result = null;
        Field[] fields = objClass.getDeclaredFields();
        Field[] var4 = fields;
        int var5 = fields.length;

        int var6;
        Field f;
        for(var6 = 0; var6 < var5; ++var6) {
            f = var4[var6];
            if (f.getName().compareToIgnoreCase(fieldName) == 0) {
                result = f;
                break;
            }
        }

        if (result == null) {
            fields = objClass.getDeclaredFields();
            var4 = fields;
            var5 = fields.length;

            for(var6 = 0; var6 < var5; ++var6) {
                f = var4[var6];
                if (f.getName().compareToIgnoreCase(fieldName + "s") == 0) {
                    result = f;
                    break;
                }
            }
        }

        return result;
    }

    public static Object createObject(Class<?> objClass, Object... parameters) throws ToolkitException {
        try {
            Class[] parmTypes;
            if (parameters != null) {
                parmTypes = new Class[parameters.length];

                for(int index = 0; index < parameters.length; ++index) {
                    parmTypes[index] = parameters[index].getClass();
                    if (parameters[index] instanceof String) {
                        String temp = (String)parameters[index];
                        if (temp.startsWith("\"") && temp.endsWith("\"")) {
                            parameters[index] = temp.substring(1, temp.length() - 1);
                        }
                    }
                }
            } else {
                parmTypes = new Class[0];
            }

            Constructor ctor = objClass.getConstructor(parmTypes);
            Object obj = ctor.newInstance(parameters);
            return obj;
        } catch (InstantiationException var6) {
            throw new ToolkitException("Exception constructing an instance of " + objClass, var6);
        } catch (IllegalAccessException var7) {
            throw new ToolkitException("Exception constructing an instance of " + objClass, var7);
        } catch (NoSuchMethodException var8) {
            throw new ToolkitException("Exception constructing an instance of " + objClass, var8);
        } catch (InvocationTargetException var9) {
            throw new ToolkitException("Exception constructing an instance of " + objClass, var9);
        }
    }

    public static Method findMethod(Class objClass, String methodName, Class... parameterTypes) {
        logger.debug("Looking for method " + methodName + "(" + formatClassNames(parameterTypes) + ") on " + objClass.getName() + ".");
        Method result = null;
        Method[] methods = objClass.getDeclaredMethods();
        Method[] var5 = methods;
        int var6 = methods.length;

        int var7;
        Method m;
        Class[] methodParameterTypes;
        for(var7 = 0; var7 < var6; ++var7) {
            m = var5[var7];
            if (m.getName().compareToIgnoreCase(methodName) == 0) {
                methodParameterTypes = m.getParameterTypes();
                if (parametersMatch(methodParameterTypes, parameterTypes)) {
                    result = m;
                    break;
                }
            }
        }

        if (result == null) {
            methods = objClass.getDeclaredMethods();
            var5 = methods;
            var6 = methods.length;

            for(var7 = 0; var7 < var6; ++var7) {
                m = var5[var7];
                if (m.getName().compareToIgnoreCase(methodName + "s") == 0) {
                    methodParameterTypes = m.getParameterTypes();
                    if (parametersMatch(methodParameterTypes, parameterTypes)) {
                        result = m;
                        break;
                    }
                }
            }
        }

        if (result == null) {
            logger.debug("Method " + methodName + "(" + formatClassNames(parameterTypes) + ") on " + objClass.getName() + " not found.");
        }

        return result;
    }

    public static Class determineClass(Object obj, String fieldName) throws ToolkitException {
        return determineClass(obj, obj.getClass(), fieldName);
    }

    public static Class determineClass(Object obj, Class objClass, String fieldName) throws ToolkitException {
        Field field = findField(objClass, fieldName);
        if (field != null) {
            Class fieldClass = field.getType();
            if (Collection.class.isAssignableFrom(fieldClass)) {
                Method method = findMethod(objClass, "get" + fieldName, Integer.TYPE);
                if (method == null) {
                    throw new ToolkitException("Can not determine class of Collection field '" + fieldName + "' in " + obj.getClass().getName() + "; perhaps there is no indexed getter?");
                }

                fieldClass = method.getReturnType();
            }

            return fieldClass;
        } else {
            throw new ToolkitException("No such field '" + fieldName + "' in " + obj.getClass().getName());
        }
    }

    public static String formatClassNames(Class... classes) {
        String result = "";
        if (classes != null && classes.length > 0) {
            StringBuilder sb = new StringBuilder();
            Class[] var3 = classes;
            int var4 = classes.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Class c = var3[var5];
                sb.append(c.getName()).append(", ");
            }

            result = sb.toString();
            result = result.substring(0, result.length() - 2);
        }

        return result;
    }

    public static boolean parametersMatch(Class<?>[] methodParameterTypes, Class[] parameterTypes) {
        boolean parameterTypesMatch = true;
        if (methodParameterTypes.length != 0 || parameterTypes != null && parameterTypes.length != 0) {
            if (parameterTypes != null && parameterTypes.length == methodParameterTypes.length) {
                for(int i = 0; i < parameterTypes.length; ++i) {
                    if (!methodParameterTypes[i].isAssignableFrom(parameterTypes[i])) {
                        parameterTypesMatch = false;
                        break;
                    }
                }
            } else {
                parameterTypesMatch = false;
            }
        }

        return parameterTypesMatch;
    }

    public static boolean isFieldACollection(Class objClass, String fieldName) {
        boolean isCollection = false;
        Field field = findField(objClass, fieldName);
        if (field != null) {
            Class fieldClass = field.getType();
            if (isCollection(fieldClass)) {
                isCollection = true;
            }
        }

        return isCollection;
    }

    public static boolean isCollection(Class clazz) {
        return Collection.class.isAssignableFrom(clazz);
    }

    public static NCIPData unwrapFirstNonNullNCIPDataFieldViaGetter(NCIPMessage ncipMessage) throws IllegalAccessException, InvocationTargetException {
        NCIPData result = null;
        if (ncipMessage != null) {
            Class objClass = ncipMessage.getClass();
            Field[] fields = objClass.getDeclaredFields();
            Field[] var4 = fields;
            int var5 = fields.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                Field f = var4[var6];
                Method m = findMethod(objClass, "get" + f.getName());
                if (m != null) {
                    Object obj = m.invoke(ncipMessage);
                    if (obj != null && NCIPData.class.isAssignableFrom(obj.getClass())) {
                        result = (NCIPData)obj;
                        break;
                    }
                }
            }
        }

        return result;
    }

    public static void setField(Object obj, Object fieldValue, String fieldName) throws InvocationTargetException, IllegalAccessException, ToolkitException {
        if (fieldValue != null) {
            Class objClass = obj.getClass();
            Method setterMethod = findMethod(objClass, "set" + fieldName, fieldValue.getClass());
            if (setterMethod == null) {
                throw new ToolkitException("No such field '" + fieldName + "' in " + objClass.getName());
            }

            setterMethod.invoke(obj, fieldValue);
        }

    }
}
