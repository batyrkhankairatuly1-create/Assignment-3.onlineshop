package com.aitu.batyr.onlineshop.controller;

import com.aitu.batyr.onlineshop.model.Customer;
import com.aitu.batyr.onlineshop.model.Item;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/hello")
    public String printMessage() {
        return "Hello World from DemoController";
    }

    @GetMapping("/item")
    public Item getSampleItem() {
        return new Item("Demo Item", 1000.0, 5);
    }

    @GetMapping("/customer")
    public Customer getSampleCustomer() {
        return new Customer(
                "Serik",
                "Akhmetov",
                "serik@example.com",
                "Astana",
                "+77010000000"
        );
    }

    @PostMapping("/echo_customer")
    public Customer echoCustomer(@RequestBody Customer customer) {
        return customer;
    }
}
