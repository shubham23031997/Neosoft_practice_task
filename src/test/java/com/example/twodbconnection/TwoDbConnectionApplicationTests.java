package com.example.twodbconnection;

import com.example.twodbconnection.mysql.entity.User;
import com.example.twodbconnection.mysql.repo.UserRepo;
import com.example.twodbconnection.postgres.entity.Product;
import com.example.twodbconnection.postgres.repo.ProductRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TwoDbConnectionApplicationTests {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ProductRepo productRepo;

    @Test
    public void dbTest() {
        System.out.println("testing");
        User user = User.builder().UserName("shubham").email("shubham.mali@neosoftmail.com").build();

        Product product = Product.builder().name("tomato").price(140).description("so costly").build();

        productRepo.save(product);
        userRepo.save(user);
        System.out.println("data saved!!");
    }
}
