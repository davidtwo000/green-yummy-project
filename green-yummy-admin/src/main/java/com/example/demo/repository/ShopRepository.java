package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
	
    List<Shop> findByShopNameContaining(String shopName);

    List<Shop> findByShopTypeContaining(String shopType);

    List<Shop> findByLocationContaining(String location);

    @Query("SELECT s FROM Shop s WHERE s.shopName LIKE %:keyword% OR s.shopType LIKE %:keyword% OR s.location LIKE %:keyword%")
    List<Shop> searchByKeyword(@Param("keyword") String keyword);
}
