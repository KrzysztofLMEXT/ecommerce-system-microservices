package com.ecommerce.microservices.ports;

import com.ecommerce.microservices.model.Order;

import java.util.List;

public interface OrderPersist {
    Order save(Order order);
    List<Order> findAll();
}
