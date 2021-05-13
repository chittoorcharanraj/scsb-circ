package org.recap.ils.model.rest.request;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class RecallRequestUT {

    @Test
    public void getRecallRequest(){
        RecallRequest recallRequest = new RecallRequest();
        recallRequest.setItemBarcode("234567");
        recallRequest.setOwningInstitutionId("1");

        assertNotNull(recallRequest.getItemBarcode());
        assertNotNull(recallRequest.getOwningInstitutionId());
    }
}
