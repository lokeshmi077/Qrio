package com.backend.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()         // disable CSRF for POST
            .authorizeHttpRequests()
            .requestMatchers("/api/users/**").permitAll() // public APIs
            .anyRequest().authenticated(); // rest require auth
        return http.build();
    }
}
