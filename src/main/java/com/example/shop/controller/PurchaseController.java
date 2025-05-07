package com.example.shop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.example.shop.entity.*;
import com.example.shop.repository.*;

@RestController @RequestMapping("/purchases")
public class PurchaseController {
    @Autowired private PurchaseRepository purchaseRepository;
    @Autowired private CustomerRepository customerRepository;
    @Autowired private ProductRepository productRepository;

    @PostMapping("/buy")
    public Purchase registerPurchase(@RequestBody Map<String, String> body) {
        Long customerId = Long.parseLong(body.get("customerId"));
        Long productId = Long.parseLong(body.get("productId"));
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();
        Purchase purchase = new Purchase();
        purchase.setCustomer(customer);
        purchase.setProduct(product);
        purchase.setPurchaseDate(LocalDate.now());
        return purchaseRepository.save(purchase);
    }

    @GetMapping("/by-customer/{customerId}")
    public List<Purchase> getCustomerPurchases(@PathVariable Long customerId) {
        return purchaseRepository.findByCustomer_Id(customerId);
    }

    @GetMapping("/sorted-by-date")
    public List<Purchase> getSorted(@RequestParam(defaultValue = "asc") String order) {
        return order.equals("desc") ? purchaseRepository.findAllByOrderByPurchaseDateDesc()
                : purchaseRepository.findAllByOrderByPurchaseDateAsc();
    }
}
