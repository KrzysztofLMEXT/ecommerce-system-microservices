package com.ecommerce.microservices.mapper;
import com.ecommerce.microservices.dto.CreateOrderCommand;
import com.ecommerce.microservices.dto.OrderItemCommand;
import com.ecommerce.microservices.dto.OrderResponse;
import com.ecommerce.microservices.model.Order;
import com.ecommerce.microservices.model.OrderItem;
import com.ecommerce.microservices.valueobject.Money;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderDataMapper {
    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand) {
        return Order.builder()
                .price(new Money(createOrderCommand.getPrice()))
                .items(orderItemCommandToOrderItemEntities(createOrderCommand.getItems()))
                .build();
    }

    private List<OrderItem> orderItemCommandToOrderItemEntities(List<OrderItemCommand> items) {
        return items.stream()
                .map(orderItem -> OrderItem.builder()
                        .quantity(orderItem.getQuantity())
                        .productId(orderItem.getProductId())
                        .price(new Money(orderItem.getPrice()))
                        .build()
                ).collect(Collectors.toList());
    }

    private List<OrderItem> orderItemCommandToOrderItem(List<OrderItemCommand> items) {
        return items.stream()
                .map(item -> OrderItem.builder()
                        .quantity(item.getQuantity())
                        .productId(item.getProductId())
                        .price(new Money(item.getPrice()))
                        .build()
                ).collect(Collectors.toList());
    }

    public List<OrderResponse> orderToOrderResponse(List<Order> orders) {
        return orders.stream()
                .map(item -> OrderResponse.builder()
                        .id(item.getId().getId())
                        .parcelId(item.getParcelId())
                        .price(item.getPrice().getAmount())
                        .orderItems(item.getItems())
                        .build()
                ).collect(Collectors.toList());
    }
}
