package com.neosoft.multithreading_executor_service.repo;

import com.neosoft.multithreading_executor_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
