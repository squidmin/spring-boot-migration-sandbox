package org.squidmin.java.spring.springbootmigrationsandbox.controllers;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "customStatus")
public class CustomStatusEndpoint {

    @ReadOperation
    public String getStatus() {
        return "Application is running smoothly!";
    }

}
