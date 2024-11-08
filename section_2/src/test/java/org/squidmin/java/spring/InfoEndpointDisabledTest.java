package org.squidmin.java.spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(properties = "management.endpoint.info.enabled=false")
class InfoEndpointDisabledTest {

    @Autowired
    protected ApplicationContext context;

    @Test
    void whenInfoEndpointDisabled_thenCustomEndpointServiceBeanShouldNotBeLoaded() {
        Assertions.assertThat(context.containsBean("customEndpointService")).isFalse();
    }

}
