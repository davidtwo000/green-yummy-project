package com.example.demo.repository.publicRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.userModel.User;

public interface UserRegistRepository extends JpaRepository<User, Integer> {
    boolean existsById(String id);
    boolean existsByNickname(String nickname);
	boolean existsByEmail(String email);
}
