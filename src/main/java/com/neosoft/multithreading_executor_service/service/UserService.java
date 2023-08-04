package com.neosoft.multithreading_executor_service.service;

import com.neosoft.multithreading_executor_service.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface UserService {
    public CompletableFuture<List<User>> saveUsers(MultipartFile file) throws Exception;

    public CompletableFuture<List<User>> findAllUsers();

}
