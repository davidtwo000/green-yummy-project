package com.example.demo.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.adminModel.Application;
import com.example.demo.repository.userRepository.ShopApplyRepository;

@Service
public class ShopApplyService {

	@Autowired
    private ShopApplyRepository shopApplyRepository;

    public void saveApplication(Application application) {
        shopApplyRepository.save(application);
    }
}
