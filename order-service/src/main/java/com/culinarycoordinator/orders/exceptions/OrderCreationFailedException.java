package com.culinarycoordinator.orders.exceptions;

public class OrderCreationFailedException extends RuntimeException {
    public OrderCreationFailedException(String message) {
        super(message);
    }
}
