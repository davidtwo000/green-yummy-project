package com.example.demo.controller.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.publicDto.ShopDTO;
import com.example.demo.dto.userDto.ReviewDTO;
import com.example.demo.service.publicService.ShopService;
import com.example.demo.service.userService.ReviewService;

@Controller
public class ReviewController {
	@Autowired
    private ReviewService reviewService;
	
	@Autowired
	private ShopService shopService;
    
    // 특정 사용자 ID의 리뷰를 가져오는 메서드
    @GetMapping("user/reviewList")
    public String review(Model model) {
        List<ReviewDTO> reviews = reviewService.getAllReviews(); // 모든 리뷰 가져오기
        model.addAttribute("reviews", reviews);
        return "user/reviewList"; // 리뷰를 표시할 뷰 이름
    }
    
    //식당 정보 가져와서 createReview 창 띄우기
    @GetMapping("user/createReview/{shopUkId}")
    public String showCreateReviewForm(@PathVariable("shopUkId") Integer shopUkId, Model model) {
        ShopDTO shop = shopService.getShopByUkId(shopUkId);
        model.addAttribute("shop", shop); // Add shop object to model
        return "user/createReview"; // View name
    }
		
}
