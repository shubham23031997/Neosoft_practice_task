package com.user.service;

import com.user.entity.Contact;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CONTACT-SERVICE")
public interface ContactService {

    @GetMapping("/contact/user/{userId}")
    List<Contact> getContacts(@PathVariable("userId") Long userId);
}
