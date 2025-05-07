package com.example.shop.entity;
import jakarta.persistence.*;
import java.util.Set;
@Entity
public class Store {
    @Id @GeneratedValue private Long id;
    @Column(unique = true) private String name;
    private String location;

    @ManyToMany
    @JoinTable(name = "store_products",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
