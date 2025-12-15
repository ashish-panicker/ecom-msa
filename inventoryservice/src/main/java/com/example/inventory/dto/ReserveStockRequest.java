package com.example.inventory.dto;

public record ReserveStockRequest(
        String productCode,
        int quantity
) {}

