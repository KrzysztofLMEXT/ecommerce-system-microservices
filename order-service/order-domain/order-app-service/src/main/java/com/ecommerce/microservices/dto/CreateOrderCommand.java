package com.ecommerce.microservices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class CreateOrderCommand {
    private BigDecimal price;
    private final List<OrderItemCommand> items;
}
