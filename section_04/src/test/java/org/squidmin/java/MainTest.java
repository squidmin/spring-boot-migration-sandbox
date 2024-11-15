package org.squidmin.java;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class MainTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private Main main;

    @Test
    void testCorsConfiguration_shouldReturnExpectedResponse() {
        MockitoAnnotations.openMocks(this);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Origin", "https://example.com");

        ResponseEntity<String> mockResponse = new ResponseEntity<>(
            "CORS Configuration Successful!", headers, HttpStatus.OK);

        when(restTemplate.exchange(any(String.class), any(), any(), any(Class.class)))
            .thenReturn(mockResponse);

        main.run();
        assertThat(mockResponse.getBody()).isEqualTo("CORS Configuration Successful!");
    }

}
