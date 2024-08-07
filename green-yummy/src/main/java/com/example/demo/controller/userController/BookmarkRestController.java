package com.example.demo.controller.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.userModel.Bookmark;
import com.example.demo.service.userService.BookmarkService;

@RestController
@RequestMapping("/bookmark")
public class BookmarkRestController {
	
	@Autowired
    private BookmarkService bookmarkService;
	
	@PostMapping("/add/{userUkId}/{shopUkId}")
	public ResponseEntity<String> addBookmark(@PathVariable("userUkId") Integer userUkId,
	                                           @PathVariable("shopUkId") Integer shopUkId) {
		try {
            Bookmark bookmark = bookmarkService.addBookmark(userUkId, shopUkId);
            return ResponseEntity.ok("북마크가 저장되었습니다.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
	}
}
