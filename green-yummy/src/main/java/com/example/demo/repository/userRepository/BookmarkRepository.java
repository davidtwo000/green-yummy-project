package com.example.demo.repository.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.userModel.Bookmark;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Integer> {
	
	//중복 확인
	boolean existsByUserUkIdAndShopUkId(Integer userUkId, Integer shopUkId);
}