package com.example.shop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import com.example.shop.entity.*;
import com.example.shop.repository.*;
@RestController @RequestMapping("/categories")
public class CategoryController {
    @Autowired private CategoryRepository categoryRepository;

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @GetMapping
    public List<Category> all() { return categoryRepository.findAll(); }
}