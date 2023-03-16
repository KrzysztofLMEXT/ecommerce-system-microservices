package com.ecommerce.microservices;

import com.ecommerce.microservices.model.Order;

public interface OrderDomainService {
    void initializeOrder(Order order);
    void payOrder(Order order);
    void approveOrder(Order order);
    void cancelOrder(Order order);
}
