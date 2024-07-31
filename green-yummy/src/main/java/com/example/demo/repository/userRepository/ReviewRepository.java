package com.example.demo.repository.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.userModel.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    // 추가적인 쿼리 메서드가 필요할 경우 여기에 정의
}