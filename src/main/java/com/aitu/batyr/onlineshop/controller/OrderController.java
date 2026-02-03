package com.aitu.batyr.onlineshop.controller;

import com.aitu.batyr.onlineshop.model.Order;
import com.aitu.batyr.onlineshop.repository.OrderRepository;
import com.aitu.batyr.onlineshop.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public OrderController(OrderService orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) {
        return orderService.getById(id)
                .orElseThrow(() -> new RuntimeException("Order not found: " + id));
    }

    @PostMapping
    public Order create(@RequestParam Long customerId,
                        @RequestBody Order order) {
        return orderService.create(customerId, order);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id,
                        @RequestParam(required = false) Long customerId,
                        @RequestBody Order order) {
        return orderService.update(id, customerId, order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getOrderByCustomer(@PathVariable Long customerId){
        return orderService.findByCustomerId(customerId);
    }
}
