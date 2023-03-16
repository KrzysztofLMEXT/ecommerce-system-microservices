package com.ecommerce.microservices.model;

import com.ecommerce.microservices.exception.OrderDomainException;
import com.ecommerce.microservices.valueobject.Money;
import com.ecommerce.microservices.valueobject.OrderId;
import com.ecommerce.microservices.valueobject.OrderItemId;
import com.ecommerce.microservices.valueobject.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
public class Order extends AggregateRoot<OrderId>{
    private final String orderNumber;
    private UUID parcelId;
    private final Money price;
    private OrderStatus orderStatus;
    private final List<OrderItem> items;

    public void initializeOrder() {
        OrderId orderId = new OrderId(UUID.randomUUID());
        setId(orderId);
        initializeItems(orderId);
        parcelId = UUID.randomUUID();
        orderStatus = OrderStatus.PENDING;
    }

    private void initializeItems(OrderId orderId) {
        long itemId = 1;
        for (OrderItem orderItem : items) {
            orderItem.setOrderId(orderId);
            orderItem.setOrderItemId(new OrderItemId(itemId++));
        }
    }

    public void validateOrder() {
        validateInitialOrder();
        validateTotalPrice();
        validateItemsPrice();
    }

    private void validateItemsPrice() {

    }

    private void validateTotalPrice() {

    }

    private void validateInitialOrder() {
        if (orderStatus != null) {
            throw new OrderDomainException("Order is not in correct state");
        }
    }

    public void pay() {
        if (orderStatus != OrderStatus.PENDING) {
            throw new OrderDomainException("Order is not in correct state for pay operation");
        }
        orderStatus = OrderStatus.PAID;
    }
}
