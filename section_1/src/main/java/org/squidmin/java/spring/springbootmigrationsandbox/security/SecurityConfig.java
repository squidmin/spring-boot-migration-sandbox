package org.squidmin.java.spring.springbootmigrationsandbox.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Profile("!test")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/actuator/**").hasRole("ADMIN")
            .antMatchers("/api/public/**").permitAll()
            .antMatchers("/api/jms/**").permitAll()
            .antMatchers("/api/users/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }

}
