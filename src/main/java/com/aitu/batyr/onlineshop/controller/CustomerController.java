package com.aitu.batyr.onlineshop.controller;

import com.aitu.batyr.onlineshop.ResourceNotFoundException;
import com.aitu.batyr.onlineshop.model.Customer;
import com.aitu.batyr.onlineshop.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable Long id) {
        return customerService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + id));
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.update(id, customer);
    }

    //    error 204 no content
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Customer> create (@RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(customer));
    }
}
