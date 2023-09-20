package com.neosoft.MapStruct.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String price;
    private int quantity;
    private String description;
//    private String desc;
//    private String itemId;
//    private List<Item> items;

}
/*MapStruct is a Java annotation-based code generation library that simplifies
the mapping between Java beans. It helps developers avoid writing boilerplate
code for mapping objects manually, which can be error-prone and time-consuming.
MapStruct generates efficient mapping code at compile time, which results in
better performance compared to reflection-based mapping.*/