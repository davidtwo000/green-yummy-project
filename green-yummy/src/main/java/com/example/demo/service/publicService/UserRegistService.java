package com.example.demo.service.publicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.userModel.User;
import com.example.demo.repository.publicRepository.UserRegistRepository;

@Service
public class UserRegistService {

	@Autowired
    private UserRegistRepository userRegistRepository;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
    public boolean isUserIdAvailable(String id) {
    	boolean exists = userRegistRepository.existsById(id);
    	System.out.println("User ID exists: " + exists);
        return !userRegistRepository.existsById(id);
    }

    public boolean isNicknameAvailable(String nickname) {
    	boolean exists = userRegistRepository.existsByNickname(nickname);
    	System.out.println("User ID exists: " + exists);
        return !userRegistRepository.existsByNickname(nickname);
    }
    
    public void saveUser(User user) {
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRegistRepository.save(user);
    }
}
