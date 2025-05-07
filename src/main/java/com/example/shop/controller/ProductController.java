package com.example.shop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import com.example.shop.entity.*;
import com.example.shop.repository.*;
import com.example.shop.service.ProductService;

import java.time.LocalDate;

@RestController @RequestMapping("/products")
public class ProductController {
    @Autowired private ProductService productService;
    @Autowired private CategoryRepository categoryRepository;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        double price = Double.parseDouble(body.get("price"));
        Long categoryId = Long.parseLong(body.get("categoryId"));
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        Product p = new Product();
        p.setName(name); p.setPrice(price); p.setCategory(category);
        return productService.save(p);
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getByCategory(@PathVariable Long categoryId) {
        return productService.findByCategory(categoryId);
    }
}
