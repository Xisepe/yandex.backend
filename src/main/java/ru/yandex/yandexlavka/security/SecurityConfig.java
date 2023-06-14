package ru.yandex.yandexlavka.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
class SecurityConfig {

    public static final String ADMIN = "admin";
    public static final String USER = "user";
    public static final String COURIER = "courier";
    private final JwtAuthConverter jwtAuthConverter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/**").hasRole(ADMIN)
                .requestMatchers(HttpMethod.GET, "/orders/**").hasAnyRole(USER, COURIER)
                .requestMatchers(HttpMethod.POST, "/orders").hasRole(USER)
                .requestMatchers(HttpMethod.GET, "/couriers/**").hasRole(COURIER)
                .requestMatchers(HttpMethod.POST, "/orders/complete").hasRole(COURIER)
                .anyRequest().authenticated();
        http.oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtAuthConverter);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }
}