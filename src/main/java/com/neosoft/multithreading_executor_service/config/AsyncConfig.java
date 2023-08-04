package com.neosoft.multithreading_executor_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync //inform to spring boot to run ur task in background using thread pool concept
public class AsyncConfig {

    //    need to create bean of executor
    /*@Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("userThread-");
        executor.initialize();
        return executor;
    }*/
    //discard dead threads
}