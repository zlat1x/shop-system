package com.example.shop.entity;

import com.example.shop.entity.Product;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Store {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String location;

    @ManyToMany
    @JoinTable(
            name = "store_product",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public Store() {}

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }

    public void setId(Long id) {
        this.id = id;
    }
}
