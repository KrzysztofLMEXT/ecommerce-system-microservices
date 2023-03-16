package com.ecommerce.microservices.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "inventory")
public class InventoryEntity {
    @Id
    private Long id;
    private String skuCode;
    private Long quantity;

}
