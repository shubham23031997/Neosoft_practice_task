package com.example.twodbconnection.mysql.service;

import com.example.twodbconnection.mysql.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    Optional<User> findUserById(Integer id);

    User createUser(User user);

    User updateUser(Integer id, User user);

    void deleteUser(Integer id);
}
