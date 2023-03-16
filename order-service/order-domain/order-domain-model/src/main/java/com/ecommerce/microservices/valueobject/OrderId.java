package com.ecommerce.microservices.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class OrderId {
    private final UUID id;
}
