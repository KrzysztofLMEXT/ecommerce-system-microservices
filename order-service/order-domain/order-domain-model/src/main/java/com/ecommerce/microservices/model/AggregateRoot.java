package com.ecommerce.microservices.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
abstract class AggregateRoot<T> {
    private T id;
}
