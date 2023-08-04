package com.example.twodbconnection.mysql.service.serviceimpl;

import com.example.twodbconnection.mysql.entity.User;
import com.example.twodbconnection.mysql.repo.UserRepo;
import com.example.twodbconnection.mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Integer id, User user) {
        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("user not exist with id" + id));
        updateUser.setUserName(user.getUserName());
        updateUser.setEmail(user.getEmail());
        updateUser.setId(user.getId());
        userRepository.save(updateUser);
        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
