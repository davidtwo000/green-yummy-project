package com.example.demo.controller.userController;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.userDto.ReviewDTO;
import com.example.demo.dto.userDto.ReviewPhotoDTO;
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
    
    //리뷰 작성 
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
            review.setReviewRating(reviewRate);
            review.setReviewComment(reviewComment); // Store as a list
            review.setReviewContent(reviewContent);

            // Call the service to create the review
            reviewService.createReview(review);

            return ResponseEntity.ok("리뷰가 성공적으로 생성되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to create review: " + e.getMessage());
        }
    }
    
    //리뷰 이미 작성했으면 못하게
    @PostMapping("/check")
    @ResponseBody
    public boolean checkUserReview(@RequestParam("shopUkId") Integer shopUkId,
                                    @RequestParam("userUkId") Integer userUkId) {
        return reviewService.hasUserReviewedShop(userUkId, shopUkId);
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
    @GetMapping("/rating/{shopUkId}")
    public Double getAverageRating(@PathVariable("shopUkId") Integer shopUkId) {
        return reviewService.getAverageRatingForShop(shopUkId);
    }
    
    
    //원래 리뷰 정보 가져오기
    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable("reviewId") Integer reviewId) {
        try {
            ReviewDTO reviewDTO = reviewService.getReviewById(reviewId);
            if (reviewDTO != null) {
                return ResponseEntity.ok(reviewDTO);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    
    //리뷰 수정
    @PutMapping("/update/{reviewId}")
    public ResponseEntity<String> updateReview(
            @PathVariable("reviewId") Integer reviewId,
            @RequestBody ReviewDTO reviewDTO) {

        try {
            // 리뷰 DTO에서 reviewId를 가져와서 설정
            reviewDTO.setReviewId(reviewId);

            // 리뷰 업데이트를 위한 서비스 호출
            reviewService.updateReview(reviewDTO);

            return ResponseEntity.ok("리뷰가 성공적으로 수정되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("리뷰 수정에 실패했습니다: " + e.getMessage());
        }
    }
    
  
    
}

