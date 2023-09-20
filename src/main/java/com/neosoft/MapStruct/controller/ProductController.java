package com.neosoft.MapStruct.controller;

import com.neosoft.MapStruct.dto.ProductDto;
import com.neosoft.MapStruct.mapper.ProductMapper;
import com.neosoft.MapStruct.model.Product;
import com.neosoft.MapStruct.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductRepo productRepository;

    @PostMapping("/products")
    public ResponseEntity<Product> create(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productRepository.save(
                productMapper.dtoToModel(productDto)), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> findAll() {
        return new ResponseEntity<>(productMapper.modelsToDtos(productRepository.findAll()), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(productMapper.modelToDto(
                productRepository.findById(id).get()), HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") int id) {
        ProductDto productDto = productMapper.modelToDto(productRepository.findById(id).get());
        productRepository.deleteById(productDto.getId());
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}