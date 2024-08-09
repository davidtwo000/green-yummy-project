package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ReviewDTO;
import com.example.demo.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

	@Query("SELECT new com.example.demo.dto.ReviewDTO(r.reviewId, u.id, s.shopName, r.reviewRate, r.reviewComment, r.reviewContent, r.reviewDate) "
			+ "FROM Review r JOIN r.user u JOIN r.shop s")
	List<ReviewDTO> findAllReviewsWithUserAndShop();

	@Query("SELECT new com.example.demo.dto.ReviewDTO(r.reviewId, u.id, s.shopName, r.reviewRate, r.reviewComment, r.reviewContent, r.reviewDate) "
			+ "FROM Review r JOIN r.user u JOIN r.shop s WHERE r.reviewId = :id")
	ReviewDTO findReviewById(@Param("id") Integer id);

	@Query("SELECT new com.example.demo.dto.ReviewDTO(r.reviewId, u.id, s.shopName, r.reviewRate, r.reviewComment, r.reviewContent, r.reviewDate) "
			+ "FROM Review r JOIN r.user u JOIN r.shop s "
			+ "WHERE (u.id LIKE %:keyword% OR s.shopName LIKE %:keyword%) "
			+ "OR (CAST(r.reviewRate AS string) LIKE %:keyword%)")
	List<ReviewDTO> searchByKeyword(@Param("keyword") String keyword);

	@Query("SELECT new com.example.demo.dto.ReviewDTO(r.reviewId, u.id, s.shopName, r.reviewRate, r.reviewComment, r.reviewContent, r.reviewDate) "
			+ "FROM Review r JOIN r.user u JOIN r.shop s " + "WHERE u.id LIKE %:userUkId%")
	List<ReviewDTO> findByUserUkIdContaining(@Param("userUkId") String userUkId);

	@Query("SELECT new com.example.demo.dto.ReviewDTO(r.reviewId, u.id, s.shopName, r.reviewRate, r.reviewComment, r.reviewContent, r.reviewDate) "
			+ "FROM Review r JOIN r.shop s JOIN r.user u " + "WHERE s.shopName LIKE %:shopName%")
	List<ReviewDTO> findByShopNameContaining(@Param("shopName") String shopName);

	@Query(value = "SELECT r.REVIEW_ID, u.id, s.shop_name, r.REVIEW_RATING, r.review_comment, r.review_content, r.REVIEW_DATE "
			+ "FROM reviews r " + "JOIN users u ON r.USER_UK_ID = u.USER_UK_ID "
			+ "JOIN shops s ON r.SHOP_UK_ID = s.SHOP_UK_ID "
			+ "WHERE CAST(r.REVIEW_RATING AS CHAR) LIKE %:rating%", nativeQuery = true)
	List<ReviewDTO> findByReviewRating(@Param("rating") String rating);

}
