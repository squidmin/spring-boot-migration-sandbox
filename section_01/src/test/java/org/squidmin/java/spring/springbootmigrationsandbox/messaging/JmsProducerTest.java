package org.squidmin.java.spring.springbootmigrationsandbox.messaging;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jms.core.JmsTemplate;

public class JmsProducerTest {

    @Mock
    private JmsTemplate jmsTemplate;

    @InjectMocks
    private JmsProducer jmsProducer;

    public JmsProducerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSendMessage() {
        String destination = "test-queue";
        String message = "Hello, JMS!";

        jmsProducer.sendMessage(destination, message);

        Mockito.verify(jmsTemplate, Mockito.times(1)).convertAndSend(destination, message);
    }

}
