package com.example.shopservice.serviceimpl;


import com.example.shopservice.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    public RestTemplate template;

    @Autowired
    private DiscoveryClient discoveryClient;

    public String getDataFromProductService(String shopName) {
        String response = template.exchange("http://product-service/shopproducts/{shopName}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
                }, shopName).getBody();

        System.out.println("Received " + response + " -  ");

        return "Shop Name -  " + shopName + " :::  Product details " + "-" + response;

    }


}
