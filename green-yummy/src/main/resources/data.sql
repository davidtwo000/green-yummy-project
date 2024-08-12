
-- 유저 아이디
INSERT INTO users (id, nickname, password, name, email, phone, IS_ADMIN) VALUES 
('abc', 'abc', '$2b$12$EgXR5oUF46CaseNP97QBluUdSjxO87OwdncAAkFuStcrxPIGw6PCe', '홍길동', 'abc@example.com', '01012345678', 0), -- 비밀번호: asdf1234@
('user001', 'coolguy', '$2b$12$xGPY18n2M7XXqx1EhZz88urSJowOPD8QVqI5iS7g818R6lvGtWQjG', '김철수', 'coolguy@daum.net', '01012345678', 0), -- 비밀번호: Cool!guY123
('alphaBravo', 'bravo123', '$2b$12$XXNywGKaHKv21ZT8MyQS.OyxV/k4wEu9QCAae3lUvxLUuqxZiG0Z2', '박영희', 'bravo123@naver.com', '01023456789', 0), -- 비밀번호: Bravo@456
('charlie9', 'charlie99', '$2b$12$CXaqiOqAcDf7LbyYov4nFORGEQV1Kejmrw1Yv63GMA63H33NnCaVu', '이민수', 'charlie99@daum.net', '01034567890', 0), -- 비밀번호: Charlie789!
('deltaX', 'deltaForce', '$2b$12$HQqk2IFrLoa.lYFOqCRK2./B.bqR7SeqVdJUZ.yShGL5qAm79ZUii', '최강현', 'deltaforce@naver.com', '01045678901', 0), -- 비밀번호: DeltaX@2023
('echoEcho', 'echoEch0', '$2b$12$dXkAZidKJcCI4w.gQJO3reEA6V6j6JiQpfLx.koIE82vbLucjd/yC', '정지우', 'echoecho@gmail.com', '01056789012', 0), -- 비밀번호: Echo1234$
('foxtrot7', 'foxtrot7', '$2b$12$53Ckl6yBUp7tdPNXENOFfOBgK/tu0wPgpmF2Cn/cyKjMvFe6aDlV6', '한가람', 'foxtrot7@naver.com', '01067890123', 0), -- 비밀번호: Foxtrot@77
('golfGolf', 'g0lfClub', '$2b$12$wvqVcYB4K9jcK1LiRZ1.quZzNbiJco1Mcxjub/Iq0kyYpLSRyXpPi', '남궁민', 'golfgolf@nate.com', '01078901234', 0), -- 비밀번호: Golf@Club1
('hotel7X', 'hote1xray', '$2b$12$ySHGHIozFd9VhcihoTM/JeD6kZASzx6LJqZ3DeyVKcb/jsvgGxpby', '서윤아', 'hotel7x@nate.com', '01089012345', 0), -- 비밀번호: HotelX@22
('indiaInd', 'india00', '$2b$12$4rJ6xGU4whJ.RBP.7a1ttOwkKR9xi/1AS1cVWnpj2ZwW/JCWo/wRW', '윤지혁', 'india00@naver.com', '01090123456', 0), -- 비밀번호: IndiaInd#00
('juliettJ', 'juliettJ', '$2b$12$Pm4F3V.R8spo.FQMMhSwf.Q4u0HEMJTC6Bvtm/GY81tt4y.YaFeQa', '박성호', 'juliettJ@gmail.com', '01091234567', 0); -- 비밀번호: Juliett!99

-- 어드민 아이디/비밀번호 admin/admin 
INSERT INTO users (id, name, password, email, phone, profile, nickname, IS_ADMIN) VALUES ('admin', 'admin', '$2a$10$v95g76gFHcfRQHQCoPR6GeIeUXP4JhCIt3UPyO13XcjEN6Xw8w2Oy', 'admin1@gmail.com', '010-1234-5678', '프로필.png', 'admin', 1);


INSERT INTO Notifications (author, title, content, post_date, view_count)
VALUES ('admin', '공지사항 제목', '공지사항 내용입니다.kkkkkkk', NOW(), 0);
INSERT INTO Notifications (author, title, content, post_date, view_count)
VALUES ('admin', '공지사항 제목2', '공지사항 내용입니다2.kkkkkkk', NOW(), 0);


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


-- 이거 이전에 shop 데이터부터 넣어야됨
INSERT INTO REVIEWS (USER_UK_ID, SHOP_UK_ID, REVIEW_RATING, REVIEW_COMMENT, REVIEW_CONTENT)
VALUES (1, 1, 5, '맛있어요', '맛있어요'),
(1, 3, 5, '맛있어요', '맛있어요'),
(2, 2, 5, '맛있어요', '맛있어요'),
(1, 2, 5, '맛있어요', '맛있어요'),
(2, 3, 5, '맛있어요', '맛있어요');



commit;
