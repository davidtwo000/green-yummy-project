package com.example.demo.admin.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnnounceDTO {

	private Integer noticeId;
    private String author;
    private String title;
    private String content;
    private LocalDateTime postDate;
    private Integer viewCount;
}
	