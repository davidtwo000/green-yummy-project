package com.example.demo.controller.userController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.publicDto.ShopDTO;
import com.example.demo.model.publicModel.Shop;
import com.example.demo.model.userModel.Bookmark;
import com.example.demo.service.publicService.ShopService;
import com.example.demo.service.userService.BookmarkService;

@RestController
@RequestMapping("/bookmark")
public class BookmarkRestController {

	@Autowired
	private BookmarkService bookmarkService;

	@Autowired
	private ShopService shopService;

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

	@DeleteMapping("/remove/{userUkId}/{shopUkId}")
	public ResponseEntity<String> removeBookmark(@PathVariable("userUkId") Integer userUkId,
			@PathVariable("shopUkId") Integer shopUkId) {
		try {
			boolean removed = bookmarkService.removeBookmark(userUkId, shopUkId);
			if (removed) {
				return ResponseEntity.ok("북마크가 제거되었습니다.");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("북마크를 찾을 수 없습니다.");
			}
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	// 북마크 이미 있는지
	@GetMapping("/exists/{userUkId}/{shopUkId}")
	public boolean checkBookmark(@PathVariable("userUkId") Integer userUkId,
			@PathVariable("shopUkId") Integer shopUkId) {
		return bookmarkService.bookmarkExists(userUkId, shopUkId);
	}

	@GetMapping("/mybookmark/{userUkId}")
	public ResponseEntity<List<ShopDTO>> getUserBookmarksShops(@PathVariable("userUkId") Integer userUkId) {
		List<Bookmark> bookmarks = bookmarkService.getBookmarksByUserUkId(userUkId);
		List<Integer> shopUkIds = bookmarks.stream().map(Bookmark::getShopUkId).collect(Collectors.toList());

		List<ShopDTO> shops;
		if (!shopUkIds.isEmpty()) {
			shops = shopUkIds.stream().map(shopService::getShopByUkId).filter(shop -> shop != null) // Null 값 필터링
					.collect(Collectors.toList());
		} else {
			shops = List.of();
		}

		return ResponseEntity.ok(shops);
	}

}
