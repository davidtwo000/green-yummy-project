package com.example.demo.service.userService;

import com.example.demo.model.userModel.Bookmark;

public interface BookmarkService {
	Bookmark addBookmark(Integer userUkId, Integer shopUkId);

	boolean removeBookmark(Integer userUkId, Integer shopUkId);
}
