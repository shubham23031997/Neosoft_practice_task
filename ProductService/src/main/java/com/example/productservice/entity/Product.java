package com.example.productservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data//@ToString , @EqualsAndHashCode , @Getter / @Setter and @RequiredArgsConstructor together
@Table(name = "product_tbl")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product{
        //implements Serializable {
    // private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;
    public int quantity;
    public long price;

    public Product(String name, int quantity, long price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
