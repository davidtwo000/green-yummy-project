package com.example.demo.service.userService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.userDto.ReviewDTO;
import com.example.demo.model.userModel.Review;
import com.example.demo.repository.userRepository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository; // 필드 이름 수정

    @Override
    public List<ReviewDTO> getAllReviews() {
        // 모든 리뷰를 데이터베이스에서 가져와서 DTO로 변환
        return reviewRepository.findAll().stream()
                .map(this::convertToDto) // Review 엔티티를 ReviewDTO로 변환
                .collect(Collectors.toList()); // List로 수집
    }
    
    private ReviewDTO convertToDto(Review review) {
        // Review 엔티티를 ReviewDTO로 변환
        ReviewDTO dto = new ReviewDTO();
        dto.setReviewId(review.getReviewId());
        dto.setUserUkId(review.getUserUkId());
        dto.setShopUkId(review.getShopUkId());
        dto.setReviewRate(review.getReviewRate());
        dto.setReviewComment(review.getReviewComment());
        dto.setReviewContent(review.getReviewContent());
        dto.setReviewDate(review.getReviewDate());
        return dto;
    }
    
    
}