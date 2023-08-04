package com.example.twodbconnection.postgres.repo;

import com.example.twodbconnection.postgres.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    Product findByName(String title);
}
