package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.userModel.User;
import com.example.demo.service.publicService.UserRegistService;

@RestController
public class RegistRestController {

	@Autowired
    private UserRegistService userRegistService;

    @GetMapping("/checkUserId")
    public ResponseEntity<Boolean> checkUserId(@RequestParam(name="userId") String userId) {
        boolean isUserIdAvailable = userRegistService.isUserIdAvailable(userId);
        //System.out.println("Is User ID Available: " + isUserIdAvailable);
        return ResponseEntity.ok(isUserIdAvailable);
    }

    @GetMapping("/checkNickname")
    public ResponseEntity<Boolean> checkNickname(@RequestParam(name="nickname") String nickname) {
        boolean isNicknameAvailable = userRegistService.isNicknameAvailable(nickname);
        //System.out.println("Is User ID Available: " + isNicknameAvailable);
        return ResponseEntity.ok(isNicknameAvailable);
    }
	
    
    
}
