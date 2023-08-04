package com.example.twodbconnection.postgres.controller;

import com.example.twodbconnection.postgres.entity.Product;
import com.example.twodbconnection.postgres.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("msg")
    public String check() {
        return "working";
    }

    @GetMapping(value = "/getAll")
    public List<Product> getProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/getProduct/{id}")
    public Optional<Product> getUserById(@PathVariable int id) {
        return productService.findProductById(id);
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id) {
        Product product = productService.findProductById(id).orElseThrow();
        productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product updateProduct = productService.updateProduct(id, product);
        if (updateProduct != null) {
            return new ResponseEntity<>(updateProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}