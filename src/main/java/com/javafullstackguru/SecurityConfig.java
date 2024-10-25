package com.javafullstackguru;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for simplicity (not recommended for production)
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/api/public/**").permitAll() // Public endpoints
                .anyRequest().authenticated() // All other requests require authentication
            )
            .formLogin() // Use form login
            .and()
            .httpBasic(); // Enable basic authentication

        return http.build();
    }
}

