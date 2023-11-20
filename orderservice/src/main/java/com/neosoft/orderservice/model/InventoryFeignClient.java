package com.neosoft.orderservice.model;

import com.neosoft.orderservice.dto.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "inventory-service", url = "http://localhost:8090")
public interface InventoryFeignClient {

    @GetMapping("/api/inventory")
    List<InventoryResponse> checkInventory(@RequestParam List<String> skuCode);
}
