package com.ecommerce.microservices.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Builder
@Table(name = "order_items")
@IdClass(OrderItemEntityId.class)

public class OrderItemEntity {
    @Id
    private Long id;
    private UUID productId;
    private BigDecimal price;
    private Integer quantity;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private OrderEntity order;
}
