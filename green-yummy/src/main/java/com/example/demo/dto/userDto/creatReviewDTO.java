package com.example.demo.dto.userDto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class creatReviewDTO {
	private Integer userUkId;          // 사용자 ID
    private Integer restaurantUkId;    // 식당 ID
    private Byte reviewRate;           // 리뷰 평점 (1~5 범위)
    private String reviewComment;      // 리뷰 코멘트
    private String reviewContent;      // 리뷰 내용
    private LocalDateTime reviewDate;  // 리뷰 작성 날짜 (TIMESTAMP)

}