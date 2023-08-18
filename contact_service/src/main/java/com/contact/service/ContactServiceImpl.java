package com.contact.service;

import com.contact.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    //fake list of contacts

    List<Contact> list = List.of(
            new Contact(1L, "anuj@gmail.com", "anuj", 1311L),
            new Contact(2L, "yusuf@gmail.com", "yusuf", 1311L),
            new Contact(3L, "siddhesh@gmail.com", "siddhesh", 1312L),
            new Contact(4L, "sameer@gmail.com", "Sameer", 1312L),
            new Contact(5L, "lokesh@gmail.com", "lokesh", 1313L),
            new Contact(6L, "shubham@gmail.com", "shubham", 1313L),
            new Contact(7L, "sai@gmail.com", "sai", 1314L),
            new Contact(8L, "amar@gmail.com", "amar", 1314L),
            new Contact(9L, "nikhil@gmail.com", "nikhil", 1315L),
            new Contact(10L, "anchal@gmail.com", "anchal", 1315L),
            new Contact(11L, "kajal@gmail.com", "kajal", 1316L)
    );


    @Override
    public List<Contact> getContactsOfUser(Long userId) {
        return list.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
