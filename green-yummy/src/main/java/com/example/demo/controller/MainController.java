package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "index/TMP2";
	}
	
//	@GetMapping("/")
//	public String () {
//		return "/";
//	}
	
	@GetMapping("/pictureOCR")
	public String pictureOCR() {
		return "/pictureOCR";
	}
		
	@GetMapping("/notification")
	public String notification() {
		return "/notification";
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
	
}
