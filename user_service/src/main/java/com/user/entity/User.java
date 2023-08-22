package com.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Transient
    List<Contact> contacts;
    @Id
    private Long userId;
    private String name;
    private String phone;

    public User(Long userId, String name, String phone, List<Contact> contacts) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.contacts = contacts;
    }

    public User(Long userId, String name, String phone) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
    }
}
