package com.example.demo.model.userModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="bookmarks")
public class Bookmark {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOKMARK_ID")
    private Integer bookmarkId; 
	
	@Column(name = "USER_UK_ID")
    private Integer userUkId; // 사용자 ID

    @Column(name = "SHOP_UK_ID")
    private Integer shopUkId; // 식당 ID
}
