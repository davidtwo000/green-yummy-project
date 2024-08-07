package com.example.demo.admin.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.admin.dto.AnnounceDTO;
import com.example.demo.admin.dto.RequestDTO;
import com.example.demo.admin.dto.ReviewDTO;
import com.example.demo.admin.dto.UserDTO;
import com.example.demo.admin.mapper.AdminMapper;
import com.example.demo.admin.repository.AdminRepository;
import com.example.demo.admin.repository.AnnounceRepository;
import com.example.demo.admin.repository.RequestRepository;
import com.example.demo.admin.repository.ReviewRepository;
import com.example.demo.model.publicModel.Notification;
import com.example.demo.model.userModel.User;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private AnnounceRepository announceRepository;
    
    @Autowired
    private RequestRepository requestRepository;
    
    @Autowired
    @Qualifier("AdminReview")
    private ReviewRepository reviewRepository;

    @Autowired
    private AdminMapper adminMapper;

    // 모든 유저목록 가져오기
    public List<UserDTO> getUserInfo() {
        // User 엔티티 리스트를 가져오기
        List<User> users = adminRepository.findAll();

        // User 엔티티 리스트를 UserDTO 리스트로 변환하여 반환
        return adminMapper.toUserDTOList(users);
    }
    
    // 모든 공지사항 가져오기
    public List<AnnounceDTO> getAnnounceInfo() {
        List<Notification> announce = announceRepository.findAll();

        return adminMapper.toAnnounceDTOList(announce);
    }
    
    // 모든 신청내역 가져오기
    public List<RequestDTO> getRequestInfo() {
        return requestRepository.findAllApplicationsWithUserId();
    }
    
    // 모든 리뷰내역 가져오기
    public List<ReviewDTO> getReviewInfo() {
        return reviewRepository.findAllReviewsWithUserAndShop();
    }

    // ID로 특정 유저 가져오기
    public UserDTO getUserById(Integer id) {
        return adminMapper.toDTO(adminRepository.findById(id).get());
    }
    
    // ID로 특정 공지 가져오기
    public AnnounceDTO getAnnounceById(Integer id) {
        return adminMapper.toDTO(announceRepository.findById(id).get());
    }
    
    // ID로 특정 리뷰 가져오기    
    public ReviewDTO getReviewById(Integer id) {
        return reviewRepository.findReviewById(id);
    }
    
    // ID로 특정 신청 가져오기    
    public RequestDTO getRequestById(Integer id) {
        return requestRepository.findRequestById(id);
    }

    // 공지 업데이트	
    public void updateAnnounce(Integer id, String title, String content) {
    	Notification notification = announceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Notification not found with id: " + id));

        // 공지사항 내용 업데이트
        notification.setTitle(title);
        notification.setContent(content);

        // 데이터베이스에 저장
        announceRepository.save(notification);
    }
    
    public void createAnnounce(String title, String content) {
    	
//    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
//            throw new SessionNotFoundException("Session not found or user is not authenticated");
//        }
//
//        String author = authentication.getName();
        
    	Notification notification = new Notification();
//    	notification.setAuthor(author);
    	notification.setTitle(title);
    	notification.setContent(content);
    	
    	announceRepository.save(notification);
    	
    }

    // 유저 삭제
    public void deleteUser(Integer id) {
        adminRepository.deleteById(id);
    }
    
    // 공지 삭제
    public void deleteAnnounce(Integer id) {
    	announceRepository.deleteById(id);
    }
    
    // 신청 삭제
    public void deleteRequest(Integer id) {
    	requestRepository.deleteById(id);
    }
    
    // 리뷰 삭제
    public void deleteReview(Integer id) {
    	reviewRepository.deleteById(id);
    }
}
