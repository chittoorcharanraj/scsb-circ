//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.extensiblecatalog.ncip.v2.service.SchemeValueBehavior;
import org.extensiblecatalog.ncip.v2.service.SchemeValuePair;

public final class SchemeLoader {
    private SchemeLoader() {
    }

    public static void init(String addedSVPClassNamesCSV, String allowAnyClassNamesCSV, String addedAllowAnyClassNamesCSV, String allowNullSchemeClassNamesCSV, String addedAllowNullSchemeClassNamesCSV) throws InvocationTargetException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException {
        loadAll(addedSVPClassNamesCSV);
        allowAny(allowAnyClassNamesCSV, addedAllowAnyClassNamesCSV);
        allowNullScheme(allowNullSchemeClassNamesCSV, addedAllowNullSchemeClassNamesCSV);
    }

    public static void loadAll(String addedSVPClassNamesCSV) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String[] classNames;
        String[] var3;
        int var4;
        int var5;
        String className;
        Class clazz;
        Class svpClass;
        Method loadAllMethod;
       /* if (svpClassNamesCSV != null && !svpClassNamesCSV.isEmpty()) {
            classNames = svpClassNamesCSV.split(",");
            var3 = classNames;
            var4 = classNames.length;

            for(var5 = 0; var5 < var4; ++var5) {
                className = var3[var5];
                clazz = Class.forName(className);
                svpClass = clazz.asSubclass(SchemeValuePair.class);
                loadAllMethod = svpClass.getMethod("loadAll");
                loadAllMethod.invoke((Object)null);
            }
        }*/

        if (addedSVPClassNamesCSV != null && !addedSVPClassNamesCSV.isEmpty()) {
            classNames = addedSVPClassNamesCSV.split(",");
            var3 = classNames;
            var4 = classNames.length;

            for(var5 = 0; var5 < var4; ++var5) {
                className = var3[var5];
                clazz = Class.forName(className);
                svpClass = clazz.asSubclass(SchemeValuePair.class);
                loadAllMethod = svpClass.getMethod("loadAll");
                loadAllMethod.invoke((Object)null);
            }
        }

    }

    public static void allowAny(String allowAnyClassNamesCSV, String addedAllowAnyClassNamesCSV) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String[] classNames;
        String[] var3;
        int var4;
        int var5;
        String className;
        if (allowAnyClassNamesCSV != null && !allowAnyClassNamesCSV.isEmpty()) {
            classNames = allowAnyClassNamesCSV.split(",");
            var3 = classNames;
            var4 = classNames.length;

            for(var5 = 0; var5 < var4; ++var5) {
                className = var3[var5];
                SchemeValuePair.mapBehavior(className, SchemeValueBehavior.ALLOW_ANY);
            }
        }

        if (addedAllowAnyClassNamesCSV != null && !addedAllowAnyClassNamesCSV.isEmpty()) {
            classNames = addedAllowAnyClassNamesCSV.split(",");
            var3 = classNames;
            var4 = classNames.length;

            for(var5 = 0; var5 < var4; ++var5) {
                className = var3[var5];
                SchemeValuePair.mapBehavior(className, SchemeValueBehavior.ALLOW_ANY);
            }
        }

    }

    public static void allowNullScheme(String allowNullSchemeClassNamesCSV, String addedAllowNullSchemeClassNamesCSV) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String[] classNames;
        String[] var3;
        int var4;
        int var5;
        String className;
        if (allowNullSchemeClassNamesCSV != null && !allowNullSchemeClassNamesCSV.isEmpty()) {
            classNames = allowNullSchemeClassNamesCSV.split(",");
            var3 = classNames;
            var4 = classNames.length;

            for(var5 = 0; var5 < var4; ++var5) {
                className = var3[var5];
                SchemeValuePair.allowNullScheme(new String[]{className});
            }
        }

        if (addedAllowNullSchemeClassNamesCSV != null && !addedAllowNullSchemeClassNamesCSV.isEmpty()) {
            classNames = addedAllowNullSchemeClassNamesCSV.split(",");
            var3 = classNames;
            var4 = classNames.length;

            for(var5 = 0; var5 < var4; ++var5) {
                className = var3[var5];
                SchemeValuePair.allowNullScheme(new String[]{className});
            }
        }

    }
}
