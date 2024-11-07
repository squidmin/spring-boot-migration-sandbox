package org.squidmin.java.spring.springbootmigrationsandbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.squidmin.java.spring.springbootmigrationsandbox.messaging.JmsProducer;

@RestController
@RequestMapping("/api/jms")
public class JmsController {

    private final JmsProducer jmsProducer;

    @Autowired
    public JmsController(JmsProducer jmsProducer) {
        this.jmsProducer = jmsProducer;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        jmsProducer.sendMessage("test-queue", message);
        return "Message sent to test-queue";
    }

}
