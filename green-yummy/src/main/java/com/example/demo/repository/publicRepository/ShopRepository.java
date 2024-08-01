package com.example.demo.repository.publicRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.publicModel.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
}