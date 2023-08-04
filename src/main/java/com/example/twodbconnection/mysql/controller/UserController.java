package com.example.twodbconnection.mysql.controller;

import com.example.twodbconnection.mysql.entity.User;
import com.example.twodbconnection.mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/getAll")
    public List<User> getUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }

    @PostMapping("/add")
    public User addUSer(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/findName/{id}")
    public String getUserNameById(@PathVariable int id) {
        User user = userService.findUserById(id).orElse(null);
        return user.getUserName();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}