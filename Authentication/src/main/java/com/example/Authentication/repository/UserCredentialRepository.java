package com.example.Authentication.repository;

import com.example.Authentication.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredential, Integer> {
    Optional<UserCredential> findByName(String username);
    //this method is used for loadUserByUsername method present in CustomUserDetailsService
}
