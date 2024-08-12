package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.AnnounceDTO;
import com.example.demo.dto.RequestDTO;
import com.example.demo.dto.ReviewDTO;
import com.example.demo.dto.ShopDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Application;
import com.example.demo.entity.ApplicationStatus;
import com.example.demo.entity.Notification;
import com.example.demo.entity.Shop;
import com.example.demo.entity.User;
import com.example.demo.exception.SessionNotFoundException;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.AnnounceRepository;
import com.example.demo.repository.RequestRepository;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.repository.ShopRepository;

@Service
public class AdminService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private AnnounceRepository announceRepository;
    
    @Autowired
    private RequestRepository requestRepository;
    
    @Autowired
    private ReviewRepository reviewRepository;
    
    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private AdminMapper adminMapper;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 사용자 이름으로 데이터베이스에서 사용자 찾기
        User user = adminRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username));

        // UserDetails 객체로 변환하여 반환
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getId())
                .password(user.getPassword())
                .roles(user.isAdmin() ? "ADMIN" : "USER")
                .build();
    }

    // 모든 유저목록 가져오기
    public List<UserDTO> getUserInfo() {
        List<User> users = adminRepository.findAll();

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
    
 	// 모든 가게목록 가져오기
    public List<ShopDTO> getShopInfo() {
    	List<Shop> shop = shopRepository.findAll();
        return adminMapper.toShopDTOList(shop);
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
    
    // ID로 특정 가게 가져오기    
    public ShopDTO getShopById(Integer id) {
    	return adminMapper.toDTO(shopRepository.findById(id).get());
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
    
    // 신청 업데이트
    public void updateRequest(Integer id, String status) {
    	Application application = requestRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Notification not found with id: " + id));

        // 신청내역 내용 업데이트
    	if(status.equals("PENDING"))
    		application.setApplicationStatus(ApplicationStatus.PENDING);
    	else if(status.equals("APPROVED"))
    		application.setApplicationStatus(ApplicationStatus.APPROVED);
    	else if(status.equals("REJECTED"))
    		application.setApplicationStatus(ApplicationStatus.REJECTED);

        // 데이터베이스에 저장
        requestRepository.save(application);
    }
    
    // 가게 업데이트
    public void updateShop(int id, String shopName, String shopType, String location, String shopTel, String openHours, String closeHours, String closedDays, MultipartFile shopProfileFile) {
        Shop shop = shopRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Shop not found with id: " + id));

        // 각 필드에 대한 값을 설정
        shop.setShopName(shopName);
        shop.setShopType(shopType);
        shop.setLocation(location);
        shop.setShopTel(shopTel);
        shop.setOpenHours(openHours);
        shop.setCloseHours(closeHours);
        shop.setClosedDays(closedDays);
        if (!shopProfileFile.isEmpty()) {
            try {
                String uploadDirectory = "D:/STS4/sts4-workspace/green-yummy-admin/src/main/resources/static/admin/images/";
                String fileName = shopProfileFile.getOriginalFilename();
                shopProfileFile.transferTo(new File(uploadDirectory + fileName));
                shop.setShopProfile(fileName);
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 데이터베이스에 저장
        shopRepository.save(shop);
    }

    
    // 공지 생성
    public void createAnnounce(String title, String content) {
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
            throw new SessionNotFoundException("Session not found or user is not authenticated");
        }

        String author = authentication.getName();
        LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0);
    	Notification notification = new Notification();
    	notification.setAuthor(author);
    	notification.setTitle(title);
    	notification.setContent(content);
    	notification.setPostDate(now);
    	notification.setViewCount(0);
    	announceRepository.save(notification);
    	
    }
    
    // 가게 생성
    public void createShop(MultipartFile shopProfileFile, String shopName, String shopType, String location, String shopTel, String openHours, String closeHours, String closedDays) {
    	
    	if (!shopProfileFile.isEmpty()) {
            try {
                String uploadDirectory = "D:/STS4/sts4-workspace/green-yummy-admin/src/main/resources/static/admin/images/";
                String fileName = shopProfileFile.getOriginalFilename();
                shopProfileFile.transferTo(new File(uploadDirectory + fileName));
                Shop shop = new Shop();
                shop.setShopName(shopName);
                shop.setShopType(shopType);
                shop.setLocation(location);
                shop.setShopTel(shopTel);
                shop.setOpenHours(openHours);
                shop.setCloseHours(closeHours);
                shop.setClosedDays(closedDays);
                shop.setShopProfile(fileName);
                
                // 데이터베이스에 저장
                shopRepository.save(shop);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    	
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
    
    // 가게 삭제
    public void deleteShop(Integer id) {
    	shopRepository.deleteById(id);
    }
    
    // 유저 검색
    public List<UserDTO> searchUser(String search, String searchType){
    	List<User> users = new ArrayList<>();
    	if(searchType.equals("total"))
    		users = adminRepository.searchByKeyword(search);
    	else if(searchType.equals("id"))
    		users = adminRepository.findByIdContaining(search);
    	else if(searchType.equals("name"))
    		users = adminRepository.findByNameContaining(search);
    	else if(searchType.equals("phone"))
    		users = adminRepository.findByPhoneContaining(search);
    	
    	return adminMapper.toUserDTOList(users);
    }
    
    // 공지 검색
    public List<AnnounceDTO> searchAnnounce(String search, String searchType){
    	List<Notification> announce = new ArrayList<>();
    	if(searchType.equals("total"))
    		announce = announceRepository.searchByKeyword(search);
    	else if(searchType.equals("author"))
    		announce = announceRepository.findByAuthorContaining(search);
    	else if(searchType.equals("title"))
    		announce = announceRepository.findByTitleContaining(search);
    	else if(searchType.equals("postDate"))
    		announce = announceRepository.findByFormattedPostDateContaining(search);
    	
    	return adminMapper.toAnnounceDTOList(announce);
    }
    
    // 리뷰 검색
    public List<ReviewDTO> searchReview(String search, String searchType){
    	List<ReviewDTO> review = new ArrayList<>();
    	if(searchType.equals("total"))
    		review = reviewRepository.searchByKeyword(search);
    	else if(searchType.equals("id"))
    		review = reviewRepository.findByUserUkIdContaining(search);
    	else if(searchType.equals("name"))
    		review = reviewRepository.findByShopNameContaining(search);
    	else if(searchType.equals("rate"))
    		review = reviewRepository.findByReviewRating(search);
    	
    	return review;
    }
    
    // 신청 검색
    public List<RequestDTO> searchRequest(String search, String searchType){
    	List<RequestDTO> request = new ArrayList<>();
    	if(searchType.equals("total"))
    		request = requestRepository.searchByKeyword(search);
    	else if(searchType.equals("id"))
    		request = requestRepository.findApplicationsByUserId(search);
    	else if(searchType.equals("name"))
    		request = requestRepository.findApplicationsByShopName(search);
    	else if(searchType.equals("type")) {
    		request = requestRepository.findApplicationsByShopType(search);
    	}
    	
    	return request;
    }
    
    public List<RequestDTO> sortRequest(String status){
    	List<RequestDTO> request = new ArrayList<>();
    	if(status.equals("PENDING"))
    		request = requestRepository.findApplicationsByStatus(ApplicationStatus.PENDING);
    	else if(status.equals("APPROVED"))
    		request = requestRepository.findApplicationsByStatus(ApplicationStatus.APPROVED);
    	else if(status.equals("REJECTED"))
    		request = requestRepository.findApplicationsByStatus(ApplicationStatus.REJECTED);
    	
    	return request;
    }
    
 	// 가게 검색
    public List<ShopDTO> searchShop(String search, String searchType){
    	List<Shop> shop = new ArrayList<>();
    	if(searchType.equals("total"))
    		shop = shopRepository.searchByKeyword(search);
    	else if(searchType.equals("name"))
    		shop = shopRepository.findByShopNameContaining(search);
    	else if(searchType.equals("type"))
    		shop = shopRepository.findByShopTypeContaining(search);
    	else if(searchType.equals("location")) {
    		shop = shopRepository.findByLocationContaining(search);
    	}
    	
    	return adminMapper.toShopDTOList(shop);
    }
}
