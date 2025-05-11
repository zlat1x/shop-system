package com.example.shop.controller;

import com.example.shop.entity.Product;
import com.example.shop.entity.Category;
import com.example.shop.repository.ProductRepository;
import com.example.shop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/add")
    public String addProduct(@RequestParam Long id,
                             @RequestParam String name,
                             @RequestParam double price) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);

        productRepository.save(product);

        return "redirect:/";
    }

    @PostMapping("/assign-category")
    public String assignProductToCategory(@RequestParam Long productId,
                                          @RequestParam Long categoryId) {
        Product product = productRepository.findById(productId).orElse(null);
        Category category = categoryRepository.findById(categoryId).orElse(null);

        if (product != null && category != null) {
            product.setCategory(category);
            productRepository.save(product);
        }

        return "redirect:/";
    }

    @GetMapping("/category/{categoryId}")
    public String viewProductsByCategory(@PathVariable Long categoryId, Model model) {
        List<Product> products = productRepository.findByCategoryId(categoryId);
        model.addAttribute("products", products);
        return "products-list";
    }

}
