//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.common;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.extensiblecatalog.ncip.v2.service.ApplicationProfileType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Protocol {
    private static final Logger logger = LoggerFactory.getLogger(Protocol.class);
    protected static Map<Protocol, Map<String, ApplicationProfileType>> profilesByNameByProtocolMap = new HashMap();
    public static final Protocol NCIP = new Protocol("NCIP");
    protected final String name;

    public static Protocol valueOf(String name) {
        Protocol result;
        if (NCIP.getName().compareToIgnoreCase(name) == 0) {
            result = NCIP;
        } else {
            result = null;
        }

        return result;
    }

    protected Protocol(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public ApplicationProfileType getProfile(String profile) {
        Map<String, ApplicationProfileType> profileMap = (Map)profilesByNameByProtocolMap.get(this);
        ApplicationProfileType result;
        if (profileMap != null) {
            result = (ApplicationProfileType)profileMap.get(profile);
        } else {
            result = null;
        }

        return result;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
