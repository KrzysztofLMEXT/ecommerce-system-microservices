package com.ecommerce.microservices.mapper;

import com.ecommerce.microservices.entity.OrderEntity;
import com.ecommerce.microservices.entity.OrderItemEntity;
import com.ecommerce.microservices.model.Order;
import com.ecommerce.microservices.model.OrderItem;
import com.ecommerce.microservices.valueobject.Money;
import com.ecommerce.microservices.valueobject.OrderId;
import com.ecommerce.microservices.valueobject.OrderItemId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderDataAccessMapper {
    public Order orderEntityToOrder(OrderEntity order){
        return Order.builder()
                .price(new Money(order.getPrice()))
                .orderNumber(order.getOrderNumber())
                .orderStatus(order.getOrderStatus())
                .parcelId(order.getParcelId())
                .items(orderEntityItemToOrderItem(order.getOrderItemEntityList()))
                .build();
    }
    private List<OrderItem> orderEntityItemToOrderItem(List<OrderItemEntity> orderItemEntities) {
        return orderItemEntities.stream()
                .map(orderItem -> OrderItem.builder()
                        .orderItemId(new OrderItemId(orderItem.getId()))
                        .price(new Money(orderItem.getPrice()))
                        .quantity(orderItem.getQuantity())
                        .build())
                .collect(Collectors.toList());
    }

    public OrderEntity orderToOrderEntity(Order order){
        OrderEntity orderEntity = OrderEntity.builder()
                .id(order.getId().getId())
                .price(order.getPrice().getAmount())
                .orderNumber(order.getOrderNumber())
                .orderStatus(order.getOrderStatus())
                .parcelId(order.getParcelId())
                .orderItemEntityList(orderItemToOrderItemEntity(order.getItems()))
                .build();
        orderEntity.getOrderItemEntityList().forEach(orderItemEntity -> orderItemEntity.setOrder(orderEntity));
        return orderEntity;
    }

    private List<OrderItemEntity> orderItemToOrderItemEntity(List<OrderItem> items) {
        return items.stream().map(
                        orderItem -> OrderItemEntity.builder()
                                .id(orderItem.getOrderItemId().getId())
                                .price(orderItem.getPrice().getAmount())
                                .quantity(orderItem.getQuantity())
                                .build())
                .collect(Collectors.toList());
    }

    public List<Order> orderEntityListToOrderList(List<OrderEntity> items) {
        return items.stream().map(order -> Order.builder()
                .id(new OrderId(order.getId()))
                .price(new Money(order.getPrice()))
                .orderNumber(order.getOrderNumber())
                .orderStatus(order.getOrderStatus())
                .parcelId(order.getParcelId())
                .items(orderEntityItemToOrderItem(order.getOrderItemEntityList()))
                .build()
        ).collect(Collectors.toList());
    }
}
