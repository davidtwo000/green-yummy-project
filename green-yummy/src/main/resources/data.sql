
-- 유저 아이디
INSERT INTO users (id, nickname, password, name, email, phone, IS_ADMIN) VALUES 
('abc', 'abc', '$2b$12$EgXR5oUF46CaseNP97QBluUdSjxO87OwdncAAkFuStcrxPIGw6PCe', '홍길동', 'abc@example.com', '01012345678', 0), -- 비밀번호: asdf1234@
('abcd', 'abcd', '$2b$12$EgXR5oUF46CaseNP97QBluUdSjxO87OwdncAAkFuStcrxPIGw6PCe', '홍길동', 'abcd@example.com', '01012345678', 0), -- 비밀번호: asdf1234@
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

-- 예시 아이디 이미지 추가
UPDATE users SET profile = '귀예시.png' WHERE id = 'abc';

-- 어드민 아이디/비밀번호 admin/admin 
INSERT INTO users (id, name, password, email, phone, profile, nickname, IS_ADMIN) VALUES ('admin', 'admin', '$2a$10$v95g76gFHcfRQHQCoPR6GeIeUXP4JhCIt3UPyO13XcjEN6Xw8w2Oy', 'admin1@gmail.com', '010-1234-5678', '프로필.png', 'admin', 1);





-- 공지 실험용


INSERT INTO Notifications (author, title, content, post_date, view_count) VALUES
('admin', '중요 공지', '안녕하세요! 중요한 공지사항이 업데이트되었습니다. 자세한 내용은 확인해주세요.', DATE(NOW()), FLOOR(RAND() * 51)),
('admin', '이벤트 소식', '특별 할인 기간이 시작되었습니다. 많은 참여 부탁드립니다.', DATE(NOW()), FLOOR(RAND() * 51)),
('admin', '시스템 점검 안내', '이번 주 토요일 2시간 동안 서비스가 중단됩니다.', DATE(NOW()), FLOOR(RAND() * 51)),
('admin', '새로운 기능 추가', '사용자 인터페이스가 개선되었습니다.', DATE(NOW()), FLOOR(RAND() * 51)),
('admin', '정기 유지보수', '서버 점검 및 업데이트가 또 예정되어 있습니다.', DATE(NOW()), FLOOR(RAND() * 51)),
('admin', '고객 지원', '자주 묻는 질문(FAQ) 페이지가 업데이트되었습니다.', DATE(NOW()), FLOOR(RAND() * 51)),
('admin', '안전 관련 공지', '비밀번호 변경 방법에 대한 안내입니다.', DATE(NOW()), FLOOR(RAND() * 51)),
('admin', '시즌별 프로모션', '여름 한정 특별 할인 이벤트!', DATE(NOW()), FLOOR(RAND() * 51)),
('admin', '서비스 개선 안내', '사용자 경험을 개선하기 위한 업데이트가 진행되었습니다.', DATE(NOW()), FLOOR(RAND() * 51)),
('admin', '계정 보안 강화', '새로운 보안 기능이 추가되었습니다.', DATE(NOW()), FLOOR(RAND() * 51)),
('admin', '정기 유지보수', '서버 점검 및 업데이트가 예정되어 있습니다.', DATE(NOW()), FLOOR(RAND() * 51)), 
('admin', '중요 공지', '안녕하세요! 중요한 공지사항이 업데이트되었습니다. 자세한 내용은 확인해주세요.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '이벤트 소식', '특별 할인 기간이 시작되었습니다. 많은 참여 부탁드립니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '시스템 점검 안내', '이번 주 토요일 2시간 동안 서비스가 중단됩니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '새로운 기능 추가', '사용자 인터페이스가 개선되었습니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '정기 유지보수', '서버 점검 및 업데이트가 또 예정되어 있습니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '고객 지원', '자주 묻는 질문(FAQ) 페이지가 업데이트되었습니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '안전 관련 공지', '비밀번호 변경 방법에 대한 안내입니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '시즌별 프로모션', '여름 한정 특별 할인 이벤트!', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '서비스 개선 안내', '사용자 경험을 개선하기 위한 업데이트가 진행되었습니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '계정 보안 강화', '새로운 보안 기능이 추가되었습니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '정기 유지보수', '서버 점검 및 업데이트가 예정되어 있습니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '보안 업데이트', '최근 보안 업데이트가 완료되었습니다. 세부사항을 확인하세요.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '새 기능 출시', '새로운 기능이 추가되었습니다. 많은 이용 부탁드립니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '서비스 안정성', '서비스 안정성을 높이기 위한 작업이 완료되었습니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '이메일 확인', '이메일 주소를 확인해 주세요. 추가 확인이 필요합니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '계정 관리', '계정 관리 페이지가 업데이트되었습니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '계정 복구', '계정 복구 절차에 대한 안내입니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '알림 설정', '알림 설정을 확인하고 조정해 주세요.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '데이터 백업', '중요 데이터를 백업해 주세요. 백업 안내입니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '서비스 이용 정책', '서비스 이용 정책이 업데이트되었습니다. 확인해 주세요.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '사용자 설문조사', '사용자 만족도 조사를 위한 설문조사에 참여해 주세요.', DATE(NOW()), FLOOR(RAND() * 101));




-- 이거 이전에 shop 데이터부터 넣어야됨
INSERT INTO REVIEWS (USER_UK_ID, SHOP_UK_ID, REVIEW_RATING, REVIEW_COMMENT, REVIEW_CONTENT)
VALUES (1, 1, 5, '맛있어요', '맛있어요'),
(1, 3, 5, '맛있어요', '맛있어요'),
(2, 2, 5, '맛있어요', '맛있어요'),
(1, 2, 5, '맛있어요', '맛있어요'),
(2, 3, 5, '맛있어요', '맛있어요');



commit;
