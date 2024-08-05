package com.example.demo.controller.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    
	@GetMapping("user/reviewList")
	public String review(Model model) {
	    List<ReviewDTO> reviews = reviewService.getAllReviews(); // 모든 리뷰 가져오기
	    
	    // 콘솔에 데이터를 출력하기
	    System.out.println("Reviews: " + reviews);
	    
	    // 모델에 데이터를 추가하고 뷰를 반환하기
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
    
    // 리뷰 수정 창 띄우기
    @GetMapping("user/updateReview/{reviewId}")
    public String showUpdateReviewForm(@PathVariable("reviewId") Integer reviewId, Model model) {
        List<ReviewDTO> review = reviewService.getReviewsByReviewId(reviewId); // 단일 리뷰 조회
        model.addAttribute("review", review); // 모델에 리뷰 데이터 추가
        return "user/updateReview"; // 수정 폼을 보여주는 뷰 이름
    }
 
}
