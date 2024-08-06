package com.example.demo.service.publicService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.publicDto.NotificationDTO;
import com.example.demo.model.publicModel.Notification;
import com.example.demo.repository.publicRepository.NotificationRepository;

import jakarta.persistence.EntityNotFoundException;

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

	/*
	@Override
	public void saveNotice(NotificationDTO noticeDTO) {
		Notification notice = convertToEntity(noticeDTO);
        notificationRepository.save(notice);
	}
	
	@Override
	public void updateNotice(NotificationDTO noticeDTO) {
		System.out.println("Notice ID: " + noticeDTO.getNoticeId());
		
        // 기존 엔티티를 데이터베이스에서 조회
        Optional<Notification> existingNotification = notificationRepository.findById(noticeDTO.getNoticeId());

        if (existingNotification.isPresent()) {
            Notification notice = existingNotification.get();
            // DTO에서 수정된 값으로 엔티티 업데이트
            notice.setAuthor(noticeDTO.getAuthor());
            notice.setTitle(noticeDTO.getTitle());
            notice.setViewCount(noticeDTO.getViewCount());
            // 변경된 엔티티를 저장
            notificationRepository.save(notice);
        }else {
        	throw new EntityNotFoundException("Notification not found with id: " + noticeDTO.getNoticeId());
        }
    }
	*/
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

    private Notification convertToEntity(NotificationDTO dto) {
        Notification notice = new Notification();
        notice.setNoticeId(dto.getNoticeId());
        notice.setAuthor(dto.getAuthor());
        notice.setTitle(dto.getTitle());
        notice.setContent(dto.getContent());
        notice.setPostDate(dto.getPostDate());
        notice.setViewCount(dto.getViewCount());
        return notice;
    }
}
