package com.example.demo.service.userService;

import java.util.List;

import com.example.demo.dto.userDto.ReviewDTO;

public interface ReviewService {
	List<ReviewDTO> getAllReviews(); // 모든 리뷰 가져오기
    List<ReviewDTO> getReviewsByUserId(Integer userId);
	
	// 리뷰 삭제
    void deleteReview(Integer reviewukid);
    
    //리뷰 작성
    void createReview(ReviewDTO reviewDTO);
}
