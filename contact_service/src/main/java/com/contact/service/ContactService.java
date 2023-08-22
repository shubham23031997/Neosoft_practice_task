package com.contact.service;

import com.contact.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts(Long userId);

    Contact createContact(Contact contact);

    void deleteContact(Long id);
}
