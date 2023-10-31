package com.neosoft.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Document(value = "Product Service")
//@Document(collection = "Product Service")
@Builder
@Data
public class Product {
    @Id
    public String id;
    public String name;
    public String description;
    private BigDecimal price;
}
