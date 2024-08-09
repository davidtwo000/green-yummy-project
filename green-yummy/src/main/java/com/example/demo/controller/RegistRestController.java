package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.publicService.FindIdPasswordService;
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
	
    @GetMapping("/checkEmail")
    public ResponseEntity<Boolean> checkEmail(@RequestParam(name="email") String email){
    	boolean isEmailAvailable = userRegistService.isEmailAvailable(email);
    	return ResponseEntity.ok(isEmailAvailable);
    }
    
    @Autowired
    private FindIdPasswordService userService;
    
    @PostMapping("/findId")
    public ResponseEntity<String> findId(@RequestParam(name = "idPhone") String idPhone, 
                         @RequestParam(name = "idEmail") String idEmail) {
        Optional<String> userId = userService.findIdByPhoneAndEmail(idPhone, idEmail);

        String message = userId.map(id -> "당신의 아이디는 :  " + id + "  입니다.")
                .orElse("정보와 일치하는 아이디가 없습니다.");
        return ResponseEntity.ok(message);
    }

    @PostMapping("/resetPassword")
    public ResponseEntity<String> resetPassword(@RequestParam(name = "pswdEmail") String pswdEmail, 
    					@RequestParam(name = "useId") String useId) {
        Optional<String> newPassword = userService.resetPasswordByEmailAndId(useId, pswdEmail);

        String message = newPassword.map(password -> "임시 비밀번호는  " + password + "  입니다.\n로그인 후 정보 수정에서 비밀번호를 재설정하세요.")
                .orElse("정보와 일치하는 아이디가 없습니다.");
        return ResponseEntity.ok(message);
    }
    
}
