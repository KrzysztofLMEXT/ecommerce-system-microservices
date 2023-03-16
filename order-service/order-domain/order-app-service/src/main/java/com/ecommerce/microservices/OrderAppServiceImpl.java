package com.ecommerce.microservices;

import com.ecommerce.microservices.dto.CreateOrderCommand;
import com.ecommerce.microservices.dto.CreateOrderResponse;
import com.ecommerce.microservices.dto.OrderResponse;
import com.ecommerce.microservices.exception.OrderDomainException;
import com.ecommerce.microservices.mapper.OrderDataMapper;
import com.ecommerce.microservices.model.Order;
import com.ecommerce.microservices.ports.OrderAppService;
import com.ecommerce.microservices.ports.OrderPersist;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class OrderAppServiceImpl implements OrderAppService {

    private final OrderPersist orderPersist;
    private final OrderDomainService orderDomainService;
    private final OrderDataMapper orderDataMapper;

    @Override
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
        orderDomainService.initializeOrder(order);
        Order result = orderPersist.save(order);
        if(Objects.isNull(result)){
            throw new OrderDomainException("Could not save order");
        }
        return new CreateOrderResponse(order.getParcelId(), order.getOrderStatus());
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderPersist.findAll();
        return orderDataMapper.orderToOrderResponse(orders);
    }
}
