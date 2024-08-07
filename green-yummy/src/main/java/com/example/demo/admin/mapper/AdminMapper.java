package com.example.demo.admin.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.admin.dto.AnnounceDTO;
import com.example.demo.admin.dto.UserDTO;
import com.example.demo.model.publicModel.Notification;
import com.example.demo.model.userModel.User;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    // User 관련 메서드
    UserDTO toDTO(User user);
    List<UserDTO> toUserDTOList(List<User> users);

    // Announce 관련 메서드
    AnnounceDTO toDTO(Notification notification);
    List<AnnounceDTO> toAnnounceDTOList(List<Notification> notification);

}
