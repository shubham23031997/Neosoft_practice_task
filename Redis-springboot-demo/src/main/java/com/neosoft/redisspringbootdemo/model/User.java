package com.neosoft.redisspringbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("USER")

public class User implements Serializable {
    private static final long serialVersionUID = 4086282684332646436L;

    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private int age;
}
