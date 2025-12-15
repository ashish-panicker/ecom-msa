package com.culinarycoordinator.orders.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String orderNotFound) {
        super(orderNotFound);
    }
}
