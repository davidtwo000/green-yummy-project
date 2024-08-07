package com.example.demo.service.publicService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.publicDto.NotificationDTO;
import com.example.demo.model.publicModel.Notification;
import com.example.demo.repository.publicRepository.NotificationRepository;


@Service
public class NotificationServiceImpl implements NotificationService{

	@Autowired
	private NotificationRepository notificationRepository;
	
	
	@Override
	public List<NotificationDTO> getAllNotices() {
		return notificationRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@Override
	public Optional<NotificationDTO> getNotificationById(int id) {
		return notificationRepository.findById(id).map(this::convertToDto);
	}

	@Transactional
	public void incrementViewCount(int id) {
	    Optional<Notification> optionalNotification = notificationRepository.findById(id);
        Notification notification = optionalNotification.get();
        notification.setViewCount(notification.getViewCount() + 1);
        notificationRepository.save(notification);
    }
	
	private NotificationDTO convertToDto(Notification notice) {
        NotificationDTO dto = new NotificationDTO();
        dto.setNoticeId(notice.getNoticeId());
        dto.setAuthor(notice.getAuthor());
        dto.setTitle(notice.getTitle());
        dto.setContent(notice.getContent());
        dto.setPostDate(notice.getPostDate());
        dto.setViewCount(notice.getViewCount());
        return dto;
    }
	
	///
	
	public List<NotificationDTO> getNotices(int start, int pageSize) {
        return notificationRepository.findAll().stream()
                .skip(start)
                .limit(pageSize)
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public int getTotalNotices() {
        return (int) notificationRepository.count();
    }

    public List<NotificationDTO> searchNotices(String searchType, String searchKeyword, int start, int pageSize) {
        List<Notification> filteredNotices = notificationRepository.findAll().stream()
                .filter(notice -> {
                    if ("title".equals(searchType)) {
                        return notice.getTitle().contains(searchKeyword);
                    } else if ("content".equals(searchType)) {
                        return notice.getContent().contains(searchKeyword);
                    } else if ("titleContent".equals(searchType)) {
                        return notice.getTitle().contains(searchKeyword) || notice.getContent().contains(searchKeyword);
                    }
                    return false;
                })
                .collect(Collectors.toList());

        return filteredNotices.stream()
                .skip(start)
                .limit(pageSize)
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public int getSearchTotalNotices(String searchType, String searchKeyword) {
        return (int) notificationRepository.findAll().stream()
                .filter(notice -> {
                    if ("title".equals(searchType)) {
                        return notice.getTitle().contains(searchKeyword);
                    } else if ("content".equals(searchType)) {
                        return notice.getContent().contains(searchKeyword);
                    } else if ("titleContent".equals(searchType)) {
                        return notice.getTitle().contains(searchKeyword) || notice.getContent().contains(searchKeyword);
                    }
                    return false;
                })
                .count();
    }
}
