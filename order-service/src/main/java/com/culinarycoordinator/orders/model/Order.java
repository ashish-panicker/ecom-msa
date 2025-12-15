package com.culinarycoordinator.orders.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Table(name = "orders")
@Getter
@Builder
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String orderNumber;

    @Column(nullable = false)
    private Long customerId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(nullable = false)
    private BigDecimal totalAmount;

    public  Order() {
    }

    public Order(String orderNumber, Long customerId, BigDecimal totalAmount) {
        this.orderNumber = orderNumber;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.status = OrderStatus.CREATED;
    }

    public void markConfirmed() {
        this.status = OrderStatus.CONFIRMED;
    }

}

