package com.example.shop.entity;
import jakarta.persistence.*;
import java.util.List;
@Entity
public class Customer {
    @Id @GeneratedValue private Long id;
    private String name;
    @Column(unique = true) private String email;

    @OneToMany(mappedBy = "customer")
    private List<Purchase> purchases;
}
