package com.example.productservice.controller;

import com.example.productservice.entity.Product;
import com.example.productservice.repo.ProductRepo;
import com.example.productservice.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class ProductController {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping("/shopproducts/greet")
    public String hello() {
        return "hey shubham here";
    }
    private static final Map<String, List<Product>> productDatabase;//need to initialized first

    static {//to initialized static variable
        productDatabase = new HashMap<>();

        List<Product> products = new ArrayList<>();
        Product tomato = new Product(1, "tomato", 3, 120);
        products.add(tomato);
        Product onion = new Product(2, "onion", 2, 30);
        products.add(onion);
        productDatabase.put("supershop", products);

        List<Product> products1 = new ArrayList<>();
        Product lemon = new Product(3, "lemon", 1, 100);
        products1.add(lemon);
        Product flower = new Product(4, "flower", 2, 130);
        products1.add(flower);

        productDatabase.put("dmart", products1);

    }

    @RequestMapping(value = "/shopproducts/{shopName}", method = RequestMethod.GET)
    public List<Product> getProductPerShop(@PathVariable("shopName") String shopName) {
        List<Product> products = productDatabase.get(shopName);
        if (products == null) {
            products = new ArrayList<>();
            Product product = new Product(1, "no product", 0, 0);
            products.add(product);
        }
        return products;
    }
//we declare a static map of products in the static block. This will act as our database layer.

    @GetMapping("/shopproducts/list")
    private APIResponse<List<Product>> getProducts() {
        List<Product> allProducts = productServiceImpl.findAllProducts();
        return new APIResponse(allProducts.size(), allProducts);
    }

    @GetMapping("/shopproducts/pagination/{offset}/{pageSize}")
    private APIResponse<Page<Product>> getProductsWithSort(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Product> productsWithPagination = productServiceImpl.findProductsWithPagination(offset, pageSize);
        return new APIResponse(productsWithPagination.getSize(), productsWithPagination);
    }

    @PostMapping("/shopproducts/add")
    public Product addProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @PutMapping("/shopproducts/updateById/{id}")
    public Product updateProduct(@RequestBody Product product1, @PathVariable int id) throws ClassNotFoundException {
        if (product1 == null) {
            throw new ClassNotFoundException("product not found");
        }
        Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Does not exist"));
        product.setId(product.getId());
        product.setName(product.getName());
        product.setQuantity(product.getQuantity());
        product.setPrice(product.getPrice());
        productRepo.save(product);
        return product;
    }

    @DeleteMapping("/shopproducts/deleteById/{id}")
    public void deleteProduct(@PathVariable int id) {
        Product product = productRepo.findById(id).orElseThrow();
        productRepo.delete(product);
    }
}
