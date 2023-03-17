package com.ecommerce.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ecommerce.microservices")
@EntityScan(basePackages = "com.ecommerce.microservices")
public class PaymentContainerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentContainerApplication.class, args);
    }
}
