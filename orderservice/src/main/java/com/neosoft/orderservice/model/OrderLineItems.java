package com.neosoft.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_line_items")
@Builder
@Data
@Entity
public class OrderLineItems {
    @Id
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
