package com.example.demo.repository.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.adminModel.Application;

public interface ShopApplyRepository extends JpaRepository<Application, Integer>{

}
