package com.neosoft.inventoryservice;

import com.neosoft.inventoryservice.model.Inventory;
import com.neosoft.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean//try to load data at time of application starts
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory=new Inventory();
			inventory.setSkuCode("one plus");
			inventory.setQuantity(100);

			Inventory inventory1=new Inventory();
			inventory1.setSkuCode("oppo");
			inventory1.setQuantity(200);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}
}
