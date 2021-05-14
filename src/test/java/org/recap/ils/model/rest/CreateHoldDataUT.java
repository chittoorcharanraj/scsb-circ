package org.recap.ils.model.rest;

import org.junit.Test;
import org.recap.BaseTestCaseUT;
import org.recap.ils.protocol.rest.model.CreateHoldData;
import org.recap.ils.protocol.rest.model.Description;

import static org.junit.Assert.assertNotNull;

public class CreateHoldDataUT extends BaseTestCaseUT {

    @Test
    public void getCreateHoldData(){
        CreateHoldData createHoldData = new CreateHoldData();
        createHoldData.setId(1);
        createHoldData.setDescription(new Description());
        assertNotNull(createHoldData.getId());
        assertNotNull(createHoldData.getDescription());
    }
}
