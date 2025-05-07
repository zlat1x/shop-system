package com.example.shop.repository;
import com.example.shop.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> findByCustomer_Id(Long customerId);
    List<Purchase> findAllByOrderByPurchaseDateAsc();
    List<Purchase> findAllByOrderByPurchaseDateDesc();
}
