package com.example.shopservice.controller;

import com.example.shopservice.service.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@AllArgsConstructor
public class ShopController {
    @Autowired
    ShopService shopService;
    @Autowired
    private RestTemplate template;
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/getshopdetails/accessapi", method = RequestMethod.GET)
//    @GetMapping("/accessapi")
    public String invokeGreetingService() {
        URI uri = discoveryClient.getInstances("product-service").stream().map(si -> si.getUri()).findFirst()
                .map(s -> s.resolve("/greet")).get();
        return template.getForObject(uri, String.class);
    }

    @RequestMapping(value = "/getshopdetails/{shopName}", method = RequestMethod.GET)
    public String getProducts(@PathVariable("shopName") String shopName) {
        return shopService.getDataFromProductService(shopName);
    }
}
