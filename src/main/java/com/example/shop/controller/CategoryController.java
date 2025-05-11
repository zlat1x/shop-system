package com.example.shop.controller;

import com.example.shop.entity.Category;
import com.example.shop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/add")
    public String addCategory(@RequestParam Long id,
                              @RequestParam String name) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        categoryRepository.save(category);
        return "redirect:/";
    }

    @GetMapping
    public String all(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "categories-list";
    }
}
