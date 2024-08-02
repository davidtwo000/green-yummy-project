package com.example.demo.repository.userRepository;

import com.example.demo.model.userModel.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}