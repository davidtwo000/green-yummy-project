package com.example.demo.dto.userDto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.publicDto.ShopDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDTO {

    private Integer reviewId; // 리뷰 ID
    private Integer userUkId; // 사용자 ID
    private Integer shopUkId; // 식당 ID
    private Byte reviewRating; // 리뷰 평점 (1~5 범위)
    private String reviewComment; // 리뷰 코멘트
    private String reviewContent; // 리뷰 내용
    private LocalDateTime reviewDate; // 리뷰 작성 날짜
    private String reviewImg; //리뷰 사진
    
    private ShopDTO shop;
    private UserDTO user;
}
