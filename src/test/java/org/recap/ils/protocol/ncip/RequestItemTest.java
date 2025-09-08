package org.recap.ils.protocol.ncip;

import org.extensiblecatalog.ncip.v2.service.*;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class RequestItemTest {

    @Spy
    @InjectMocks
    private RequestItem requestItem;

    @Mock
    private NCIPResponseData responseData;

    @Test
    public void ctor_initializesOptionalMaps_andFluentSettersWork() {

        RequestItem r = new RequestItem()
                .setRequestActionType("Page")
                .setRequestedActionTypeString("Hold")
                .setApplicationProfileType("profile")
                .setItemId("I1")
                .setRequestId("R1")
                .setUserId("U1")
                .setPickupLocation("PL1")
                .setToAgency("TA")
                .setFromAgency("FA")
                .addBibliographicDescription(org.recap.common.ScsbConstants.TITLE, "MyTitle")
                .addItemDescription(org.recap.common.ScsbConstants.CALL_NUMBER, "QA76.73")
                .setTitle("T2")
                .setAuthor("A2")
                .setPublisher("P2")
                .setPublicationDate("2024")
                .setIsbn("978-1-4028-9462-6")
                .setIssn("2049-3630")
                .setCallNumber("QA999.99");

        HashMap<String, HashMap<String, String>> maps = r.getItemOptionalFields();
        assertNotNull(maps);
        assertTrue(maps.containsKey(org.recap.common.ScsbConstants.BIBLIOGRAPHIC_DESCRIPTION));
        assertTrue(maps.containsKey(org.recap.common.ScsbConstants.ITEM_DESCRIPTION));

        assertEquals("A2", r.getAuthor());
        assertEquals("T2", r.getTitle());
        assertEquals("QA999.99", r.getCallNo());

        assertEquals("I1", r.getItemIdString());
        assertEquals("R1", r.getRequestIdString());
        assertEquals("U1", r.getUseridString());
        assertEquals("PL1", r.getPickupLocationString());
        assertEquals("TA", r.getToAgency());
        assertEquals("FA", r.getFromAgency());
        assertEquals("Hold", r.getRequestedActionTypeString());
        assertEquals("profile", r.getApplicationProfileTypeString());
    }

    @Test
    public void getRequestItemInitiationData_populatesFields_usingSpyForHeaderHelper() {
        doAnswer(invocation -> {
            InitiationHeader header = invocation.getArgument(0);
            String scheme = invocation.getArgument(1);
            String fromAgency = invocation.getArgument(2);
            String toAgency = invocation.getArgument(3);

            FromAgencyId from = new FromAgencyId();
            from.setAgencyId(new AgencyId(fromAgency));
            ToAgencyId to = new ToAgencyId();
            to.setAgencyId(new AgencyId(toAgency));
            header.setFromAgencyId(from);
            header.setToAgencyId(to);
            return header;
        }).when(requestItem).getInitiationHeaderwithoutProfile(any(InitiationHeader.class), anyString(), anyString(), anyString());

        String itemIdentifier = "ITEM-123";
        Integer requestId = 42;
        String patronId = "PATRON-999";
        String owningInstItemId = "OWN-ABC";
        String title = "Some Title";
        String author = "Some Author";
        String pickup = "MAIN-CIRC";
        String callNumber = "QA10";
        String ncipAgencyId = "REQ-AGENCY";
        String ncipScheme = "Test";
        String itemAgencyId = "OWN-AGENCY";

        RequestItemInitiationData data = requestItem.getRequestItemInitiationData(
                itemIdentifier, requestId, patronId, owningInstItemId, title, author,
                pickup, callNumber, ncipAgencyId, ncipScheme, itemAgencyId);

        assertNotNull(data);
        assertEquals(itemAgencyId, data.getInitiationHeader().getApplicationProfileType().getValue());

        assertEquals("barcode", data.getUserId().getUserIdentifierType().getValue());
        assertEquals(patronId, data.getUserId().getUserIdentifierValue());
        assertEquals("Page", data.getRequestType().getValue());
        assertEquals("Item", data.getRequestScopeType().getValue());
        assertEquals(pickup, data.getPickupLocation().getValue());

        assertEquals(itemIdentifier, data.getRequestId().getRequestIdentifierValue());
        assertEquals(owningInstItemId, data.getBibliographicIds().get(0).getBibliographicRecordId().getBibliographicRecordIdentifier());
    }

    @Test
    public void getRequestItemResponse_errorBranch_usesGenerateNcipProblems() {
        List<Problem> problems = new ArrayList<>();
        problems.add(new Problem(new ProblemType("ValidationError"), null, "Missing something"));
        when(responseData.getProblems()).thenReturn(problems);

        doAnswer(invocation -> {
            NCIPResponseData arg = invocation.getArgument(0);
            JSONObject j = new JSONObject();
            j.put("Success", false);
            j.put("ProblemsCount", arg.getProblems().size());
            return j;
        }).when(requestItem).generateNcipProblems(any(NCIPResponseData.class));

        JSONObject out = requestItem.getRequestItemResponse(responseData);
        assertFalse(out.getBoolean("Success"));
        assertEquals(1, out.getInt("ProblemsCount"));
    }

    @Test
    public void getRequestItemResponse_successBranch_onlySuccessTrue() {
        when(responseData.getProblems()).thenReturn(Collections.emptyList());
        JSONObject out = requestItem.getRequestItemResponse(responseData);
        assertTrue(out.getBoolean("Success"));
        assertEquals(1, out.length());
    }
}
