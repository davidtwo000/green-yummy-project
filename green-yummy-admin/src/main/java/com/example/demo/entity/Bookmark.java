package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "BOOKMARKS")
@Data
public class Bookmark {
    @Id
    @ManyToOne
    @JoinColumn(name = "USER_UK_ID")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "SHOP_UK_ID")
    private Shop shop;
}
