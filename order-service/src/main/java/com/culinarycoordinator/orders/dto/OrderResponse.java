package com.culinarycoordinator.orders.dto;

import java.math.BigDecimal;

public record OrderResponse(
        String orderNumber,
        Long customerId,
        String status,
        BigDecimal totalAmount
) {}

