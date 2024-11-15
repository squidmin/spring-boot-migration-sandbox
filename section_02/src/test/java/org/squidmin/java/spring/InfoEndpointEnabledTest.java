package org.squidmin.java.spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(properties = "management.endpoint.info.enabled=true")
class InfoEndpointEnabledTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void whenInfoEndpointEnabled_thenCustomEndpointServiceBeanShouldBeLoaded() {
        Assertions.assertThat(context.containsBean("customEndpointService")).isTrue();
    }

}
