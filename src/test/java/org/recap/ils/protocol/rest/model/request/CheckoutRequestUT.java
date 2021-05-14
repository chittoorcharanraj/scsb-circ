package org.recap.ils.protocol.rest.model.request;

import org.junit.Test;
import org.recap.ils.protocol.rest.model.request.CheckoutRequest;

import java.util.Date;

import static org.junit.Assert.assertNotNull;

public class CheckoutRequestUT {

    @Test
    public void getCheckoutRequest(){
        CheckoutRequest checkoutRequest = new CheckoutRequest();
        checkoutRequest.setDesiredDateDue(new Date().toString());
        checkoutRequest.setItemBarcode("123456");
        checkoutRequest.setPatronBarcode("123456");

        assertNotNull(checkoutRequest.getDesiredDateDue());
        assertNotNull(checkoutRequest.getItemBarcode());
        assertNotNull(checkoutRequest.getPatronBarcode());
    }
}
