package com.neosoft.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

@Data
public class OrderRequest {
   private List<OrderLineItemsDto> orderLineItemsDtosList;

}
