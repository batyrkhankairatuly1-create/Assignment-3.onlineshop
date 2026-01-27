package com.aitu.batyr.onlineshop.repository;

import com.aitu.batyr.onlineshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
