package com.ecommerce.microservices.ports;

import com.ecommerce.microservices.dto.CreateOrderCommand;
import com.ecommerce.microservices.dto.CreateOrderResponse;
import com.ecommerce.microservices.dto.OrderResponse;

import java.util.List;

public interface OrderAppService {
    CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand);
    List<OrderResponse> getAllOrders();
}
