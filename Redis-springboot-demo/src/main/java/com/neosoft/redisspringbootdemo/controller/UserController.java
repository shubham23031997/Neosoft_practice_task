package com.neosoft.redisspringbootdemo.controller;

import com.neosoft.redisspringbootdemo.model.User;
import com.neosoft.redisspringbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        boolean result = userService.saveUser(user);
        if (result)
            return ResponseEntity.ok("User Created Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> fetchAllUser() {
        List<User> users;
        users = userService.fetchAllUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{id}")
    @Cacheable(key = "#id",value = "USER",unless = "#result.age<11")
    //if (age<11) condition is true then it won't be cacheable
    public User fetchUserById(@PathVariable ("id") Long id) {
        User user;
        user = userService.fetchUserById(id);
        return user;
        //return ResponseEntity.ok(user);
    }

    @DeleteMapping("user/{id}")
    @CacheEvict(key = "#id",value = "USER")
    //without cacheEvict if we delete any record then it can't be deleted from cache
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        boolean result = userService.deleteUser(id);
        if (result)
            return ResponseEntity.ok("User deleted Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
