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
import com.example.demo.model.publicModel.Shop;
import com.example.demo.model.userModel.Review;
import com.example.demo.repository.publicRepository.ShopRepository;
import com.example.demo.repository.userRepository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

    private static final Logger logger = LoggerFactory.getLogger(ReviewServiceImpl.class);

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public List<ReviewDTO> getAllReviews() {
        return reviewRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ReviewDTO convertToDto(Review review) {
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

        if (shopOptional.isPresent()) {
            Shop shop = shopOptional.get();
            logger.info("Found shop: {}", shop);
            shopDTO.setShopUkId(shop.getShopUkId());
            shopDTO.setShopName(shop.getShopName());
            // 필요시 다른 Shop 필드 설정
        } else {
            logger.warn("Shop not found for shopUkId: {}", review.getShopUkId());
            shopDTO.setShopUkId(null);
            shopDTO.setShopName("Unknown");
        }

        dto.setShop(shopDTO);

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
        review.setReviewRate(reviewDTO.getReviewRate());
        review.setReviewComment(reviewDTO.getReviewComment());
        review.setReviewContent(reviewDTO.getReviewContent());

        // 검증 로직 추가 가능
        reviewRepository.save(review);
        logger.info("Review created with ID: {}", review.getId());
    }
}