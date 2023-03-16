package com.ecommerce.microservices.exception;

public class OrderDomainException extends RuntimeException{
    public OrderDomainException(String message){
        super(message);
    }
}
