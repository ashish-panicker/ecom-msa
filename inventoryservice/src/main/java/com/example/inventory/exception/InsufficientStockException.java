package com.example.inventory.exception;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String insufficientStock) {
        super(insufficientStock);
    }
}
