package com.contact.repo;

import com.contact.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {
    @Override
    Optional<Contact> findById(Long userId);
}
