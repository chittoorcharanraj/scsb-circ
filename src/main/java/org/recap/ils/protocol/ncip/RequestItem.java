package org.recap.ils.protocol.ncip;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.extensiblecatalog.ncip.v2.service.*;
import org.json.JSONObject;
import org.recap.common.ScsbConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Data
@EqualsAndHashCode(callSuper=false)
public class RequestItem extends ScsbNCIP {

    private String requestIdString;
    private String useridString;
    private String itemIdString;
    private String pickupLocationString;
    protected String toAgency;
    protected String fromAgency;
    private String requestedActionTypeString;
    private String applicationProfileTypeString;
    private HashMap<String, HashMap<String, String>> itemOptionalFields = new HashMap<>();

    public RequestItem() {
        itemOptionalFields.put(ScsbConstants.BIBLIOGRAPHIC_DESCRIPTION, new HashMap<>());
        itemOptionalFields.put(ScsbConstants.ITEM_DESCRIPTION, new HashMap<>());
    }

    public RequestItem setRequestActionType(String action) {
        requestedActionTypeString = action;
        return this;
    }

    public RequestItem setApplicationProfileType(String profileType) {
        applicationProfileTypeString = profileType;
        return this;
    }

    public RequestItem setItemId(String itemId) {
        itemIdString = itemId;
        return this;
    }

    public RequestItem setRequestId(String requestId) {
        requestIdString = requestId;
        return this;
    }

    public RequestItem setUserId(String userId) {
        useridString = userId;
        return this;
    }

    public RequestItem setPickupLocation(String pickupLocation) {
        pickupLocationString = pickupLocation;
        return this;
    }

    public RequestItem addBibliographicDescription(String bibliographicDescriptionType, String value) {
        itemOptionalFields.get(ScsbConstants.BIBLIOGRAPHIC_DESCRIPTION).put(bibliographicDescriptionType, value);
        return this;
    }

    public RequestItem addItemDescription(String itemDescriptionType, String value) {
        itemOptionalFields.get(ScsbConstants.ITEM_DESCRIPTION).put(itemDescriptionType, value);
        return this;
    }

    public RequestItem setToAgency(String toAgency) {
        this.toAgency = toAgency;
        return this;
    }

    public RequestItem setFromAgency(String fromAgency) {
        this.fromAgency = fromAgency;
        return this;
    }

    public RequestItem setRequestedActionTypeString(String actionType) {
        this.requestedActionTypeString = actionType;
        return this;
    }

    // Convenience methods
    public RequestItem setTitle(String title) {
        return setInfo(ScsbConstants.TITLE, title);
    }

    public RequestItem setAuthor(String author) {
        return setInfo(ScsbConstants.AUTHOR, author);
    }

    public RequestItem setPublisher(String publisher) {
        return setInfo(ScsbConstants.PUBLISHER, publisher);
    }

    public RequestItem setPublicationDate(String pubDate) {
        return setInfo(ScsbConstants.PUBLICATION_DATE, pubDate);
    }

    private RequestItem setInfo(String var, String info) {
        this.itemOptionalFields.get(ScsbConstants.BIBLIOGRAPHIC_DESCRIPTION).put(var, info);
        return this;
    }

    public RequestItem setIsbn(String isbn) {
        return setInfo(ScsbConstants.ISBN, isbn);
    }

    public RequestItem setIssn(String issn) {
        return setInfo(ScsbConstants.ISSN, issn);
    }

    public RequestItem setCallNumber(String callNumber) {
        this.itemOptionalFields.get(ScsbConstants.ITEM_DESCRIPTION).put(ScsbConstants.CALL_NUMBER, callNumber);
        return this;
    }

    public String getAuthor() {
        return this.itemOptionalFields.get(ScsbConstants.BIBLIOGRAPHIC_DESCRIPTION).get(ScsbConstants.AUTHOR);
    }

    public String getTitle() {
        return this.itemOptionalFields.get(ScsbConstants.BIBLIOGRAPHIC_DESCRIPTION).get(ScsbConstants.TITLE);
    }

    public String getCallNo() {
        return this.itemOptionalFields.get(ScsbConstants.ITEM_DESCRIPTION).get(ScsbConstants.CALL_NUMBER);
    }

    public RequestItemInitiationData getRequestItemInitiationData(String itemIdentifier, Integer requestId, String patronIdentifier, String owningInstItemId, String title, String author, String itemPickupLocation, String callNumber, String ncipAgencyId, String ncipScheme, String itemAgencyId)  {
        log.info("owningInstItemId >>>>>>>>> " + owningInstItemId);
        log.info("itemIdentifier >>>>>>>>> " + itemIdentifier);
        log.info("request id >>>>> " + requestId);
        RequestItemInitiationData requestItemInitiationData = new RequestItemInitiationData();
        InitiationHeader initiationHeader = new InitiationHeader();
        initiationHeader = getInitiationHeaderwithoutProfile(initiationHeader, ncipScheme, itemAgencyId, ncipAgencyId);
        initiationHeader.setApplicationProfileType(new ApplicationProfileType(null,itemAgencyId));
        requestItemInitiationData.setInitiationHeader(initiationHeader);

        RequestId requestIdentifier = new RequestId();
      /*  if(requestId != null) {
            requestIdentifier.setRequestIdentifierValue(requestId.toString());
        }
        else {*/
            requestIdentifier.setRequestIdentifierValue(itemIdentifier);
   //     }
        UserId userid = new UserId();
        userid.setUserIdentifierType(new UserIdentifierType("barcode"));
        userid.setUserIdentifierValue(patronIdentifier);
        RequestScopeType requestScopeType = new RequestScopeType(null,"Item");
        RequestType requestType = new RequestType(null,"Page");
        BibliographicId bibliographicId = new BibliographicId();
        BibliographicRecordId bibliographicRecordId = new BibliographicRecordId();
        bibliographicRecordId.setBibliographicRecordIdentifier(owningInstItemId);
        bibliographicId.setBibliographicRecordId(bibliographicRecordId);
        List<BibliographicId> bibliographicIds = new ArrayList<BibliographicId>();
        bibliographicIds.add(bibliographicId);

        PickupLocation pickupLocation = new PickupLocation(itemPickupLocation);

        log.info("requestScopeType >>>>>>> " + requestScopeType);
        requestItemInitiationData.setUserId(userid);
        requestItemInitiationData.setInitiationHeader(initiationHeader);
        requestItemInitiationData.setRequestId(requestIdentifier);
        requestItemInitiationData.setBibliographicIds(bibliographicIds);
        requestItemInitiationData.setRequestType(requestType);
        requestItemInitiationData.setRequestScopeType(requestScopeType);
        requestItemInitiationData.setPickupLocation(pickupLocation);

        return requestItemInitiationData;

    }

    public JSONObject getRequestItemResponse(NCIPResponseData requestItemResponse) {
        JSONObject returnJson = new JSONObject();
         log.info("RequestItemResponseData in getRequestItemResponse()  >>>>>>>> " + requestItemResponse);
        // DEAL W/PROBLEMS IN THE RESPONSE
        if (!requestItemResponse.getProblems().isEmpty()) {
            return generateNcipProblems(requestItemResponse);
        }

    //    String itemId = requestItemResponse.getItemId().getItemIdentifierValue();
      //  String requestId = requestItemResponse.getRequestId().getRequestIdentifierValue();

        returnJson.put("Success", Boolean.TRUE);
     //   returnJson.put("requestId", requestId);
      //  returnJson.put("itemId", itemId);

        return returnJson;
    }


}
