package org.recap.ils.model.rest;

import org.junit.Test;
import org.recap.BaseTestCaseUT;
import org.recap.ils.protocol.rest.model.Attributes;
import org.recap.ils.protocol.rest.model.CheckOutItemResponse;
import org.recap.ils.protocol.rest.model.NoticesData;
import org.recap.ils.protocol.rest.model.Problem;

import java.util.Date;

import static org.junit.Assert.assertNotNull;

/**
 * Created by hemalathas on 3/4/17.
 */
public class NoticesDataUT extends BaseTestCaseUT {


    @Test
    public void testNoticesData() {
        Problem problem = new Problem();
        problem.setProblemType("test");
        problem.setProblemDetail("test");
        CheckOutItemResponse checkOutItemResponse = new CheckOutItemResponse();
        checkOutItemResponse.setProblem(problem);
        Attributes attributes = new Attributes();
        attributes.setVersion("SCSB-0.12");
        NoticesData noticesData = new NoticesData();
        noticesData.setAttributes(attributes);
        noticesData.setCheckOutItemResponse(checkOutItemResponse);
        noticesData.setDesiredDateDue(new Date().toString());
        noticesData.setId(1);
        noticesData.setItemBarcode("14565465664675641");
        noticesData.setPatron("test");
        noticesData.setPatronBarcode("4534444147");
        noticesData.setProcessed(true);

        assertNotNull(problem.getProblemDetail());
        assertNotNull(problem.getProblemType());
        assertNotNull(checkOutItemResponse.getProblem());
        assertNotNull(attributes.getVersion());
        assertNotNull(noticesData.getId());
        assertNotNull(noticesData.getItemBarcode());
        assertNotNull(noticesData.getPatronBarcode());
        assertNotNull(noticesData.getProcessed());
        assertNotNull(noticesData.getPatron());
        assertNotNull(noticesData.getDesiredDateDue());
        assertNotNull(noticesData.getAttributes());
        assertNotNull(noticesData.getCheckOutItemResponse());
    }

}