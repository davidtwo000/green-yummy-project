
-- 데이터베이스 선택
use yummy;

-- 테이블 삭제 (제약조건 포함)
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS SHOPS;
DROP TABLE IF EXISTS REVIEWS;
DROP TABLE IF EXISTS SHOP_PHOTOS;
DROP TABLE IF EXISTS BOOKMARKS;
DROP TABLE IF EXISTS REVIEWLIKES;
DROP TABLE IF EXISTS notifications;
DROP TABLE IF EXISTS applications;

-- 사용자
CREATE TABLE USERS (
    USER_UK_ID INT AUTO_INCREMENT PRIMARY KEY, -- 사용자 식별자
    ID VARCHAR(20) UNIQUE, -- ID
    NICKNAME VARCHAR(20), -- 닉네임
    PASSWORD VARCHAR(50), -- 비밀번호
    NAME VARCHAR(20), -- 이름
    EMAIL VARCHAR(50) UNIQUE, -- 이메일
    PHONE VARCHAR(20), -- 사용자 전화번호
    PROFILE VARCHAR(20), -- 프로필 사진
    IS_ADMIN TINYINT(1) DEFAULT 0 -- 관리자 여부 (0: 일반 사용자, 1: 관리자)
);

-- 식당
CREATE TABLE SHOPS (
    SHOP_UK_ID INT AUTO_INCREMENT PRIMARY KEY, -- 식당 식별자
    SHOP_NAME VARCHAR(50), -- 식당 이름
    SHOP_PROFILE VARCHAR(20), -- 식당 프로필 사진
    SHOP_TYPE VARCHAR(20), -- 식당 타입 (한식, 중식, 양식 등)
    LOCATION VARCHAR(100), -- 식당 위치
    SHOP_TEL VARCHAR(20), -- 식당 전화번호
    OPEN_HOURS VARCHAR(20), -- 식당 오픈 시간
    CLOSE_HOURS VARCHAR(20), -- 식당 닫는 시간
    CLOSED_DAYS VARCHAR(50), -- 식당 휴무일
    ETC VARCHAR(100), -- 기타 사항
    LATITUDE DECIMAL(9, 6), -- 위도
    LONGITUDE DECIMAL(9, 6) -- 경도
);

-- 리뷰
CREATE TABLE REVIEWS (
    REVIEW_ID INT AUTO_INCREMENT PRIMARY KEY, -- 리뷰 ID
    USER_UK_ID INT, -- 사용자 ID
    SHOP_UK_ID INT, -- 식당 ID
    REVIEW_RATING TINYINT, -- 리뷰 평점 (1~5 범위로 설정할 수 있음)
    REVIEW_COMMENT VARCHAR(50), -- 리뷰 코멘트
    REVIEW_CONTENT TEXT, -- 리뷰 내용
    REVIEW_IMG VARCHAR(36), -- 리뷰 PATH
    REVIEW_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 리뷰 작성 날짜
    FOREIGN KEY (USER_UK_ID) REFERENCES USERS(USER_UK_ID),
    FOREIGN KEY (SHOP_UK_ID) REFERENCES SHOPS(SHOP_UK_ID)
);

-- 가게 사진
CREATE TABLE SHOP_PHOTOS (
	SHOP_PHOTOS_ID INT AUTO_INCREMENT PRIMARY KEY,
	SHOP_UK_ID INT, -- 가게 ID
	SHOP_PHOTO_PATH VARCHAR(200), -- 사진 경로
	FOREIGN KEY (SHOP_UK_ID) REFERENCES SHOPS(SHOP_UK_ID)
);

-- 가게 북마크
CREATE TABLE BOOKMARKS (
    USER_UK_ID INT, -- 사용자 ID
    SHOP_UK_ID INT, -- 식당 ID
    FOREIGN KEY (USER_UK_ID) REFERENCES USERS(USER_UK_ID),
    FOREIGN KEY (SHOP_UK_ID) REFERENCES SHOPS(SHOP_UK_ID),
    PRIMARY KEY (USER_UK_ID, SHOP_UK_ID)
);

-- 리뷰 좋아요
CREATE TABLE REVIEWLIKES (
    USER_UK_ID INT, -- 사용자 ID
    REVIEW_ID INT, -- 리뷰 ID
    FOREIGN KEY (USER_UK_ID) REFERENCES USERS(USER_UK_ID),
    FOREIGN KEY (REVIEW_ID) REFERENCES REVIEWS(REVIEW_ID),
    PRIMARY KEY (USER_UK_ID, REVIEW_ID)
);

-- 공지사항
CREATE TABLE NOTIFICATIONS (
	notice_id INT auto_increment primary key,	
	author VARCHAR(30) NOT NULL,
	title VARCHAR(100) NOT NULL,
	content TEXT NOT NULL,
	post_date DATETIME DEFAULT CURRENT_TIMESTAMP,
	view_count INT DEFAULT 0	
);

-- 가게 신청하기
CREATE TABLE applications (
    application_id INT AUTO_INCREMENT PRIMARY KEY,  -- 신청 ID
    application_shop_name VARCHAR(50),              -- 상점 이름
    application_shop_type VARCHAR(20),              -- 상점 유형
    application_shop_location VARCHAR(100),         -- 상점 위치
    application_reason VARCHAR(100),                -- 신청 이유
    application_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 신청 날짜
    application_status ENUM('PENDING', 'APPROVED', 'REJECTED') DEFAULT 'PENDING', -- 신청 상태
    user_uk_id INT,                                 -- 사용자 ID
    FOREIGN KEY (user_uk_id) REFERENCES USERS(user_uk_id) -- 외래 키 참조 (USERS 테이블)
);