package com.neosoft.multithreading_executor_service.service.serviceimpl;

import com.neosoft.multithreading_executor_service.entity.User;
import com.neosoft.multithreading_executor_service.repo.UserRepo;
import com.neosoft.multithreading_executor_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UserServiceImpl implements UserService {

    Object target;
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepo userRepo;

    //method who read csv file and make it as object to persistent db after parsing csv
    @Async // for Asynchronous call
    //CompletableFuture is used for asynchronous programming.A.P.means writing non-blocking code.
    public CompletableFuture<List<User>> saveUsers(MultipartFile file) throws Exception {
        long start = System.currentTimeMillis();
        List<User> users = parseCSVFile(file);
        // here printing size and name of thread who doing this job
        logger.info("saving list of users of size {}", users.size(), "" + Thread.currentThread().getName());
        users = userRepo.saveAll(users);
        long end = System.currentTimeMillis();
        logger.info("Total time {}", (end - start));
        return CompletableFuture.completedFuture(users);
    }

    //to fetch list of  user object from db
    @Async
    public CompletableFuture<List<User>> findAllUsers() {
        logger.info("get list of user by " + Thread.currentThread().getName());
        List<User> users = userRepo.findAll();
        return CompletableFuture.completedFuture(users);
    }

    //this is method use to parse csv file
    private List<User> parseCSVFile(final MultipartFile multipartFile) throws Exception {
        final List<User> users = new ArrayList<>();
        try {
            try (final BufferedReader br = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()))) {
                //using BufferReader we are reading until it is null
                String line;
                while ((line = br.readLine()) != null) {
                    final String[] data = line.split(",");
//                    csv spliter her is ,
                    final User user = new User();
                    user.setName(data[0]);
                    user.setEmail(data[1]);
                    user.setGender(data[2]);
                    users.add(user);
                }
                return users;
            }
        } catch (final IOException e) {
            logger.error("Failed to parse CSV file {}", e);
            throw new Exception("Failed to parse CSV file {}", e);
        }
    }
}