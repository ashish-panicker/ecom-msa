package com.culinarycoordinator.orders.service;

import com.culinarycoordinator.orders.dto.CreateOrderRequest;
import com.culinarycoordinator.orders.dto.OrderResponse;
import com.culinarycoordinator.orders.exceptions.ResourceNotFoundException;
import com.culinarycoordinator.orders.model.Order;
import com.culinarycoordinator.orders.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    /*
     * @Transactional
     * Manages the transaction using the spring framework
     *
     * Rollback strategies:
     *
     * Automatic rollback for: RuntimeException and Error
     *
     * While using try catch with @Transactional, throw the exception in catch
     * try{
     *  ...
     * }catch (CustomException e) {
     *  log.error();
     *  throw e;
     * }
     *
     * Using org.springframework.transaction.interceptor.TransactionAspectSupport
     * TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
     */
    @Transactional
    public OrderResponse create(CreateOrderRequest request) {
        Order order = new Order(
                UUID.randomUUID().toString(),
                request.customerId(),
                request.totalAmount()
        );
        repository.save(order);
        return map(order);
    }

    @Transactional
    public OrderResponse getById(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        return map(order);
    }

    private OrderResponse map(Order order) {
        return new OrderResponse(
                order.getOrderNumber(),
                order.getCustomerId(),
                order.getStatus().name(),
                order.getTotalAmount()
        );
    }
}

// Self invocation
//class SomeService {
//
//    public void createData() {
//        // repository.save(..);
//    }
//
//    @Transactional
//    public void saveData() throws RuntimeException{
//        createData();
//        throw new RuntimeException("");
//    }
//}
