package com.example.demo.controller.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.userDto.ReviewDTO;
import com.example.demo.service.userService.ReviewService;

@Controller
public class ReviewController {
	@Autowired
    private ReviewService reviewService;
    
    // 특정 사용자 ID의 리뷰를 가져오는 메서드
    @GetMapping("user/reviewList")
    public String review(Model model) {
        List<ReviewDTO> reviews = reviewService.getAllReviews(); // 모든 리뷰 가져오기
        model.addAttribute("reviews", reviews);
        return "user/reviewList"; // 리뷰를 표시할 뷰 이름
    }
		
}
