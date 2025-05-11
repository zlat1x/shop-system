package com.example.shop.controller;

import com.example.shop.entity.Purchase;
import com.example.shop.entity.Customer;
import com.example.shop.entity.Product;
import com.example.shop.repository.PurchaseRepository;
import com.example.shop.repository.CustomerRepository;
import com.example.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/buy")
    public String registerPurchase(@RequestParam Long id,
                                   @RequestParam String customer,
                                   @RequestParam String product,
                                   @RequestParam String purchaseDate) {

        Customer customerEntity = customerRepository.findByName(customer).orElse(null);
        Product productEntity = productRepository.findByName(product).orElse(null);

        if (customerEntity != null && productEntity != null) {
            Purchase purchase = new Purchase();
            purchase.setId(id);
            purchase.setCustomer(customerEntity);
            purchase.setProduct(productEntity);
            purchase.setPurchaseDate(LocalDate.parse(purchaseDate));
            purchaseRepository.save(purchase);
        }

        return "redirect:/";
    }

    @GetMapping("/by-customer/{customerId}")
    public String viewPurchasesByCustomer(@PathVariable Long customerId, Model model) {
        List<Purchase> purchases = purchaseRepository.findByCustomerId(customerId);
        model.addAttribute("purchases", purchases);
        return "purchases-list";
    }

    @GetMapping("/sorted-by-date")
    public String viewPurchasesSortedByDate(@RequestParam String order, Model model) {
        List<Purchase> purchases;
        if ("asc".equals(order)) {
            purchases = purchaseRepository.findAllByOrderByPurchaseDateAsc();
        } else {
            purchases = purchaseRepository.findAllByOrderByPurchaseDateDesc();
        }
        model.addAttribute("purchases", purchases);
        return "purchases-list";  // Показати красиву HTML сторінку
    }

}
