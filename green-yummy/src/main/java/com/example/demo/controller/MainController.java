package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.publicDto.NotificationDTO;
import com.example.demo.service.publicService.NotificationService;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "index/index";
	}
	
	@GetMapping("/userLogin")
	public String userLogin() {
		return "/userLogin";
	}
	
	@GetMapping("/Agreement")
	public String Agreement() {
		return "/Agreement";
	}
	
	@GetMapping("/userRegist")
	public String userRegist() {
		return "/userRegist";
	}
	
	@GetMapping("/dataSearch")
	public String dataSearch() {
		return "public/dataSearch";
	}
	
	@GetMapping("/dataSearchDetail")
	public String dataSearchDetail() {
		return "public/dataSearchDetail";
	}
	
	@GetMapping("/pictureOCR")
	public String pictureOCR() {
		return "/pictureOCR";
	}
	
	@GetMapping("/usePolicy")
	public String usePolicy() {
		return "/usePolicy";
	}
	
	@GetMapping("/privacyPolicy")
	public String privacyPolicy() {
		return "/privacyPolicy";
	}
	
	@GetMapping("/serviceIntro")
	public String ServiceIntro() {
		return "public/serviceIntro";
	}
	
	//노티피케이션 (이 밑으로 notification 관련은 그냥 구현해본거. 필요 없는 기능들은 나중에 삭제할 예정)
	//GPT에 'jpa로 sql의 insert, update, select, delete 구현' 검색해서 공부해도 무관
	@Autowired
    private NotificationService notificationService;
	
	@GetMapping("/notification")
	public String notification(Model model) {
		
		List<NotificationDTO> notices = notificationService.getAllNotices();
        model.addAttribute("notices", notices);
        return "public/notification";
	}
	
	//노티피케이션 상세
	@GetMapping("/notificationDetail/{id}")
    public String getNotification(@PathVariable("id") int id, Model model) {
        Optional<NotificationDTO> notice = notificationService.getNotificationById(id);
        if (notice.isPresent()) {
            model.addAttribute("notice", notice.get());
            return "public/notificationDetail";  // JSP 파일 이름
        } else {
            return "redirect:/notification";
        }
    }
	
	//이 밑은 jpa로 생성,수정 구현해본것
    @GetMapping("/notification/new")
    public String createNotificationForm(Model model) {
        model.addAttribute("notice", new NotificationDTO());
        return "public/notificationForm";  // 폼 JSP
    }

    @PostMapping("/newNotification")
    public String saveNotification(@ModelAttribute NotificationDTO noticeDTO) {
        notificationService.saveNotice(noticeDTO);
        return "redirect:/notification";
    }
    
    @GetMapping("/notificationUpdate/{id}")
    public String updateNotification(@PathVariable("id") int id, Model model) {
    	    	
    	Optional<NotificationDTO> notice = notificationService.getNotificationById(id);
        if (notice.isPresent()) {
            model.addAttribute("notice", notice.get());
            return "public/notificationUpdate";  // JSP 파일 이름
        } else {
            return "redirect:/notification";
        } 
    }
    
    @PostMapping("/updateNotification")
    public String newsaveNotification(@ModelAttribute NotificationDTO noticeDTO) {
        notificationService.updateNotice(noticeDTO);
        return "redirect:/notification";
    }
    //여기까지가 생성-수정 기능 순
}
