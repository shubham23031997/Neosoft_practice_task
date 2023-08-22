package com.user.service;

import com.user.entity.User;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserService {

    User getUser(Long id);
    User createUser(@PathVariable User user);
}
