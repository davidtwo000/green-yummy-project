package com.example.demo.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.userModel.User;

public interface AdminRepository extends JpaRepository<User, Integer> {
	
}
