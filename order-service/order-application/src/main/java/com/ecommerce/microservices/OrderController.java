package com.ecommerce.microservices;

import com.ecommerce.microservices.dto.CreateOrderCommand;
import com.ecommerce.microservices.dto.CreateOrderResponse;
import com.ecommerce.microservices.dto.OrderItemCommand;
import com.ecommerce.microservices.dto.OrderResponse;
import com.ecommerce.microservices.mapper.OrderDataMapper;
import com.ecommerce.microservices.model.Order;
import com.ecommerce.microservices.ports.OrderAppService;
import com.ecommerce.microservices.valueobject.OrderId;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderAppService orderAppService;
    private final OrderDataMapper orderDataMapper;

    @PostMapping
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderCommand createOrderCommand){
        CreateOrderResponse response = orderAppService.createOrder(createOrderCommand);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders(){

        UUID productId = UUID.fromString("d215b5f8-0249-4dc5-89a3-51fd148cfb48");
        UUID ORDER_ID = UUID.fromString("15a497c1-0f4b-4eff-b9f4-c402c8c07afb");

        CreateOrderCommand createOrderCommand = CreateOrderCommand.builder()
                .price(new BigDecimal(324))
                .items(List.of(OrderItemCommand.builder()
                        .productId(productId)
                        .quantity(55)
                        .price(new BigDecimal(33))
                        .build()
                )).build();

        Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
        order.setId(new OrderId(ORDER_ID));
        orderAppService.createOrder(createOrderCommand);

        return ResponseEntity.ok(orderAppService.getAllOrders());
    }
}
