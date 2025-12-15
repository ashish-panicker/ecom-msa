package com.example.inventory.controller;

import com.example.inventory.common.StandardResponse;
import com.example.inventory.dto.CreateInventoryRequest;
import com.example.inventory.dto.InventoryResponse;
import com.example.inventory.dto.ReserveStockRequest;
import com.example.inventory.service.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
@Tag(name = "Inventory", description = "Inventory management api.")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create an inventory.", description = "Creates new inventory for the products.")
    public StandardResponse<InventoryResponse> create(
            @RequestBody CreateInventoryRequest request) {

        return StandardResponse.success(
                "Inventory created",
                service.create(request)
        );
    }

    @PostMapping("/reserve")
    @Operation(summary = "Reserve inventory", description = "Reserves the requested inventory of product.")
    public StandardResponse<InventoryResponse> reserve(
            @RequestBody ReserveStockRequest request) {

        return StandardResponse.success(
                "Stock reserved",
                service.reserve(request)
        );
    }
}
