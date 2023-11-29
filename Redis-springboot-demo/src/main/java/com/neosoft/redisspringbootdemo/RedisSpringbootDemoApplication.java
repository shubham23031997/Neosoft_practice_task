package com.neosoft.redisspringbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisSpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisSpringbootDemoApplication.class, args);
    }

}
