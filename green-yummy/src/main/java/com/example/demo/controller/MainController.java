package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "index/TMP2";
	}
	
	//실험용
	@GetMapping("/newsfile")
	public String newFile() {
		return "public/TMP1";
	}
	
	@GetMapping("/serviceIntro")
	public String ServiceIntro() {
		return "public/serviceIntro";
	}
	
}
