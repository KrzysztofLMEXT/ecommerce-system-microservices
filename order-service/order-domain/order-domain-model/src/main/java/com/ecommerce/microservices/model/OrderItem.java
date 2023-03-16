package com.ecommerce.microservices.model;

import com.ecommerce.microservices.valueobject.Money;
import com.ecommerce.microservices.valueobject.OrderId;
import com.ecommerce.microservices.valueobject.OrderItemId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class OrderItem {
    private OrderId orderId;
    private OrderItemId orderItemId;
    private final UUID productId;
    private final Money price;
    private final Integer quantity;

    boolean isPriceValid(){
        return price.validatePrice();
    }
}
