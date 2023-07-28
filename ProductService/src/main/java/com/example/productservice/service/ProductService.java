package com.example.productservice.service;

import com.example.productservice.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductService {
    public Page<Product> findProductsWithPagination(int offset, int pagesize);
    public Product updatePerson(@RequestBody Product product1, @PathVariable int id);
    public List<Product> findAllProducts();
}
