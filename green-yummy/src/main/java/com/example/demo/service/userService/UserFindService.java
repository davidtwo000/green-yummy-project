package com.example.demo.service.userService;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.userModel.User;
import com.example.demo.repository.userRepository.UserFindRepository;

@Service
public class UserFindService implements UserDetailsService{

	@Autowired
    private UserFindRepository userFindRepository;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        User user = userFindRepository.findById(id)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));
        return new org.springframework.security.core.userdetails.User(user.getId(), user.getPassword(), new ArrayList<>());
    }
    
    public Optional<User> findById(String id) {
        return userFindRepository.findById(id);
    }

    public boolean checkPassword(User user, String rawPassword) {
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }
}
