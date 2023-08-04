package com.neosoft.multithreading_executor_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MultithreadingExecutorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultithreadingExecutorServiceApplication.class, args);
    }

}
