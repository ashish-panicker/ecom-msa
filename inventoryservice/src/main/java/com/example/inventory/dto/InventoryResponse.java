package com.example.inventory.dto;

public record InventoryResponse(
        String productCode,
        int availableQuantity,
        int reservedQuantity,
        String status
) {}
