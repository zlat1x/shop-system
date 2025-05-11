package com.example.shop.controller;

import com.example.shop.entity.Store;
import com.example.shop.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.shop.entity.Product;
import com.example.shop.repository.ProductRepository;

import java.util.List;

@Controller
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/add")
    public String addStore(@RequestParam Long id,
                           @RequestParam String name,
                           @RequestParam String location) {
        Store store = new Store();
        store.setId(id);
        store.setName(name);
        store.setLocation(location);
        storeRepository.save(store);
        return "redirect:/";
    }

    @PostMapping("/add-product")
    public String assignProductToStore(@RequestParam Long storeId,
                                       @RequestParam Long productId) {
        Store store = storeRepository.findById(storeId).orElse(null);
        Product product = productRepository.findById(productId).orElse(null);

        if (store != null && product != null) {
            store.getProducts().add(product);
            storeRepository.save(store);
        }

        return "redirect:/";
    }

    @GetMapping("/by-product/{productId}")
    public String viewStoresByProduct(@PathVariable Long productId, Model model) {
        List<Store> stores = storeRepository.findStoresByProductId(productId);
        model.addAttribute("stores", stores);
        return "stores-list";  // Показати красиву HTML сторінку
    }
}
