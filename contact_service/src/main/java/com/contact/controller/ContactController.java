package com.contact.controller;

import com.contact.entity.Contact;
import com.contact.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private static final Logger LOGGER = LoggerFactory.getLogger(Contact.class);

    @Autowired
    private ContactService contactService;

    @GetMapping("/user/{userId}")
    public List<Contact> getContactList(@PathVariable("userId") Long userId) {
        return contactService.getAllContacts(userId);
    }

    @PostMapping("/add")
    public Contact addContact(@RequestBody Contact contact) {
        contactService.createContact(contact);
        return contact;
    }

    @DeleteMapping("/deleteById/{cId}")
    public void deleteById(@PathVariable Long cId) {
        contactService.deleteContact(cId);
    }
}
