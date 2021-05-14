package org.recap.model.response;

import org.junit.Test;
import org.recap.model.response.ItemRefileResponse;

import static org.junit.Assert.assertNotNull;

public class ItemRefileResponseUT {

    @Test
    public void getItemRefileResponse(){
        ItemRefileResponse itemRefileResponse = new ItemRefileResponse();
        itemRefileResponse.setRequestId(1);
        itemRefileResponse.setJobId("1");
        assertNotNull(itemRefileResponse.getRequestId());
        assertNotNull(itemRefileResponse.getJobId());
    }
}
