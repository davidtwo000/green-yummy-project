package com.example.demo.service.userService;

import java.util.List;

import com.example.demo.dto.userDto.ReviewDTO;
import com.example.demo.model.userModel.Review;

public interface ReviewService {
	List<ReviewDTO> getAllReviews(); // 모든 리뷰 가져오기
    List<ReviewDTO> getReviewsByUserId(Integer userId);
	
	// 리뷰 삭제
    void deleteReview(Integer reviewukid);
    
    //리뷰 작성
    void createReview(ReviewDTO reviewDTO);
    
    //가게ID 리뷰
    List<ReviewDTO> findByShopUkId(Integer shopUkId);
	
    //리뷰 평점
    Double getAverageRatingForShop(Integer shopUkId);
}
