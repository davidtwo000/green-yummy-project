package com.example.demo.service.userService;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.userDto.ReviewDTO;
import com.example.demo.model.userModel.Review;

public interface ReviewService {
	// 리뷰 삭제
    void deleteReview(Integer reviewukid);
    
   
    //가게ID 리뷰
    List<ReviewDTO> findByShopUkId(Integer shopUkId);
	
    //리뷰 평점
    Double getAverageRatingForShop(Integer shopUkId);
    
    //리뷰 수정 창 띄우기
    List<ReviewDTO> getReviewsByReviewId(Integer reviewId);
    
    //리뷰 수정하기
	void updateReview(ReviewDTO reviewDTO) throws Exception;
	
	//원래 리뷰 가져오는 창
	ReviewDTO getReviewById(Integer Integer) throws Exception;
	
	//리뷰 작성했는지 확인
	
	
	//나의 리뷰 보기
	List<ReviewDTO> findByUserUkId(Integer userUkId);

	void createReview(ReviewDTO reviewDTO, MultipartFile file);


	boolean userHasReviewed(Integer shopUkId, Integer userUkId);

	
}