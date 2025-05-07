package com.example.shop.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.shop.entity.Product;
import com.example.shop.entity.Category;
import com.example.shop.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired private ProductRepository productRepository;
    public Product save(Product product) { return productRepository.save(product); }
    public List<Product> findByCategory(Long categoryId) {
        return productRepository.findByCategory_Id(categoryId);
    }
}
