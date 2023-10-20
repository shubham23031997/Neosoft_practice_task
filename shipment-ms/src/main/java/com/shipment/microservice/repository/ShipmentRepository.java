package com.shipment.microservice.repository;

import com.shipment.microservice.entity.Shipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends CrudRepository<Shipment, Long> {

}
