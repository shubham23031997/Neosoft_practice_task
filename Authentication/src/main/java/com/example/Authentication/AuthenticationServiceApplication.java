package com.example.Authentication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableWebSecurity
@EnableDiscoveryClient
@Slf4j
public class AuthenticationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationServiceApplication.class, args);
        System.out.println("Authentication service ready");
        log.info("authentication service is available to use");
    }

    @Bean
    public RestTemplate template() {
        return new RestTemplate();
    }

}
