package com.blumbit.web.api.store.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    // Configuracion del acceso a nuestra applicacion mediante Keycloak
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // Devolvemos un objeto de configuracion donde indicamos que los usuarios
        // tendrán acceso mediante usuario/contraseña
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(http->http.anyRequest().authenticated())
                .oauth2ResourceServer(oauth-> oauth.jwt(jwt -> {}))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}
