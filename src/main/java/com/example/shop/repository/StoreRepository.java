package com.example.shop.repository;
import com.example.shop.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    @Query("SELECT s FROM Store s JOIN s.products p WHERE p.id = :productId")
    List<Store> findStoresByProductId(@Param("productId") Long productId);
}
