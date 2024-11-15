package org.squidmin.java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/sample")
    public String sampleEndpoint() {
        return "CORS Configuration Successful!";
    }

}

