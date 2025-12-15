package com.culinarycoordinator.orders.controller;

import com.culinarycoordinator.orders.common.StandardResponse;
import com.culinarycoordinator.orders.dto.CreateOrderRequest;
import com.culinarycoordinator.orders.dto.OrderResponse;
import com.culinarycoordinator.orders.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public StandardResponse<OrderResponse> create(
            @RequestBody @Valid CreateOrderRequest request) {

        return StandardResponse.success(
                "Order created successfully",
                service.create(request)
        );
    }

    @GetMapping("/{id}")
    public StandardResponse<OrderResponse> get(@PathVariable Long id) {
        return StandardResponse.success(
                "Order fetched successfully",
                service.getById(id)
        );
    }
}
