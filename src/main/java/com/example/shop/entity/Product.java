package com.example.shop.entity;
import jakarta.persistence.*;
import java.util.Set;
import java.util.List;
import com.example.shop.entity.Store;
@Entity
public class Product {
    @Id @GeneratedValue private Long id;
    private String name;
    private double price;

    @ManyToOne private Category category;

    @ManyToMany(mappedBy = "products")
    private Set<Store> stores;

    @OneToMany(mappedBy = "product")
    private List<Purchase> purchases;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }
}
