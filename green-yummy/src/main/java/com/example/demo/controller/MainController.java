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
		return "/dataSearch";
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
	
	@Autowired
    private NotificationService notificationService;
	
	@GetMapping("/notification")
	public String notification(Model model) {
		
		List<NotificationDTO> notices = notificationService.getAllNotices();
        model.addAttribute("notices", notices);
        return "public/notification";
	}
	
	//
	

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
    
}
