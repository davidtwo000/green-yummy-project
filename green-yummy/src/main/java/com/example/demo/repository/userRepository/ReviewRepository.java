package com.example.demo.repository.userRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.userModel.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	List<Review> findByShopUkId(Integer shopUkId);
	
	// 특정 가게 ID에 대한 모든 리뷰 조회
    @Query("SELECT r FROM Review r WHERE r.shopUkId = :shopUkId")
    List<Review> findAllByShopUkId(@Param("shopUkId") Integer shopUkId);

    // 특정 가게 ID에 대한 리뷰 평점의 평균 계산
    @Query("SELECT AVG(r.reviewRate) FROM Review r WHERE r.shopUkId = :shopUkId")
    Double findAverageRatingByShopUkId(@Param("shopUkId") Integer shopUkId);

    // 특정 사용자와 특정 가게에 대한 리뷰 존재 여부 확인
    boolean existsByUserUkIdAndShopUkId(Integer userUkId, Integer shopUkId);
    
	
}