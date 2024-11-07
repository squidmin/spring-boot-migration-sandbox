package org.squidmin.java.spring.springbootmigrationsandbox.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.squidmin.java.spring.springbootmigrationsandbox.messaging.JmsProducer;

@WebMvcTest(controllers = JmsController.class)
@ActiveProfiles("test")
public class JmsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JmsProducer jmsProducer;

    @Test
    public void testSendMessage() throws Exception {
        String message = "Hello, JMS!";

        // Perform the POST request to the controller
        mockMvc.perform(MockMvcRequestBuilders.post("/api/jms/send")
                .param("message", message))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("Message sent to test-queue"));

        // Verify that JmsProducer's sendMessage method was called with the correct parameters
        Mockito.verify(jmsProducer, Mockito.times(1)).sendMessage("test-queue", message);
    }

}
