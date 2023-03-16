package com.ecommerce.microservices.adapter;

import com.ecommerce.microservices.entity.OrderEntity;
import com.ecommerce.microservices.model.Order;
import com.ecommerce.microservices.ports.OrderPersist;
import com.ecommerce.microservices.mapper.OrderDataAccessMapper;
import com.ecommerce.microservices.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderPersistImpl implements OrderPersist {
    private final OrderRepository orderRepository;
    private final OrderDataAccessMapper orderDataAccessMapper;

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = orderRepository.save(
                orderDataAccessMapper.orderToOrderEntity(order)
        );
        return orderDataAccessMapper.orderEntityToOrder(orderEntity);
    }

    @Override
    public List<Order> findAll() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        return orderDataAccessMapper.orderEntityListToOrderList(orderEntities);
    }
}
