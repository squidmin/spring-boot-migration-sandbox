package org.squidmin.java;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                          // Apply CORS to all endpoints
            .allowedOrigins("https://example.com")      // Only allow this origin, without wildcard
            .allowedMethods("GET", "POST")              // Specify allowed methods explicitly
            .allowedHeaders("*");                       // Allow all headers
    }
}
