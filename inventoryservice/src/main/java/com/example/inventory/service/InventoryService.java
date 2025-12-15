package com.example.inventory.service;

import com.example.inventory.dto.CreateInventoryRequest;
import com.example.inventory.dto.InventoryResponse;
import com.example.inventory.dto.ReserveStockRequest;
import com.example.inventory.exception.ResourceNotFoundException;
import com.example.inventory.model.Inventory;
import com.example.inventory.repository.InventoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class InventoryService {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public InventoryResponse create(CreateInventoryRequest request) {

        Inventory inventory = new Inventory(
                request.productCode(),
                request.quantity()
        );

        repository.save(inventory);
        return map(inventory);
    }

    public InventoryResponse reserve(ReserveStockRequest request) {

        Inventory inventory = repository.findByProductCode(request.productCode())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        inventory.reserve(request.quantity());

        return map(inventory);
    }

    private InventoryResponse map(Inventory inventory) {
        return new InventoryResponse(
                inventory.getProductCode(),
                inventory.getAvailableQuantity(),
                inventory.getReservedQuantity(),
                inventory.getStatus().name()
        );
    }
}
