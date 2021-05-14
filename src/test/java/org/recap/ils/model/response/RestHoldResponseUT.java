package org.recap.ils.model.response;

import org.junit.Test;
import org.recap.BaseTestCaseUT;
import org.recap.ils.protocol.rest.model.DebugInfo;
import org.recap.ils.protocol.rest.model.response.RestHoldResponse;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

public class RestHoldResponseUT extends BaseTestCaseUT {

    @Test
    public void testRestHoldResponse() {
        RestHoldResponse restHoldResponse = new RestHoldResponse();
        restHoldResponse.setCount(1);
        restHoldResponse.setStatusCode(1);
        restHoldResponse.setDebugInfo(Arrays.asList(new DebugInfo()));
        assertNotNull(restHoldResponse.getCount());
        assertNotNull(restHoldResponse.getStatusCode());
        assertNotNull(restHoldResponse.getDebugInfo());
    }
}
