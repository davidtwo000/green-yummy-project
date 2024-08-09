package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AnnounceDTO {

	private Integer noticeId;
    private String author;
    private String title;
    private String content;
    private LocalDateTime postDate;
    private Integer viewCount;
}
	