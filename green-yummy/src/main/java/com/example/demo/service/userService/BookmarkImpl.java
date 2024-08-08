package com.example.demo.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.userModel.Bookmark;
import com.example.demo.repository.userRepository.BookmarkRepository;

@Service
public class BookmarkImpl implements BookmarkService {
	
	@Autowired
    private BookmarkRepository bookmarkRepository;
	
	public Bookmark addBookmark(Integer userUkId, Integer shopUkId) {
		
		boolean exists = bookmarkRepository.existsByUserUkIdAndShopUkId(userUkId, shopUkId);
		if (exists) {
            throw new IllegalArgumentException("이미 컬랙션에 있습니다.");
        }
		
        Bookmark bookmark = new Bookmark();
        bookmark.setUserUkId(userUkId);
        bookmark.setShopUkId(shopUkId);
        return bookmarkRepository.save(bookmark);
    }

	@Transactional
	public boolean removeBookmark(Integer userUkId, Integer shopUkId) {
		return bookmarkRepository.deleteByUserUkIdAndShopUkId(userUkId, shopUkId) > 0;
	}
	
	
}
