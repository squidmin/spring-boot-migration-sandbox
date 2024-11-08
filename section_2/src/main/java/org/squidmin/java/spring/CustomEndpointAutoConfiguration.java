package org.squidmin.java.spring;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomEndpointAutoConfiguration {

    @Bean
    @ConditionalOnProperty(name = "management.endpoint.info.enabled", havingValue = "true")
    public CustomEndpointService customEndpointService() {
        return new CustomEndpointService();
    }

}
