package com.example.demo.repository.userRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.publicModel.Shop;
import com.example.demo.model.userModel.Bookmark;
import com.example.demo.model.userModel.Review;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Integer> {

	// 중복 확인
	boolean existsByUserUkIdAndShopUkId(Integer userUkId, Integer shopUkId);

	int deleteByUserUkIdAndShopUkId(Integer userUkId, Integer shopUkId);
	
	List<Bookmark> findByUserUkId(Integer userUkId);
	
	
}