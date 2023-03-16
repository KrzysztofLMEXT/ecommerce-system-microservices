package com.ecommerce.microservices.dto;

import com.ecommerce.microservices.valueobject.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CreateOrderResponse {
    private final UUID parcelId;
    private final OrderStatus orderStatus;
}
