package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.dto.AnnounceDTO;
import com.example.demo.dto.ShopDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Notification;
import com.example.demo.entity.Shop;
import com.example.demo.entity.User;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    // User 관련 메서드
    UserDTO toDTO(User user);
    List<UserDTO> toUserDTOList(List<User> users);

    // Announce 관련 메서드
    AnnounceDTO toDTO(Notification notification);
    List<AnnounceDTO> toAnnounceDTOList(List<Notification> notification);

    // Shop 관련 메서드
    ShopDTO toDTO(Shop shop);
    List<ShopDTO> toShopDTOList(List<Shop> shop);

}
