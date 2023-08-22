package com.user.controller;

import com.user.entity.Contact;
import com.user.entity.User;
import com.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(User.class);
    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {

        User user = this.userService.getUser(userId);
        List contacts = this.restTemplate.getForObject("http://contact-service/contact/user/" + user.getUserId(), List.class);
        System.out.println("user with id " + userId + user.getName());
        log.info("contactList {} ::", contacts);
        user.setContacts(contacts);
        return user;
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        User user1 = new User();
        user1.setUserId(user.getUserId());
        user1.setContacts(user.getContacts());
        user1.setName(user.getName());
        user1.setPhone(user1.getPhone());
        userService.createUser(user1);
        List<Contact> contacts = user.getContacts();
        if (contacts != null && !contacts.isEmpty()) {
            for (Contact contact : contacts) {
                // Make a POST request to the Contact Service to create each contact
                Contact createdContact = restTemplate.postForObject("http://contact-service/contact/add", contact, Contact.class);
            }
        }
        return user;
    }
}