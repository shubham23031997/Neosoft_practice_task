package com.user.service;

import com.user.entity.Contact;
import com.user.entity.User;

import java.util.List;

public interface UserService {

    User getUser(Long id);

    List<Contact> getContactsFromContactService(Long userId);

}
