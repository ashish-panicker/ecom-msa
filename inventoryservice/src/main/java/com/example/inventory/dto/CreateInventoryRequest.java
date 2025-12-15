package com.example.inventory.dto;

public record CreateInventoryRequest(
        String productCode,
        int quantity
) {}
