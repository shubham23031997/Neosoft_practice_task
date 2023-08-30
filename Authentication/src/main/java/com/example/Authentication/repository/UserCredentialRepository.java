package com.example.Authentication.repository;

import com.example.Authentication.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredential, Integer> {
    Optional<UserCredential> findByName(String username);
    //this method is used for loadUserByUsername method present in CustomUserDetailsService

//    @Query("select u from user_credential u where u.name= : name")
//    public UserCredential getUserCredentialByName(@Param("name") String name);
}
