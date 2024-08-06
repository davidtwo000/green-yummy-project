package com.example.demo.service.userService;

import java.util.List;

import org.springframework.data.domain.Page;

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
    
    //리뷰 수정 창 띄우기
    List<ReviewDTO> getReviewsByReviewId(Integer reviewId);
    
    //리뷰 수정하기
	void updateReview(ReviewDTO reviewDTO) throws Exception;
	
	//원래 리뷰 가져오는 창
	ReviewDTO getReviewById(Integer reviewId) throws Exception;
	
	//리뷰 작성했는지 확인
	boolean hasUserReviewedShop(Integer userUkId, Integer shopUkId);
	
	//리뷰 페이지화
	Page<ReviewDTO> getReviewsPage(int page, int size);
	
	int getNextReviewId();
	
	
}