//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.binding.jaxb.dozer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dozer.DozerConverter;
import org.dozer.MappingException;
import org.extensiblecatalog.ncip.v2.binding.jaxb.JAXBHelper;
import org.extensiblecatalog.ncip.v2.service.SchemeValuePair;

public class BaseSchemeValuePairToBooleanConverter<JAXBSVP> extends DozerConverter<List<JAXBSVP>, Boolean> {
    protected final Class<JAXBSVP> jaxbSVPClass;

    public BaseSchemeValuePairToBooleanConverter(Class<List<JAXBSVP>> jaxbSVPListClass, Class<JAXBSVP> jaxbSVPClass) {
        super(jaxbSVPListClass, Boolean.class);
        this.jaxbSVPClass = jaxbSVPClass;
    }

    public Boolean convertTo(List srcObj, Boolean targetBoolean) {
        Boolean result = Boolean.FALSE;
        if (srcObj != null) {
            try {
                SchemeValuePair svcSVP = this.getServiceSVP();
                Iterator var6 = srcObj.iterator();

                while(var6.hasNext()) {
                    JAXBSVP jaxbSVPObj = (JAXBSVP) var6.next();
                    String scheme = JAXBHelper.getScheme(jaxbSVPObj);
                    String value = JAXBHelper.getValue(jaxbSVPObj);
                    if (svcSVP.matches(scheme, value)) {
                        result = Boolean.TRUE;
                        break;
                    }
                }
            } catch (ClassNotFoundException var10) {
                throw new MappingException(var10);
            } catch (NoSuchFieldException var11) {
                throw new MappingException(var11);
            } catch (IllegalAccessException var12) {
                throw new MappingException(var12);
            }
        } else {
            result = Boolean.FALSE;
        }

        return result;
    }

    public List<JAXBSVP> convertFrom(Boolean srcBoolean, List targetObj) {
        Object result;
        if (targetObj != null) {
            result = targetObj;
        } else {
            result = new ArrayList();
        }

        if (srcBoolean) {
            try {
                SchemeValuePair svcSVP = this.getServiceSVP();
                JAXBSVP jaxbSVPObject = JAXBHelper.createJAXBSchemeValuePair(this.jaxbSVPClass, svcSVP.getScheme(), svcSVP.getValue());
                ((List)result).add(jaxbSVPObject);
            } catch (IllegalAccessException var6) {
                throw new MappingException(var6);
            } catch (ClassNotFoundException var7) {
                throw new MappingException(var7);
            } catch (NoSuchFieldException var8) {
                throw new MappingException(var8);
            } catch (InstantiationException var9) {
                throw new MappingException(var9);
            }
        }

        return (List)result;
    }

    protected SchemeValuePair getServiceSVP() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        String valueClassAndField = this.getParameter();
        String className = valueClassAndField.substring(0, valueClassAndField.lastIndexOf("."));
        String fieldName = valueClassAndField.substring(valueClassAndField.lastIndexOf(".") + 1);
        Class svcSVPClass = Class.forName(className);
        Field svpField = svcSVPClass.getField(fieldName);
        SchemeValuePair svcSVP = (SchemeValuePair)svpField.get((Object)null);
        return svcSVP;
    }
}
