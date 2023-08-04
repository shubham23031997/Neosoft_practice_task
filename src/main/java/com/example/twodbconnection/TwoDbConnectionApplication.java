package com.example.twodbconnection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.twodbconnection.postgres.controller.ProductController"})
// Add the package containing the configuration classes
public class TwoDbConnectionApplication {
    public static void main(String[] args) {
        SpringApplication.run(TwoDbConnectionApplication.class, args);
    }

}
//https://www.youtube.com/watch?v=mIFIb_JE47U&ab_channel=AshokIT
/*  ApplicationContext context=SpringApplication.run(TwoDbConnectionApplication.class, args);
        UserRepo userRepo= context.getBean(UserRepo.class);
        User user1=new User();
        user1.setUserName("shubhammali");
        user1.setEmail("shubham@gmail.com");
        User user2=new User();
        user2.setUserName("saiprasad");
        user2.setEmail("saiprasad@gmail.com");
        List userList=List.of(user1,user2);
        userRepo.saveAll(userList);*/