package com.example.demo.controller.userController;

import java.util.Arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.userDto.ReviewDTO;
import com.example.demo.service.userService.ReviewService;


@RestController
@RequestMapping("/reviews")
public class ReviewRestController {

    @Autowired
    private ReviewService reviewService; 

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable("id") Integer id) {
        try {
            reviewService.deleteReview(id); // 서비스 메서드를 호출하여 삭제
            return ResponseEntity.ok("Review deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to delete review: " + e.getMessage());
        }
    }
    
    @PostMapping("/createReview/{shopUkId}")
    public ResponseEntity<String> createReview(
            @PathVariable("shopUkId") Integer shopUkId,
            @RequestParam("userUkId") Integer userUkId,
            @RequestParam("reviewRate") Byte reviewRate,
            @RequestParam("reviewComment") String reviewComment, // Capture as a comma-separated string
            @RequestParam("reviewContent") String reviewContent) {

        try {
            ReviewDTO review = new ReviewDTO();
            review.setShopUkId(shopUkId);
            review.setUserUkId(userUkId);
            review.setReviewRate(reviewRate);
            review.setReviewComment(reviewComment); // Store as a list
            review.setReviewContent(reviewContent);

            // Call the service to create the review
            reviewService.createReview(review);

            return ResponseEntity.ok("리뷰가 성공적으로 생성되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to create review: " + e.getMessage());
        }
    }
    
    // 가게ukId로 리뷰 출력
    @GetMapping("/shop/{shopUkId}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByShopUkId(@PathVariable("shopUkId") Integer shopUkId) {
        List<ReviewDTO> reviews = reviewService.findByShopUkId(shopUkId);
        if (reviews.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
    
    
    //리뷰 평균 평점 조회
    @GetMapping("/shop/{shopUkId}/average-rating")
    public Double getAverageRating(@PathVariable("shopUkId") Integer shopUkId) {
        return reviewService.getAverageRatingForShop(shopUkId);
    }
}