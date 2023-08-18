package com.user.controller;

import com.user.entity.User;
import com.user.service.ContactService;
import com.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(User.class);
    @Autowired
    private UserService userService;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private ContactService contactService;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {

        User user = this.userService.getUser(userId);
        //http://localhost:8999/contact/user/1311
        //this is link for service call through api gateway

        // List contacts = this.restTemplate.getForObject("http://contact-service/contact/user/" + user.getUserId(), List.class);
        System.out.println("user with id " + userId + user.getName());
        List contacts = contactService.getContacts(user.getUserId());
        user.setContacts(contacts);
        return user;
    }
}