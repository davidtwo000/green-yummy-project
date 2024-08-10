
-- 데이터베이스 선택
use yummy;

-- 테이블 삭제 (제약조건 포함)

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS REVIEWLIKES;
DROP TABLE IF EXISTS BOOKMARKS;
DROP TABLE IF EXISTS SHOP_PHOTOS;
DROP TABLE IF EXISTS REVIEWS;
DROP TABLE IF EXISTS SHOPS;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS NOTIFICATIONS;
DROP TABLE IF EXISTS APPLICATIONS;

SET FOREIGN_KEY_CHECKS = 1;



-- 사용자
CREATE TABLE USERS (
    USER_UK_ID INT AUTO_INCREMENT PRIMARY KEY, -- 사용자 식별자
    ID VARCHAR(20) UNIQUE, -- ID
    NICKNAME VARCHAR(20), -- 닉네임
    PASSWORD VARCHAR(100), -- 비밀번호
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
    LATITUDE DECIMAL(16, 12), -- 위도
    LONGITUDE DECIMAL(16, 12) -- 경도
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
    FOREIGN KEY (USER_UK_ID) REFERENCES USERS(USER_UK_ID) ON DELETE CASCADE,
    FOREIGN KEY (SHOP_UK_ID) REFERENCES SHOPS(SHOP_UK_ID) ON DELETE CASCADE
);

-- 가게 사진
CREATE TABLE SHOP_PHOTOS (
    SHOP_PHOTOS_ID INT AUTO_INCREMENT PRIMARY KEY,
    SHOP_UK_ID INT, -- 가게 ID
    SHOP_MENU_PHOTO VARCHAR(200), -- 메뉴 사진
    SHOP_PHOTO_FIR VARCHAR(200), -- 첫 번째 사진
    SHOP_PHOTO_SEC VARCHAR(200), -- 두 번째 사진
    SHOP_PHOTO_THR VARCHAR(200), -- 세 번째 사진
    FOREIGN KEY (SHOP_UK_ID) REFERENCES SHOPS(SHOP_UK_ID) ON DELETE CASCADE
);

-- 가게 북마크
CREATE TABLE BOOKMARKS (
    BOOKMARK_ID INT AUTO_INCREMENT PRIMARY KEY, 
    USER_UK_ID INT, -- 사용자 ID
    SHOP_UK_ID INT, -- 식당 ID
    FOREIGN KEY (USER_UK_ID) REFERENCES USERS(USER_UK_ID) ON DELETE CASCADE,
    FOREIGN KEY (SHOP_UK_ID) REFERENCES SHOPS(SHOP_UK_ID) ON DELETE CASCADE
);

-- 리뷰 좋아요
CREATE TABLE REVIEWLIKES (
    REVIEWLIKE_ID INT AUTO_INCREMENT PRIMARY KEY, -- 기본 키 수정
    USER_UK_ID INT, -- 사용자 ID
    REVIEW_ID INT, -- 리뷰 ID
    FOREIGN KEY (USER_UK_ID) REFERENCES USERS(USER_UK_ID) ON DELETE CASCADE,
    FOREIGN KEY (REVIEW_ID) REFERENCES REVIEWS(REVIEW_ID) ON DELETE CASCADE
);

-- 공지사항
CREATE TABLE NOTIFICATIONS (
    NOTICE_ID INT AUTO_INCREMENT PRIMARY KEY,	
    AUTHOR VARCHAR(30) NOT NULL,
    TITLE VARCHAR(100) NOT NULL,
    CONTENT TEXT NOT NULL,
    POST_DATE DATETIME DEFAULT CURRENT_TIMESTAMP,
    VIEW_COUNT INT DEFAULT 0	
);

-- 가게 신청하기
CREATE TABLE APPLICATIONS (
    APPLICATION_ID INT AUTO_INCREMENT PRIMARY KEY,  -- 신청 ID
    APPLICATION_SHOP_NAME VARCHAR(50),              -- 상점 이름
    APPLICATION_SHOP_TYPE VARCHAR(20),              -- 상점 유형
    APPLICATION_SHOP_LOCATION VARCHAR(100),         -- 상점 위치
    APPLICATION_REASON VARCHAR(300),                -- 신청 이유
    APPLICATION_SHOP_PHONE VARCHAR(20),             -- 해당 가게 전화 번호
    APPLICATION_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 신청 날짜
    APPLICATION_STATUS ENUM('PENDING', 'APPROVED', 'REJECTED') DEFAULT 'PENDING', -- 신청 상태
    USER_UK_ID INT,                                 -- 사용자 ID
    FOREIGN KEY (USER_UK_ID) REFERENCES USERS(USER_UK_ID) ON DELETE CASCADE -- 외래 키 참조 (USERS 테이블)
);