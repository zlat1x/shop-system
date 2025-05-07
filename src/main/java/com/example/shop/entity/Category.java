package com.example.shop.entity;
import jakarta.persistence.*;
import java.util.List;
@Entity
public class Category {
    @Id @GeneratedValue private Long id;
    @Column(unique = true) private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
