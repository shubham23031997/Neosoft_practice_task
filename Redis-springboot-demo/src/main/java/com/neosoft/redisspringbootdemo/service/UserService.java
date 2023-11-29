package com.neosoft.redisspringbootdemo.service;

import com.neosoft.redisspringbootdemo.model.User;

import java.util.List;

//@Service
public interface UserService {
    boolean saveUser(User user);

    List<User> fetchAllUser();

    User fetchUserById(Long id);

    boolean deleteUser(Long id);
}
