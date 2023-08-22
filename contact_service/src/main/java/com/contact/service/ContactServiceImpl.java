package com.contact.service;

import com.contact.entity.Contact;
import com.contact.repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepo contactRepo;
    @Override
    public List<Contact> getAllContacts(Long userId) {
        List<Contact> all = contactRepo.findAll();
        List<Contact> newContacts = new ArrayList<>();
        all.forEach(contact -> {
            if (Objects.equals(contact.getUserId(), userId)) {
                newContacts.add(contact);
            }
        });
        return newContacts;
    }

    @Override
    public Contact createContact(Contact contact) {
        return contactRepo.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepo.deleteById(id);
    }
}
