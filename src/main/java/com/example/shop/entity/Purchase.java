package com.example.shop.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
public class Purchase {
    @Id @GeneratedValue private Long id;

    @ManyToOne private Customer customer;
    @ManyToOne private Product product;

    private LocalDate purchaseDate;

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
