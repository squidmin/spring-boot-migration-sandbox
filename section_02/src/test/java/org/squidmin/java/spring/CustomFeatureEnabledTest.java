package org.squidmin.java.spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(properties = "custom.feature.enabled=true")
class CustomFeatureEnabledTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void whenCustomFeatureEnabled_thenCustomFeatureServiceBeanShouldBeLoaded() {
        Assertions.assertThat(context.containsBean("customFeatureService")).isTrue();
    }

}
