# ActiveMQ Message Broker

### 1. Start an ActiveMQ message broker on your machine

To start an ActiveMQ message broker on your machine, you can use Docker:

```bash
docker run -p 61616:61616 -p 8161:8161 rmohr/activemq
```

### 2. Run the `spring-boot-migration-guide` application

### 3. Send a test message using the REST endpoint

```plaintext
POST http://localhost:8080/api/jms/send?message=HelloJMS
```

You should see the message `Received message: HelloJMS` printed in the application logs, indicating that the consumer successfully received the message.

This setup provides a basic JMS messaging component in the `spring-boot-v2` branch with an ActiveMQ message broker.
