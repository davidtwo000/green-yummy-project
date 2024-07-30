package com.example.demo.dto.publicDto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationDTO {

	private int noticeId;
	private String author;
	private String title;
	private String content;
	private LocalDate postDate;
	private int viewCount;

}
