package com.example.demo.dto.publicDto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class notificationDTO {
	
	private int notice_id;
	private String author;
	private String title;
	private String content;
	private LocalDate postDate;
	private int viewCount;

}
