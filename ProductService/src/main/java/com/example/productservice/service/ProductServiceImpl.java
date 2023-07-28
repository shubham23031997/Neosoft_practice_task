package com.example.productservice.service;

import com.example.productservice.entity.Product;
import com.example.productservice.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo repo;

    /*  @PostConstruct
      //Spring calls the methods annotated with @PostConstruct only once, just after the initialization of bean properties
      public void initDB() {
          List<Product> products = IntStream.rangeClosed(1, 200)
                  .mapToObj(i -> new Product("product" + i, new Random().nextInt(100), new Random().nextInt(5000)))
                  .collect(Collectors.toList());
          repo.saveAll(products);
      }
  */
    public List<Product> findAllProducts() {
        return repo.findAll();
    }

    public Page<Product> findProductsWithPagination(int offset, int pagesize) {
        Page<Product> products = repo.findAll(PageRequest.of(offset, pagesize));
        return products;
    }

    public Product updatePerson(@RequestBody Product product1, @PathVariable int id) {

        Product product = repo.findById(product1.id).orElseThrow(() -> new RuntimeException("Does not exist"));
        product.setId(product1.getId());
        product.setName(product1.getName());
        product.setQuantity(product1.getQuantity());
        product.setPrice(product1.getPrice());
        repo.save(product);
        return product;
    }

}
