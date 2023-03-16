package com.ecommerce.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryContainerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryContainerApplication.class, args);
    }

//    @Bean
//    public OrderDomainService orderDomainService(){
//        return new OrderDomainServiceImpl();
//    }
}
