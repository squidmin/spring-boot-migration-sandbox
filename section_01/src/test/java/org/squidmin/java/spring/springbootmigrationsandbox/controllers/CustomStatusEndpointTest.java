package org.squidmin.java.spring.springbootmigrationsandbox.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomStatusEndpointTest {

    @Test
    public void testGetStatus() {
        Assertions.assertEquals(
            "Application is running smoothly!",
            new CustomStatusEndpoint().getStatus(),
            "The status message should match the expected output"
        );
    }

}
