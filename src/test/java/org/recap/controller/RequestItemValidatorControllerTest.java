package org.recap.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;


@RunWith(MockitoJUnitRunner.Silent.class)
public class RequestItemValidatorControllerTest {

    @InjectMocks
    private RequestItemValidatorController requestItemValidatorController;

    @Test
    public void testGetHttpHeaders() {
        ReflectionTestUtils.invokeMethod(requestItemValidatorController, "getHttpHeaders");
    }
}
