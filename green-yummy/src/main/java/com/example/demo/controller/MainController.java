package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.publicDto.NotificationDTO;
import com.example.demo.model.userModel.User;
import com.example.demo.service.publicService.NotificationService;
import com.example.demo.service.publicService.UserRegistService;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "index/index";
	}
	
	@GetMapping("public/userLogin")
	public String userLogin() {
		return "public/userLogin";
	}
	
	@GetMapping("public/Agreement")
	public String Agreement() {
		return "public/Agreement";
	}
	@GetMapping("public/usePolicyCheckPage")
	public String usePolicyCheckPage() {
		return "public/usePolicyCheckPage";
	}
	@GetMapping("public/privacyPolicyCheckPage")
	public String privacyPolicyCheckPage() {
		return "public/privacyPolicyCheckPage";
	}
	@GetMapping("public/advertisementCheckPage")
	public String advertisementCheckPage() {
		return "public/advertisementCheckPage";
	}
	
	@GetMapping("public/findIdPassword")
	public String findIdPassword() {
		return "public/findIdPassword";
	}
	
	@GetMapping("public/userRegist")
	public String userRegist() {
		//다 구현하고 나서 userLogin으로 보내기
		return "public/userRegist";
	}
	
	@GetMapping("public/pictureOCR")
	public String pictureOCR() {
		return "public/pictureOCR";
	}
	
	@GetMapping("public/usePolicy")
	public String usePolicy() {
		return "public/usePolicy";
	}
	
	@GetMapping("public/privacyPolicy")
	public String privacyPolicy() {
		return "public/privacyPolicy";
	}
	
	@GetMapping("public/serviceIntro")
	public String ServiceIntro() {
		return "public/serviceIntro";
	}
	
	
	@Autowired
    private NotificationService notificationService;
	
	private static final int PAGE_SIZE_N = 10;
	
	@GetMapping("public/notification")
	public String notification(@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "searchType", required = false) String searchType,
            @RequestParam(value = "searchKeyword", required = false) String searchKeyword,
            Model model) {
		
		int start = (page - 1) * PAGE_SIZE_N;
	    List<NotificationDTO> notices;
	    int totalNotices;

	    if (searchKeyword != null && !searchKeyword.isEmpty()) {
	        notices = notificationService.searchNotices(searchType, searchKeyword, start, PAGE_SIZE_N);
	        totalNotices = notificationService.getSearchTotalNotices(searchType, searchKeyword);
	    } else {
	        notices = notificationService.getNotices(start, PAGE_SIZE_N);
	        totalNotices = notificationService.getTotalNotices();
	    }

	    int totalPages = (int) Math.ceil((double) totalNotices / PAGE_SIZE_N);

	    // 페이지 버튼을 5개씩 보이게 할 범위 계산
	    int maxButtons = 5;
	    int startPage = Math.max(1, page - maxButtons / 2);
	    int endPage = Math.min(totalPages, startPage + maxButtons - 1);

	    if(totalPages<6){
	    	startPage = 1;
	    	endPage = Math.min(totalPages, startPage + maxButtons - 1);
	   	}else if(page>=totalPages-2){
	   		startPage = totalPages - 4;
	   		endPage = totalPages;
	   	}
	   	
	    
	    model.addAttribute("notices", notices);
	    model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("searchType", searchType);
	    model.addAttribute("searchKeyword", searchKeyword);
	    model.addAttribute("startPage", startPage);
	    model.addAttribute("endPage", endPage);
        
        return "public/notification";
	}
	
	//노티피케이션 상세
	@GetMapping("public/notificationDetail/{id}")
    public String getNotification(@PathVariable("id") int id, Model model) {
		notificationService.incrementViewCount(id);
		
        Optional<NotificationDTO> notice = notificationService.getNotificationById(id);
        if (notice.isPresent()) {	
            model.addAttribute("notice", notice.get());
            return "public/notificationDetail";  // JSP 파일 이름
        } else {
            return "redirect:/public/notification";
        }
    }
	
	@Autowired
    private UserRegistService userRegistService;
	
	@PostMapping("/userJoin")
    public String userJoin(@RequestParam("name") String name,
            @RequestParam("nickname") String nickname,
            @RequestParam("id") String id,
            @RequestParam("password") String password,
            @RequestParam("phone") String phone,
            @RequestParam("emailone") String emailone,
            @RequestParam("emailtwo") String emailtwo) {
    	
    	 String email = emailone + "@" + emailtwo;

         User user = new User();
         user.setName(name);
         user.setNickname(nickname);
         user.setId(id);
         user.setPassword(password);
         user.setPhone(phone);
         user.setEmail(email);
         user.setIsAdmin(false);
         
         userRegistService.saveUser(user);

         
    	return "public/userLogin";
    }
	
	@GetMapping("/login")
    public String login() {
        return "public/userLogin";
    }
	
}
