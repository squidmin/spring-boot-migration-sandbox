package org.squidmin.java.spring.springbootmigrationsandbox.messaging;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class JmsConsumerTest {

    @Spy
    @InjectMocks
    private JmsConsumer jmsConsumer;

    public JmsConsumerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testReceiveMessage() {
        String message = "Hello, JMS!";

        // Assert that no exception is thrown when receiving the message
        Assertions.assertDoesNotThrow(() -> jmsConsumer.receiveMessage(message));
    }

}
