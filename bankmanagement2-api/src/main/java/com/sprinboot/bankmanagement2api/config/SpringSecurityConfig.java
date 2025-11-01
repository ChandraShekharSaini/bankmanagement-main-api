package com.sprinboot.bankmanagement2api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.securityMatcher("/api/**").authorizeHttpRequests(authorizeRequests -> {
            authorizeRequests.anyRequest().hasAnyRole("USER", "ADMIN");
        }).httpBasic(withDefaults());

        return httpSecurity.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user1 = User.withUsername("chandra").password("{noop}root").roles("USER").build();

        UserDetails user2 = User.withUsername("admin").password("{noop}admin").roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

}
