package com.neosoft.MapStruct.repo;

import com.neosoft.MapStruct.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
