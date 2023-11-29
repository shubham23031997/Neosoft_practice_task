package com.neosoft.redisspringbootdemo.repository;

import com.neosoft.redisspringbootdemo.model.User;

import java.util.List;

//@Repository
public interface UserDao {
    boolean saveUser(User user);

    List<User> fetchAllUser();

    User fetchUserById( Long id);

    boolean deleteUserById(Long id);
}
