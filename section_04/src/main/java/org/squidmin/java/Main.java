package org.squidmin.java;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final WebConfig webConfig;

    public Main(WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        testCorsConfiguration();
    }

    private void testCorsConfiguration() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/sample";

        // Setting origin header to simulate cross-origin request
        HttpHeaders headers = new HttpHeaders();
        headers.set("Origin", "https://example.com");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            System.out.println("Response Status Code: " + response.getStatusCodeValue());
            System.out.println("Response Body: " + response.getBody());
        } catch (Exception e) {
            System.err.println("CORS request failed: " + e.getMessage());
        }
    }

}
