package com.example.demo.service.userService;

import java.time.LocalDateTime;
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
            shopDTO.setShopUkId(shop.getShopUkId());
            shopDTO.setShopName(shop.getShopName());
            // Log shop information
            logger.info("Shop found: shopId={}, shopName={}", shop.getShopUkId(), shop.getShopName());
            // Set ShopDTO to ReviewDTO
            dto.setShop(shopDTO);
        } else {
            logger.warn("Shop not found for shopUkId: {}", review.getShopUkId());
            shopDTO.setShopUkId(null);
            shopDTO.setShopName("Unknown");
            // Set ShopDTO to ReviewDTO
            dto.setShop(shopDTO);
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
	
	
	//가게별 평점 구하기
	@Override
	 // 특정 가게에 대한 리뷰 평점 평균 구하기
    public Double getAverageRatingForShop(Integer shopUkId) {
		logger.info("Calculating average rating for shop with ID: {}", shopUkId);
        
        Double averageRating = reviewRepository.findAverageRatingByShopUkId(shopUkId);
        logger.info("Average rating for shop with ID {}: {}", shopUkId, averageRating);
        return reviewRepository.findAverageRatingByShopUkId(shopUkId);
    }

	@Override
	public ReviewDTO getReviewById(Integer reviewId) throws Exception {
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
        
        if (reviewOptional.isPresent()) {
            Review review = reviewOptional.get();
            ReviewDTO reviewDTO = new ReviewDTO();
            
            // Review 객체에서 데이터를 가져와 ReviewDTO에 설정
            reviewDTO.setReviewId(review.getReviewId());
            reviewDTO.setReviewRate(review.getReviewRate());
            reviewDTO.setReviewComment(review.getReviewComment());
            reviewDTO.setReviewContent(review.getReviewContent());
           ;
            
            return reviewDTO;
        } else {
            throw new Exception("리뷰를 찾을 수 없습니다.");
        }
    }
	

	@Override
	public void updateReview(ReviewDTO reviewDTO) throws Exception {
        // 리뷰 ID를 기반으로 데이터베이스에서 리뷰를 찾습니다.
        Optional<Review> existingReview = reviewRepository.findById(reviewDTO.getReviewId());

        if (existingReview.isPresent()) {
            Review review = existingReview.get();

            // DTO에서 리뷰 정보를 가져와서 리뷰 객체를 업데이트합니다.
            review.setReviewComment(reviewDTO.getReviewComment()); // 이 부분은 필드 매핑에 따라 다를 수 있습니다.
            review.setReviewContent(reviewDTO.getReviewContent());
            review.setReviewRate(reviewDTO.getReviewRate());
            
            review.setReviewDate(LocalDateTime.now());

            // 수정된 리뷰를 저장합니다.
            reviewRepository.save(review);
        } else {
            throw new Exception("리뷰를 찾을 수 없습니다.");
        }
    }

	@Override
	public List<ReviewDTO> getReviewsByReviewId(Integer reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}