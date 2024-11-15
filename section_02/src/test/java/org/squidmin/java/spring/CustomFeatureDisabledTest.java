package org.squidmin.java.spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(properties = "custom.feature.enabled=false")
class CustomFeatureDisabledTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void whenCustomFeatureDisabled_thenCustomFeatureServiceBeanShouldNotBeLoaded() {
        Assertions.assertThat(context.containsBean("customFeatureService")).isFalse();
    }

}
