package com.example.shopservice.entity;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data//@ToString , @EqualsAndHashCode , @Getter / @Setter and @RequiredArgsConstructor together
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class Shop implements Serializable {
    private static final Long serialVersionUID = 1L;
    //@Id
    public int shopId;
    public String shopName;
}
