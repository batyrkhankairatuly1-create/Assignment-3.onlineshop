package com.aitu.batyr.onlineshop.service;

import com.aitu.batyr.onlineshop.model.Customer;
import com.aitu.batyr.onlineshop.model.Order;
import com.aitu.batyr.onlineshop.repository.CustomerRepository;
import com.aitu.batyr.onlineshop.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderService(OrderRepository orderRepository,
                        CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> getById(Long id) {
        return orderRepository.findById(id);
    }

    public Order create(Long customerId, Order order) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found: " + customerId));
        order.setCustomer(customer);
        return orderRepository.save(order);
    }

    public Order update(Long id, Long customerId, Order updated) {
        return orderRepository.findById(id)
                .map(existing -> {
                    existing.setOrderDate(updated.getOrderDate());
                    existing.setTotalPrice(updated.getTotalPrice());
                    if (customerId != null) {
                        Customer customer = customerRepository.findById(customerId)
                                .orElseThrow(() -> new RuntimeException("Customer not found: " + customerId));
                        existing.setCustomer(customer);
                    }
                    return orderRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Order not found: " + id));
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
