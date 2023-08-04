package com.example.twodbconnection.postgres.service;

import com.example.twodbconnection.postgres.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProduct();

    Optional<Product> findProductById(Integer id);

    Product createProduct(Product product);

    Product updateProduct(Integer id, Product product);

    void deleteProduct(Integer id);

}
