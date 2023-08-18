package com.user.service;

import com.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    //fake user list

    List<User> list = List.of(
            new User(1311L, "haresh", "23525625"),
            new User(1312L, "pranit", "99999"),
            new User(1313L, "pritesh", "88888"),
            new User(1314L, "tejas", "777777"),
            new User(1315L, "kunal", "909090"),
            new User(1316L, "susmit", "868686")
    );

    @Override
    public User getUser(Long id) {
        return list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
    }
}
