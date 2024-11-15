package org.squidmin.java;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Controller.class)
@AutoConfigureMockMvc(addFilters = false)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void sampleEndpoint_shouldReturnExpectedResponse() throws Exception {
        mockMvc.perform(get("/sample"))
            .andExpect(status().isOk())
            .andExpect(content().string("CORS Configuration Successful!"));
    }

}
