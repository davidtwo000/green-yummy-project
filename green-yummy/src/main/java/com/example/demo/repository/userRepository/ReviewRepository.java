package com.example.demo.repository.userRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.userModel.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	List<Review> findByShopUkId(Integer shopUkId);
	
	//리뷰 평점
	@Query("SELECT AVG(r.reviewRate) FROM Review r WHERE r.shopUkId = :shopUkId")
    Double findAverageReviewRateByShopUkId(@Param("shopUkId") Integer shopUkId);
}