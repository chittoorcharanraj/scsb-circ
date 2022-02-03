package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.dozer;

import java.util.HashMap;
import java.util.Map;
import org.extensiblecatalog.ncip.v2.binding.jaxb.BaseContentConverter;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.Ext;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.ObjectFactory;
import org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements.SchemeValuePair;
import org.extensiblecatalog.ncip.v2.service.AcceptItemInitiationData;
import org.extensiblecatalog.ncip.v2.service.AcceptItemResponseData;
import org.extensiblecatalog.ncip.v2.service.CancelRequestItemInitiationData;
import org.extensiblecatalog.ncip.v2.service.CancelRequestItemResponseData;
import org.extensiblecatalog.ncip.v2.service.CheckInItemInitiationData;
import org.extensiblecatalog.ncip.v2.service.CheckInItemResponseData;
import org.extensiblecatalog.ncip.v2.service.CheckOutItemInitiationData;
import org.extensiblecatalog.ncip.v2.service.CheckOutItemResponseData;
import org.extensiblecatalog.ncip.v2.service.LookupUserInitiationData;
import org.extensiblecatalog.ncip.v2.service.LookupUserResponseData;
import org.extensiblecatalog.ncip.v2.service.ProblemResponseData;
import org.extensiblecatalog.ncip.v2.service.RecallItemInitiationData;
import org.extensiblecatalog.ncip.v2.service.RecallItemResponseData;

public class NCIPv2_02ContentMappingFactory extends BaseContentConverter<SchemeValuePair, Ext> {
    protected static Map<String, Class<?>> elementNamesToServiceClassMap = new HashMap();
    protected static Map<String, Class<?>> elementNamesToJAXBClassMap;

    public NCIPv2_02ContentMappingFactory() {
        super(SchemeValuePair.class, Ext.class);
    }

    protected Ext createExtension() {
        return new Ext();
    }

    protected Object getObjectFactory() {
        return new ObjectFactory();
    }

    protected Map<String, Class<?>> getElementNamesToServiceClassMap() {
        return elementNamesToServiceClassMap;
    }

    protected Map<String, Class<?>> getElementNamesToJAXBClassMap() {
        return elementNamesToJAXBClassMap;
    }

    static {
        elementNamesToServiceClassMap.put("AcceptItem", AcceptItemInitiationData.class);
        elementNamesToServiceClassMap.put("AcceptItemResponse", AcceptItemResponseData.class);
        elementNamesToServiceClassMap.put("CancelRequestItem", CancelRequestItemInitiationData.class);
        elementNamesToServiceClassMap.put("CancelRequestItemResponse", CancelRequestItemResponseData.class);
        elementNamesToServiceClassMap.put("CheckInItem", CheckInItemInitiationData.class);
        elementNamesToServiceClassMap.put("CheckInItemResponse", CheckInItemResponseData.class);
        elementNamesToServiceClassMap.put("CheckOutItem", CheckOutItemInitiationData.class);
        elementNamesToServiceClassMap.put("CheckOutItemResponse", CheckOutItemResponseData.class);
        elementNamesToServiceClassMap.put("LookupUser", LookupUserInitiationData.class);
        elementNamesToServiceClassMap.put("LookupUserResponse", LookupUserResponseData.class);
        elementNamesToServiceClassMap.put("RecallItem", RecallItemInitiationData.class);
        elementNamesToServiceClassMap.put("RecallItemResponse", RecallItemResponseData.class);
        elementNamesToServiceClassMap.put("ProblemResponse", ProblemResponseData.class);
        elementNamesToJAXBClassMap = new HashMap();
    }
}
