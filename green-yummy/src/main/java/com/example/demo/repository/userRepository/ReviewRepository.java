package com.example.demo.repository.userRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.userDto.ReviewDTO;
import com.example.demo.model.publicModel.Shop;
import com.example.demo.model.userModel.Review;
import com.example.demo.model.userModel.User;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	//가게별 리뷰 추출하기
	List<Review> findByShopUkId(Integer shopUkId);
	
	//내가 작성한 리뷰
	List<Review> findByUserUkId(Integer userUkId);
	
	// 특정 가게 ID에 대한 모든 리뷰 조회
    @Query("SELECT r FROM Review r WHERE r.shopUkId = :shopUkId")
    List<Review> findAllByShopUkId(@Param("shopUkId") Integer shopUkId);

    // 특정 가게 ID에 대한 리뷰 평점의 평균 계산
    @Query("SELECT AVG(r.reviewRating) FROM Review r WHERE r.shopUkId = :shopUkId")
    Double findAverageRatingByShopUkId(@Param("shopUkId") Integer shopUkId);

    
    Page<Review> findByShopUkId(Integer shopUkId, Pageable pageable);
    
    //리뷰 이미 적으면 못적게
    boolean existsByShopUkIdAndUserUkId(Integer shopUkId, Integer userUkId);

}