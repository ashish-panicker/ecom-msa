package com.culinarycoordinator.orders.dto;

import java.math.BigDecimal;

public record CreateOrderRequest(
        Long customerId,
        BigDecimal totalAmount
) {}
