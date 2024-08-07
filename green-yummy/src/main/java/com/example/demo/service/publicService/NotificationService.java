package com.example.demo.service.publicService;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.publicDto.NotificationDTO;

public interface NotificationService {

	List<NotificationDTO> getAllNotices();
    Optional<NotificationDTO> getNotificationById(int id);
    void incrementViewCount(int id);
    
    List<NotificationDTO> getNotices(int start, int pageSize);
    int getTotalNotices();
    List<NotificationDTO> searchNotices(String searchType, String searchKeyword, int start, int pageSize);
    int getSearchTotalNotices(String searchType, String searchKeyword);
}
