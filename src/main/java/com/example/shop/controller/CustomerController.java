package com.example.shop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import com.example.shop.entity.*;
import com.example.shop.repository.*;
@RestController @RequestMapping("/customers")
public class CustomerController {
    @Autowired private CustomerRepository customerRepository;

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
}
