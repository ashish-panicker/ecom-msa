package com.example.inventory.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String productNotFound) {
        super(productNotFound);
    }
}
