package com.example.demo.controller.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @PostMapping("/user/createReview/{id}")
    public ResponseEntity<String> createReview(
            @RequestParam("shopUkId") Integer shopUkId,
            @RequestParam("reviewRate") Byte reviewRate,
            @RequestParam("reviewComment") String reviewComment,
            @RequestParam("reviewContent") String reviewContent) {
        
        // ReviewDTO 객체 생성 및 데이터 설정
        ReviewDTO review = new ReviewDTO();
        review.setShopUkId(shopUkId);
        review.setReviewRate(reviewRate);
        review.setReviewComment(reviewComment);
        review.setReviewContent(reviewContent);
        
        // 리뷰 생성 서비스 호출
        reviewService.createReview(review);

        // 성공 메시지 반환
        return ResponseEntity.ok("리뷰가 성공적으로 생성되었습니다.");
    }
}