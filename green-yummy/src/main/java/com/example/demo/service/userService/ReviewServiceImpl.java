package com.example.demo.service.userService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.publicDto.ShopDTO;
import com.example.demo.dto.userDto.ReviewDTO;
import com.example.demo.dto.userDto.UserDTO;
import com.example.demo.model.publicModel.Shop;
import com.example.demo.model.userModel.Review;
import com.example.demo.model.userModel.User;
import com.example.demo.repository.publicRepository.ShopRepository;
import com.example.demo.repository.userRepository.ReviewRepository;
import com.example.demo.repository.userRepository.UserRepository;
import com.example.demo.util.FileUploadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ReviewServiceImpl implements ReviewService {

	private static final Logger logger = LoggerFactory.getLogger(ReviewServiceImpl.class);

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private ShopRepository shopRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ReviewRepository reviewRepository1;

	@Autowired
	private FileUploadService fileUploadService;

	private ReviewDTO convertToDto(Review review) {
		// ReviewDTO 객체 생성
		ReviewDTO dto = new ReviewDTO();
		dto.setReviewId(review.getReviewId());
		dto.setUserUkId(review.getUserUkId());
		dto.setShopUkId(review.getShopUkId());
		dto.setReviewRating(review.getReviewRating());
		dto.setReviewComment(review.getReviewComment());
		dto.setReviewContent(review.getReviewContent());
		dto.setReviewDate(review.getReviewDate());
		dto.setReviewImg(review.getReviewImg());

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
	public void createReview(ReviewDTO reviewDTO, MultipartFile file) {
		Review review = new Review();
		review.setShopUkId(reviewDTO.getShopUkId());
		review.setUserUkId(reviewDTO.getUserUkId());
		review.setReviewRating(reviewDTO.getReviewRating());
		review.setReviewComment(reviewDTO.getReviewComment());
		review.setReviewContent(reviewDTO.getReviewContent());

		try {
			if (file != null && !file.isEmpty()) {
				String filename = fileUploadService.saveFile(file);
				review.setReviewImg(filename);
			}
		} catch (IOException e) {
			e.printStackTrace(); // 로깅 및 예외 처리
		}

		reviewRepository.save(review);
		System.out.println("Review created with ID: " + review.getReviewId() + " and Image: " + review.getReviewImg());
	}



	// 가게ukId로 리뷰 출력
	@Override
	public List<ReviewDTO> findByShopUkId(Integer shopUkId) {
		List<Review> reviews = reviewRepository.findByShopUkId(shopUkId); // List<Review>를 반환
		return reviews.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	// 나의 리뷰
	@Override
	public List<ReviewDTO> findByUserUkId(Integer userUkId) {
		List<Review> reviews = reviewRepository.findByUserUkId(userUkId);
		return reviews.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	// 가게별 평점 구하기
	@Override
	public Double getAverageRatingForShop(Integer shopUkId) {
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
			reviewDTO.setReviewRating(review.getReviewRating());
			reviewDTO.setReviewComment(review.getReviewComment());
			reviewDTO.setReviewContent(review.getReviewContent());
			;

			return reviewDTO;
		} else {
			throw new Exception("리뷰를 찾을 수 없습니다.");
		}
	}

	// 리뷰 수정
	@Override
	public void updateReview(ReviewDTO reviewDTO) throws Exception {

		Optional<Review> existingReview = reviewRepository.findById(reviewDTO.getReviewId());

		if (existingReview.isPresent()) {
			Review review = existingReview.get();

			review.setReviewComment(reviewDTO.getReviewComment());
			review.setReviewContent(reviewDTO.getReviewContent());
			review.setReviewRating(reviewDTO.getReviewRating());
			review.setReviewImg(reviewDTO.getReviewImg());

			review.setReviewDate(LocalDateTime.now());

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

	// 이미 작성한 리뷰 있는지 없는지
	@Override
	public boolean hasUserReviewedShop(Integer userUkId, Integer shopUkId) {
		return reviewRepository.existsByUserAndShop(userUkId, shopUkId);
	}

}