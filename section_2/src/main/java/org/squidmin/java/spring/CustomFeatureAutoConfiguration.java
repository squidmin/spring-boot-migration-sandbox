package org.squidmin.java.spring;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
@ConditionalOnClass(Filter.class)
@ConditionalOnProperty(name = "custom.feature.enabled", havingValue = "true")
public class CustomFeatureAutoConfiguration {

    @Bean
    public CustomFeatureService customFeatureService() {
        return new CustomFeatureService();
    }

}
