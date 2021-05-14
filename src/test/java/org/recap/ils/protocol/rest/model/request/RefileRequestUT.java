package org.recap.ils.protocol.rest.model.request;

import org.junit.Test;
import org.recap.ils.protocol.rest.model.request.RefileRequest;

import static org.junit.Assert.assertNotNull;

public class RefileRequestUT {

    @Test
    public void getRefileRequest(){
        RefileRequest refileRequest = new RefileRequest();
        refileRequest.setItemBarcode("123456");

        assertNotNull(refileRequest.getItemBarcode());
    }
}
