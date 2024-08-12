package com.example.demo.controller.userController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dto.userDto.ReviewDTO;
import com.example.demo.model.publicModel.Shop;
import com.example.demo.model.userModel.User;
import com.example.demo.service.userService.ReviewService;
import com.example.demo.service.userService.UserServiceImpl;
import com.example.demo.util.FileUploadService;
import com.example.demo.util.FileUploader;

@RestController
@RequestMapping("/reviews")
public class ReviewRestController {

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private FileUploader fileUploader;

	@Autowired
	private UserServiceImpl userService;
	
    @Autowired
    private FileUploadService fileUploadService;

	// 리뷰 삭제
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteReview(@PathVariable("id") Integer id) {
		try {
			reviewService.deleteReview(id);
			return ResponseEntity.ok("Review deleted successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Failed to delete review: " + e.getMessage());
		}
	}

	// 리뷰 작성
	@PostMapping("/createReview/{shopUkId}")
    public ResponseEntity<String> createReview(
            @PathVariable("shopUkId") Integer shopUkId,
            @RequestParam("userUkId") Integer userUkId,
            @RequestParam("reviewRating") Byte reviewRating,
            @RequestParam("reviewComment") String reviewComment,
            @RequestParam("reviewContent") String reviewContent,
            @RequestParam(value = "reviewImg", required = false) MultipartFile reviewImg) {

        try {
            // 리뷰 DTO 생성 및 설정
            ReviewDTO reviewDTO = new ReviewDTO();
            reviewDTO.setShopUkId(shopUkId);
            reviewDTO.setUserUkId(userUkId);
            reviewDTO.setReviewRating(reviewRating);
            reviewDTO.setReviewComment(reviewComment);
            reviewDTO.setReviewContent(reviewContent);

            // 파일 업로드 및 경로 설정
            if (reviewImg != null && !reviewImg.isEmpty()) {
                String fileName = fileUploadService.saveFile(reviewImg); // 파일 저장
                reviewDTO.setReviewImg(fileName); // 파일 이름 설정
            }

            // 리뷰 생성
            reviewService.createReview(reviewDTO, reviewImg);

            return ResponseEntity.ok("리뷰가 성공적으로 생성되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("리뷰 생성 실패: " + e.getMessage());
        }
    }

	// 리뷰 수정
	@PutMapping("/updateReview/{reviewId}")
	public ResponseEntity<String> updateReview(@PathVariable("reviewId") Integer reviewId,
			@RequestParam("reviewComment") String reviewComment, @RequestParam("reviewContent") String reviewContent,
			@RequestParam("reviewRating") Byte reviewRating, @RequestParam("reviewImg") MultipartFile reviewImg) {

		try {
			ReviewDTO review = new ReviewDTO();
			review.setReviewId(reviewId);
			review.setReviewComment(reviewComment);
			review.setReviewContent(reviewContent);
			review.setReviewRating(reviewRating);

			if (reviewImg != null && !reviewImg.isEmpty()) {
				String folder = "images";
				String fileName = fileUploader.uploadFileAndGetChangedFileName(reviewImg, folder);
				review.setReviewImg(folder + "/" + fileName);
			}

			reviewService.updateReview(review);

			return ResponseEntity.ok("리뷰가 성공적으로 수정되었습니다.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("리뷰 수정에 실패했습니다: " + e.getMessage());
		}
	}

	// 나의 리뷰
	@GetMapping("/myreview/{userUkId}")
	public ResponseEntity<List<ReviewDTO>> getReviewsByUserUkId(@PathVariable("userUkId") Integer userUkId) {
		List<ReviewDTO> reviews = reviewService.findByUserUkId(userUkId);
		if (reviews.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}

	// 가게ukId로 리뷰 출력
    @GetMapping("/shop/{shopUkId}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByShopUkId(@PathVariable("shopUkId") Integer shopUkId) {
        List<ReviewDTO> reviews = reviewService.findByShopUkId(shopUkId);

        if (reviews.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
    

	// 리뷰 평균 평점 조회
	@GetMapping("/rating/{shopUkId}")
	public Double getAverageRating(@PathVariable("shopUkId") Integer shopUkId) {
		return reviewService.getAverageRatingForShop(shopUkId);
	}

	// 원래 리뷰 정보 가져오기
	@GetMapping("/{reviewId}")
	public ResponseEntity<ReviewDTO> getReviewById(@PathVariable("reviewId") Integer reviewId) {
		try {
			ReviewDTO reviewDTO = reviewService.getReviewById(reviewId);
			if (reviewDTO != null) {
				return ResponseEntity.ok(reviewDTO);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	// 사용자가 특정 가게에 대해 리뷰를 작성했는지 확인
    @GetMapping("/hasReviewed/{shopUkId}/{userUkId}")
    public ResponseEntity<Boolean> hasReviewed(
            @PathVariable("shopUkId") Integer shopUkId,
            @PathVariable("userUkId") Integer userUkId) {

        boolean hasReviewed = reviewService.userHasReviewed(shopUkId, userUkId);
        return ResponseEntity.ok(hasReviewed);
    }
	

}