

INSERT INTO users (name, email, password, id) VALUES ('john_doe', 'john@example.com', '12345', 'johoho');
INSERT INTO users (name, email, password, id) VALUES ('jooheu', 'john@gmail.com', '12345' ,'joo');
INSERT INTO users (name, email, password, id) VALUES ('jooho', 'joo@gmail.com', '$2a$10$bRGXy/TfBZpdpiy85bDS7eMcTFsyKAVtZnARm/xWwoR2vFz3mWQ.W' ,'joo');
INSERT INTO users (name, email, password, id) VALUES ('joohoo', 'abc@gmail.com', '$2a$10$bRGXy/TfBZpdpiy85bDS7eMcTFsyKAVtZnARm/xWwoR2vFz3mWQ.W' ,'abc');
-- id : abc, joo / 비밀번호 : 12345

INSERT INTO Notifications (author, title, content, post_date, view_count)
VALUES ('admin', '공지사항 제목', '공지사항 내용입니다.kkkkkkk', NOW(), 0);
INSERT INTO Notifications (author, title, content, post_date, view_count)
VALUES ('admin', '공지사항 제목2', '공지사항 내용입니다2.kkkkkkk', NOW(), 0);




-- 데이터 추가
INSERT INTO USERS (NAME, EMAIL, PASSWORD, ID) VALUES ('USER1','USER1@EXAMPLE.COM','12345','USER1');
INSERT INTO USERS (NAME, EMAIL, PASSWORD, ID) VALUES ('USER2','USER2@EXAMPLE.COM','12345','USER2');

INSERT INTO SHOPS (SHOP_NAME, SHOP_PROFILE, SHOP_TYPE, LOCATION, SHOP_TEL, OPEN_HOURS, CLOSE_HOURS, CLOSED_DAYS, ETC, LATITUDE, LONGITUDE)
VALUES
    ('서울맛집', 'profile1.jpg', '한식', '서울시 강남구', '02-1234-5678', '11:00', '22:00', '매주 일요일', '주차 공간 있음', 37.518568, 127.023029),
    ('중국회관', 'profile2.jpg', '중식', '서울시 종로구', '02-8765-4321', '10:00', '21:00', '매주 월요일', '배달 서비스 제공', 37.572416, 126.976123),
    ('이탈리아 레스토랑', 'profile3.jpg', '양식', '서울시 송파구', '02-1357-2468', '12:00', '23:00', '매주 화요일', '예약 필수', 37.514034, 127.105671);

INSERT INTO REVIEWS (USER_UK_ID, SHOP_UK_ID, REVIEW_RATING, REVIEW_COMMENT, REVIEW_CONTENT)
VALUES (1, 1, 5, '맛있어요', '맛있어요'),
(1, 3, 5, '맛있어요', '맛있어요'),
(2, 2, 5, '맛있어요', '맛있어요'),
(1, 2, 5, '맛있어요', '맛있어요'),
(2, 3, 5, '맛있어요', '맛있어요');



SELECT * FROM users;



-- 공지 실험용

INSERT INTO Notifications (author, title, content, post_date, view_count)
VALUES ('admin', '공지사항 제목1', '공지사항 내용입니다.kkkkkkk', NOW(), 0),
('admin', '공지사항 제목2', '공지사항 내용입니다.kkkkkkk', NOW(), 0),
('admin', '공지사항 제목3', '공지사항 내용입니다.kkkkkkk', NOW(), 0),
('admin', '공지사항 제목4', '공지사항 내용입니다.kkkkkkk', NOW(), 0),
('admin', '공지사항 제목5', '공지사항 내용입니다.kkkkkkk', NOW(), 0),
('admin', '공지사항 제목6', '공지사항 내용입니다.kkkkkkk', NOW(), 0),
('admin', '공지사항 제목7', '공지사항 내용입니다.kkkkkkk', NOW(), 0),
('admin', '공지사항 제목8', '공지사항 내용입니다.kkkkkkk', NOW(), 0),
('admin', '공지사항 제목9', '공지사항 내용입니다.kkkkkkk', NOW(), 0),
('admin', '공지사항 제목10', '공지사항 내용입니다.kkkkkkk', NOW(), 0),
('admin', '공지사항 제목11', '공지사항 내용입니다.kkkkkkk', NOW(), 0),
('admin', '공지사항 제목12', '공지사항 내용입니다.kkkkkkk', NOW(), 0),
('admin', '공지사항 제목13', '공지사항 내용입니다.kkkkkkk', NOW(), 0),
('admin', '공지사항 제목14', '공지사항 내용입니다.kkkkkkk', NOW(), 0),
('admin', '공지사항 제목15', '공지사항 내용입니다.kkkkkkk', NOW(), 0),
('admin', '공지사항 제목16', '공지사항 내용입니다.kkkkkkk', NOW(), 0),
('admin', '공지사항 제목17', '공지사항 내용입니다.kkkkkkk', NOW(), 0),
('admin', '공지사항 제목18', '공지사항 내용입니다.kkkkkkk', NOW(), 0),
('admin', '공지사항 제목19', '공지사항 내용입니다.kkkkkkk', NOW(), 0),
('admin', '공지사항 제목20', '공지사항 내용입니다.kkkkkkk', NOW(), 0);
