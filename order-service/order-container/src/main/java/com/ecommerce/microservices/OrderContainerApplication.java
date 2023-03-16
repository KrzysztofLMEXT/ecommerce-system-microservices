package com.ecommerce.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderContainerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderContainerApplication.class, args);
    }
    @Bean
    public OrderDomainService orderDomainService(){
        return new OrderDomainServiceImpl();
    }
}
