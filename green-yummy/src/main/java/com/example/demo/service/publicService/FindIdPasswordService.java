package com.example.demo.service.publicService;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.userModel.User;
import com.example.demo.repository.userRepository.UserFindRepository;

@Service
public class FindIdPasswordService {

	@Autowired
    private UserFindRepository userRepository;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public Optional<String> findIdByPhoneAndEmail(String phone, String email) {
		Optional<User> userOpti = userRepository.findByPhoneAndEmail(phone, email);
		
		if (userOpti.isPresent()) {
            User user = userOpti.get();
            String userId = user.getId();

            return Optional.of(userId);
        }
		
        return Optional.empty();
    }

    public Optional<String> resetPasswordByEmailAndId(String id, String email) {
    	Optional<User> userOpt = userRepository.findByIdAndEmail(id, email);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            String rawPassword = UUID.randomUUID().toString().substring(0, 8); // 새 비밀번호 생성 (8자리)
            String encodedPassword = passwordEncoder.encode(rawPassword); // 비밀번호 해싱

            user.setPassword(encodedPassword); // 해싱된 비밀번호 저장
            userRepository.save(user);

            return Optional.of(rawPassword); // 해싱되지 않은 비밀번호 반환
        }

        return Optional.empty();
    }
}
