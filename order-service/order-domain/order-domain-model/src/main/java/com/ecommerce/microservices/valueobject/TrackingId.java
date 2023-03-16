package com.ecommerce.microservices.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class TrackingId {
    private final UUID id;
}
