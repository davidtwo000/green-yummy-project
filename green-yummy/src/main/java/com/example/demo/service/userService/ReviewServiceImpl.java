package com.example.demo.service.userService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.publicDto.ShopDTO;
import com.example.demo.dto.userDto.ReviewDTO;
import com.example.demo.dto.userDto.UserDTO;
import com.example.demo.model.publicModel.Shop;
import com.example.demo.model.userModel.Review;
import com.example.demo.model.userModel.User;
import com.example.demo.repository.publicRepository.ShopRepository;
import com.example.demo.repository.userRepository.ReviewRepository;
import com.example.demo.repository.userRepository.UserRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

    private static final Logger logger = LoggerFactory.getLogger(ReviewServiceImpl.class);

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ShopRepository shopRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ReviewDTO> getAllReviews() {
        return reviewRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ReviewDTO convertToDto(Review review) {
        // ReviewDTO 객체 생성
        ReviewDTO dto = new ReviewDTO();
        dto.setReviewId(review.getReviewId());
        dto.setUserUkId(review.getUserUkId());
        dto.setShopUkId(review.getShopUkId());
        dto.setReviewRate(review.getReviewRate());
        dto.setReviewComment(review.getReviewComment());
        dto.setReviewContent(review.getReviewContent());
        dto.setReviewDate(review.getReviewDate());

        // ShopDTO 객체 생성 및 ShopRepository 사용
        ShopDTO shopDTO = new ShopDTO();
        Optional<Shop> shopOptional = shopRepository.findById(review.getShopUkId());

        if (shopOptional.isPresent()) {
            Shop shop = shopOptional.get();
            logger.info("Found shop: {}", shop);
            shopDTO.setShopUkId(shop.getShopUkId());
            shopDTO.setShopName(shop.getShopName());
            // 필요한 경우 다른 Shop 필드 설정
        } else {
            logger.warn("Shop not found for shopUkId: {}", review.getShopUkId());
            shopDTO.setShopUkId(null);
            shopDTO.setShopName("Unknown");
        }

     // UserDTO 설정
        UserDTO userDTO = new UserDTO();
        if (review.getUserUkId() != null) {
            Optional<User> userOptional = userRepository.findById(review.getUserUkId());
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                userDTO.setUserUkId(user.getUserUkId());
                userDTO.setId(user.getId());
              
            } else {
                userDTO.setUserUkId(null);
                userDTO.setId("Unknown");   
            }
        } else {
        	userDTO.setUserUkId(null);
            userDTO.setId("Unknown");
        }
        dto.setUser(userDTO);      

        return dto;
    }

    @Override
    public void deleteReview(Integer reviewId) {
        if (reviewRepository.existsById(reviewId)) {
            reviewRepository.deleteById(reviewId);
            logger.info("Review deleted with ID: {}", reviewId);
        } else {
            logger.error("Review not found with ID: {}", reviewId);
            throw new RuntimeException("Review not found with ID: " + reviewId);
        }
    }

    @Override
    public void createReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setShopUkId(reviewDTO.getShopUkId());
        review.setUserUkId(reviewDTO.getUserUkId());
        review.setReviewRate(reviewDTO.getReviewRate());
        review.setReviewComment(reviewDTO.getReviewComment());
        review.setReviewContent(reviewDTO.getReviewContent());

        // 검증 로직 추가 가능
        reviewRepository.save(review);
        logger.info("Review created with ID: {}", review.getShopUkId());
    }

    // 가게ukId로 리뷰 출력
    @Override
    public List<ReviewDTO> findByShopUkId(Integer shopUkId) {
        List<Review> reviews = reviewRepository.findByShopUkId(shopUkId);  // List<Review>를 반환
        return reviews.stream()
                      .map(this::convertToDto)  // Review를 ReviewDTO로 변환
                      .collect(Collectors.toList());
    }
    
    //유저Ukid로 리뷰 출력
	@Override
	public List<ReviewDTO> getReviewsByUserId(Integer userUkId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//리뷰 평점
	@Override
    public Double getAverageReviewRateByShopUkId(Integer shopUkId) {
        return reviewRepository.findAverageReviewRateByShopUkId(shopUkId);
    }
}