package com.neosoft.inventoryservice.controller;

import com.neosoft.inventoryservice.dto.InventoryResponse;
import com.neosoft.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
//http://localhost:8082/api/inventory/iphone13

    //    @GetMapping("/{sku-code}")...@PathVariable("sku-code")
    //http://localhost:8082/api/inventory?sku-code=iphone13 & sku-code=one plus
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
        return inventoryService.isInStock(skuCode);
    }
}
