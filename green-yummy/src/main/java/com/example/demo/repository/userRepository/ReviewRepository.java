package com.example.demo.repository.userRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.userModel.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	
}