package com.ecommerce.microservices.dto;

import com.ecommerce.microservices.model.OrderItem;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class OrderResponse {
    private UUID id;
    private final UUID parcelId;
    private final BigDecimal price;
    private final List<OrderItem> orderItems;
}
