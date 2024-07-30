package com.example.demo.service.publicService;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.publicDto.NotificationDTO;

public interface NotificationService {

	List<NotificationDTO> getAllNotices();
    Optional<NotificationDTO> getNotificationById(int id);
    void saveNotice(NotificationDTO noticeDTO);
}
