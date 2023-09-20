package com.neosoft.MapStruct.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private int id;
    private String name;
    private String price;
    private String quantity;//here we can change datatype from int to string
    private String description;
//    private String itemId;
//    private List<Item> itemsList;
}
