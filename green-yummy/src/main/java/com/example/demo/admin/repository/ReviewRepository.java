package com.example.demo.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.admin.dto.ReviewDTO;
import com.example.demo.model.userModel.Review;

@Repository("AdminReview")
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query("SELECT new com.example.demo.admin.dto.ReviewDTO(r.reviewId, u.id, s.shopName, r.reviewRating, r.reviewComment, r.reviewContent, r.reviewDate) " +
           "FROM Review r JOIN r.user u JOIN Shop s ON r.shopUkId = s.shopUkId")
    List<ReviewDTO> findAllReviewsWithUserAndShop();

    @Query("SELECT new com.example.demo.admin.dto.ReviewDTO(r.reviewId, u.id, s.shopName, r.reviewRating, r.reviewComment, r.reviewContent, r.reviewDate) " +
           "FROM Review r JOIN r.user u JOIN Shop s ON r.shopUkId = s.shopUkId WHERE r.reviewId = :id")
    ReviewDTO findReviewById(@Param("id") Integer id);
}
