package com.ecommerce.microservices;

import com.ecommerce.microservices.model.Order;

public class OrderDomainServiceImpl implements OrderDomainService {
    @Override
    public void initializeOrder(Order order) {
        order.validateOrder();
        order.initializeOrder();

    }

    @Override
    public void payOrder(Order order) {
        order.pay();
    }

    @Override
    public void approveOrder(Order order) {

    }

    @Override
    public void cancelOrder(Order order) {

    }
}
