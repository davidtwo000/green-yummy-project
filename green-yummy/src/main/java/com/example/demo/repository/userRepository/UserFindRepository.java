package com.example.demo.repository.userRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.userModel.User;

public interface UserFindRepository extends JpaRepository<User, Integer>  {
	Optional<User> findById(String Id);
	
	Optional<User> findByPhoneAndEmail(String phone, String email);
	Optional<User> findByIdAndEmail(String id, String email);
}
