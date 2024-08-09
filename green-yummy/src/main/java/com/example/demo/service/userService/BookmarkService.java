package com.example.demo.service.userService;

import java.util.List;

import com.example.demo.model.userModel.Bookmark;

public interface BookmarkService {
	Bookmark addBookmark(Integer userUkId, Integer shopUkId);

	boolean removeBookmark(Integer userUkId, Integer shopUkId);
	
	boolean bookmarkExists(Integer userUkId, Integer shopUkId);

	List<Bookmark> getBookmarksByUserUkId(Integer userUkId);
	
}
