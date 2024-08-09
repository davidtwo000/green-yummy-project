package com.example.demo.service.userService;

import java.util.List;

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
	
	//북마크 이미 있는지 확인
	public boolean bookmarkExists(Integer userUkId, Integer shopUkId) {
		return bookmarkRepository.existsByUserUkIdAndShopUkId(userUkId, shopUkId);
	}
	
	// 사용자 ID로 북마크 찾기
	@Override
    public List<Bookmark> getBookmarksByUserUkId(Integer userUkId) {
        return bookmarkRepository.findByUserUkId(userUkId);
    }
}
