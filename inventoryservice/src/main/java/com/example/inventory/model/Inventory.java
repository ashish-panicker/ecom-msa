package com.example.inventory.model;

import com.example.inventory.exception.InsufficientStockException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "inventory")
@Getter
@AllArgsConstructor
@Builder
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String productCode;

    private int availableQuantity;

    private int reservedQuantity;

    @Enumerated(EnumType.STRING)
    private InventoryStatus status;

    protected Inventory() {
    }

    public Inventory(String productCode, int quantity) {
        this.productCode = productCode;
        this.availableQuantity = quantity;
        this.reservedQuantity = 0;
        this.status = InventoryStatus.ACTIVE;
    }

    public void reserve(int quantity) {
        if (availableQuantity < quantity) {
            throw new InsufficientStockException("Insufficient stock");
        }
        availableQuantity -= quantity;
        reservedQuantity += quantity;
        recalcStatus();
    }

    public void release(int quantity) {
        reservedQuantity -= quantity;
        availableQuantity += quantity;
        recalcStatus();
    }

    private void recalcStatus() {
        this.status = availableQuantity == 0
                ? InventoryStatus.OUT_OF_STOCK
                : InventoryStatus.ACTIVE;
    }

}
