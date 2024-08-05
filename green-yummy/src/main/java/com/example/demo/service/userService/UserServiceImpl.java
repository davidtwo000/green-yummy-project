package com.example.demo.service.userService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.userModel.User;
import com.example.demo.repository.userRepository.UserFindRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.Collections;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class UserServiceImpl implements UserDetailsService{

	private final UserFindRepository userRepository;
	
	public UserServiceImpl(UserFindRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Attempting to load user by username: " + username);

        User user = userRepository.findById(username)
                .orElseThrow(() -> {
                    System.out.println("User not found with username: " + username);
                    return new UsernameNotFoundException("User not found");
                });

        System.out.println("User found: " + user.getId());
        System.out.println("User password: " + user.getPassword());

        return new org.springframework.security.core.userdetails.User(
                user.getId(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
    
    
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            String username = ((UserDetails) authentication.getPrincipal()).getUsername();
            return userRepository.findById(username)
                    .orElse(null);
        }
        return null;
    }
}
