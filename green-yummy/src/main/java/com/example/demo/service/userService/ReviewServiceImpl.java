package com.example.demo.service.userService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.publicDto.ShopDTO;
import com.example.demo.dto.userDto.ReviewDTO;
import com.example.demo.model.publicModel.Shop;
import com.example.demo.model.userModel.Review;
import com.example.demo.repository.publicRepository.ShopRepository;
import com.example.demo.repository.userRepository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository; // 필드 이름 수정
    
    @Autowired
    private ShopRepository shopRepository;

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
        
        ShopDTO shopDTO = new ShopDTO();
        Optional<Shop> shopOptional = shopRepository.findById(review.getShopUkId());
     // 디버깅: shopOptional 값 출력
        System.out.println("shopOptional is present: " + shopOptional.isPresent());
        
        if (shopOptional.isPresent()) {
            Shop shop = shopOptional.get();
            System.out.println("Found shop: " + shop);
            shopDTO.setShopUkId(shop.getShopUkId());
            shopDTO.setShopName(shop.getShopName());
            
        } else {
            shopDTO.setShopUkId(null);
            shopDTO.setShopName("Unknown");
        }
        
        dto.setShop(shopDTO);
        
        return dto;
    }
    
    @Override
    public void deleteReview(Integer reviewukid) {
        if (reviewRepository.existsById(reviewukid)) {
            reviewRepository.deleteById(reviewukid);
        } else {
            throw new RuntimeException("Review not found with ID: " + reviewukid);
        }
    }

	@Override
	public List<ReviewDTO> getReviewsByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}