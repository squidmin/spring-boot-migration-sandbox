package org.squidmin.java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    @Autowired(required = false)
    private CustomFeatureService customFeatureService;

    @Autowired(required = false)
    private CustomEndpointService customEndpointService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() {
        if (customFeatureService != null) {
            customFeatureService.performAction();
        } else {
            System.out.println("CustomFeatureService is not configured");
        }

        if (customEndpointService != null) {
            System.out.println(customEndpointService.getStatus());
        } else {
            System.out.println("CustomEndpointService is not configured.");
        }
    }

}
