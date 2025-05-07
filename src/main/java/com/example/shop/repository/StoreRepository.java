package com.example.shop.repository;
import com.example.shop.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findByProducts_Id(Long productId);
}
