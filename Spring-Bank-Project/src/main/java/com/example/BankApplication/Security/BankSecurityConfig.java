//package com.example.BankApplication.Security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class BankSecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests( auth -> {
//                    auth.requestMatchers("api/v1/Bank").permitAll();
//                    auth.requestMatchers("api/v1/Bank/accounts/add").permitAll();
//                    auth.requestMatchers("api/v1/Bank/{bankId}/update").permitAll();
//                    auth.requestMatchers("api/v1/Bank/{bankId}/add-money").permitAll();
//                    auth.requestMatchers("api/v1/Bank/{bankId}/withdraw").permitAll();
//                    auth.requestMatchers("api/v1/Bank").permitAll();
//                    auth.anyRequest().authenticated();
//                })
//                .formLogin(Customizer.withDefaults())
//                .build();
//    }
//}
