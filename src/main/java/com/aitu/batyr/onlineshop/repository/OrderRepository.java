package com.aitu.batyr.onlineshop.repository;

import com.aitu.batyr.onlineshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
