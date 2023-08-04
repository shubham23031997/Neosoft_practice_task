package com.example.twodbconnection.postgres.service.serviceimpl;

import com.example.twodbconnection.postgres.entity.Product;
import com.example.twodbconnection.postgres.repo.ProductRepo;
import com.example.twodbconnection.postgres.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> findProductById(Integer id) {
        Optional<Product> product = productRepo.findById(id);
        return product;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Integer id, Product product) {
        Product updateProduct = productRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("user not exist with id" + id));
        updateProduct.setId(product.getId());
        updateProduct.setName(product.getName());
        updateProduct.setDescription(product.getDescription());
        updateProduct.setPrice(product.getPrice());
        productRepo.save(updateProduct);
        return product;
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepo.deleteById(id);
    }
}
