package com.example.demo.admin.entity;

import com.example.demo.model.publicModel.Shop;
import com.example.demo.model.userModel.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
