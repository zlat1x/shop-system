package com.example.shop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import com.example.shop.entity.*;
import com.example.shop.repository.*;

@RestController @RequestMapping("/stores")
public class StoreController {
    @Autowired private StoreRepository storeRepository;
    @Autowired private ProductRepository productRepository;

    @PostMapping("/add")
    public Store addStore(@RequestBody Store store) {
        return storeRepository.save(store);
    }

    @PostMapping("/{storeId}/addProduct/{productId}")
    public Store addProductToStore(@PathVariable Long storeId, @PathVariable Long productId) {
        Store store = storeRepository.findById(storeId).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();
        store.getProducts().add(product);
        return storeRepository.save(store);
    }

    @GetMapping("/by-product/{productId}")
    public List<Store> getStoresWithProduct(@PathVariable Long productId) {
        return storeRepository.findByProducts_Id(productId);
    }
}
