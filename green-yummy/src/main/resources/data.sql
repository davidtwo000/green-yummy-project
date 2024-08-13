
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
('juliettJ', 'juliettJ', '$2b$12$Pm4F3V.R8spo.FQMMhSwf.Q4u0HEMJTC6Bvtm/GY81tt4y.YaFeQa', '박성호', 'juliettJ@gmail.com', '01091234567', 0), -- 비밀번호: Juliett!99
('kiloK', 'kiloKing', '$2b$12$x5XQ5Yv4zE4WqJ/Ax5.jT.FnSjpHb1t6c1f.qj0Fu0bBixRVGVpWC', '이상훈', 'kiloking@gmail.com', '01092345678', 0), -- 비밀번호: KiloKing@10
('limaL', 'lima123', '$2b$12$R4ZNb.HFfP2h6eyM7u5eAuWJ/jL2edNz8ENZ15iDtOZBdZZg2z96C', '김진우', 'lima123@naver.com', '01093456789', 0), -- 비밀번호: Lima@2023
('mikeM', 'mikeMike', '$2b$12$hgk5TV5HXlzBsDbN1UMdQem.xJtvXXC/NrAk1k3F1T15.yBF8dbG6', '박지훈', 'mikemike@daum.net', '01094567890', 0), -- 비밀번호: MikeM123$
('novemberN', 'novN99', '$2b$12$Kv5jY9hCpeRH8QzSz7SKe.cAxfI5JhHtyvNhklZW3NQPyAz/tykty', '정하늘', 'novN99@daum.net', '01095678901', 0), -- 비밀번호: November99!
('oscarO', 'oscarO', '$2b$12$qbk76.jqNL3Kf4RmbUJcR.inK/M2pOR.8n8aRUQonvqfGVzskBMm.', '유소연', 'oscarO@nate.com', '01096789012', 0), -- 비밀번호: Oscar@2023
('papaP', 'papaP123', '$2b$12$NVc/g7p3J89p/JKkQelzCuNcS8Q0n2YB/B6nVkMnOV3dc2b7mRAaC', '서하준', 'papaP123@gmail.com', '01097890123', 0), -- 비밀번호: Papa!123
('quebecQ', 'quebec99', '$2b$12$Qy7I0zzlxrV8NSWlNc1a6OyqlOPX2Zyk1XHrN5p0nRIuCWmDPRtkq', '이서윤', 'quebec99@daum.net', '01098901234', 0), -- 비밀번호: Quebec!99
('romeoR', 'romeo1', '$2b$12$nv/t1D6UJfR0c1VCz9cYIu8N26Dq/bow4sDl1sd6GxCXV.F4bFgAC', '김현우', 'romeo1@naver.com', '01099012345', 0), -- 비밀번호: Romeo#1
('sierraS', 'sierraS', '$2b$12$AKNBdo2jZylb8t/LeV6R8.vywFPLMxrs8z7iW.9ikZkejiCoQeM.i', '장예림', 'sierraS@nate.com', '01090123456', 0), -- 비밀번호: Sierra@2023
('tangoT', 'tango2023', '$2b$12$ZxlYYvl.w8P1CwdMx6jWVuIB4F0NTqVjEpXBGmsjHG6OrZtmlyRey', '송다영', 'tango2023@gmail.com', '01091234567', 0); -- 비밀번호: Tango!23

-- 예시 아이디 이미지 추가
UPDATE users SET profile = '귀예시.png' WHERE id = 'abc';

-- 어드민 아이디/비밀번호 admin/admin 
INSERT INTO users (id, name, password, email, phone, profile, nickname, IS_ADMIN) VALUES ('admin', 'admin', '$2a$10$v95g76gFHcfRQHQCoPR6GeIeUXP4JhCIt3UPyO13XcjEN6Xw8w2Oy', 'admin1@gmail.com', '010-1234-5678', '프로필.png', 'admin', 1);

-- 공지사항 
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
('admin', '사용자 설문조사', '사용자 만족도 조사를 위한 설문조사에 참여해 주세요.', DATE(NOW()), FLOOR(RAND() * 101)), 
('admin', '서비스 이용 안내', '서비스 이용 시간에 대한 안내입니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '이용 약관 변경', '새로운 이용 약관이 적용됩니다. 자세한 내용은 확인해 주세요.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '앱 업데이트 공지', '앱의 새로운 버전이 출시되었습니다. 업데이트를 권장합니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '고객 센터 운영 시간', '고객 센터 운영 시간이 변경되었습니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '새로운 서비스 론칭', '새로운 서비스를 곧 출시합니다. 많은 관심 부탁드립니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '보안 패치 안내', '보안 취약점이 해결된 패치가 적용되었습니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '서버 이전 공지', '더 나은 서비스 제공을 위해 서버 이전을 진행합니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '이용 팁 안내', '서비스를 더 효율적으로 이용할 수 있는 팁을 확인해보세요.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '사용자 만족도 조사', '사용자 만족도 조사가 진행됩니다. 참여 부탁드립니다.', DATE(NOW()), FLOOR(RAND() * 101)),
('admin', '긴급 보안 알림', '보안을 위해 즉시 조치해야 할 사항이 있습니다.', DATE(NOW()), FLOOR(RAND() * 101));

-- 가게 신청 더미 데이터
INSERT INTO APPLICATIONS (APPLICATION_SHOP_NAME, APPLICATION_SHOP_TYPE, APPLICATION_SHOP_LOCATION, APPLICATION_REASON, APPLICATION_SHOP_PHONE, APPLICATION_DATE, APPLICATION_STATUS, USER_UK_ID) VALUES
('맛있는 한식당', '한식', '논현동', '우리 동네에 맛있는 한식당이 필요합니다.', '01012345678', DATE(NOW()), 'PENDING', FLOOR(RAND() * 16)),
('청담양식', '양식', '청담동', '청담동에 분위기 좋은 양식당을 열고 싶습니다.', '01023456789', DATE(NOW()), 'PENDING', FLOOR(RAND() * 16)),
('진짜 중국집', '중식', '삼성동', '정통 중식을 선보이고 싶습니다.', '01034567890', DATE(NOW()), 'PENDING', FLOOR(RAND() * 16)),
('사쿠라 일식', '일식', '대치동', '정통 일식 전문점을 운영하고 싶습니다.', '01045678901', DATE(NOW()), 'PENDING', FLOOR(RAND() * 16)),
('패스트푸드왕', '패스트푸드', '역삼동', '역삼동에 빠르고 맛있는 패스트푸드점이 필요합니다.', '01056789012', DATE(NOW()), 'PENDING', FLOOR(RAND() * 16)),
('분식천국', '분식', '신사동', '신사동에 다양한 분식 메뉴를 제공하고 싶습니다.', '01067890123', DATE(NOW()), 'PENDING', FLOOR(RAND() * 16)),
('카페모아', '카페', '청담동', '차분하고 아늑한 카페를 운영하고 싶습니다.', '01078901234', DATE(NOW()), 'PENDING', FLOOR(RAND() * 16)),
('한식고수', '한식', '삼성동', '전통 한식의 맛을 널리 알리고 싶습니다.', '01089012345', DATE(NOW()), 'PENDING', FLOOR(RAND() * 16)),
('일식공방', '일식', '신사동', '정통 일식을 제공하는 작은 공방을 운영하고 싶습니다.', '01090123456', DATE(NOW()), 'PENDING', FLOOR(RAND() * 16)),
('분식하우스', '분식', '논현동', '분식의 맛을 정성껏 선보이고 싶습니다.', '01091234567', DATE(NOW()), 'PENDING', FLOOR(RAND() * 16)),
('패스트푸드천국', '패스트푸드', '대치동', '빠르고 맛있는 음식을 제공하고 싶습니다.', '01092345678', DATE(NOW()), 'PENDING', FLOOR(RAND() * 16)),
('가족카페', '카페', '역삼동', '가족이 함께 즐길 수 있는 카페를 열고 싶습니다.', '01093456789', DATE(NOW()), 'PENDING', FLOOR(RAND() * 16)),
('일식정', '일식', '삼성동', '고품질 일식을 선보이고 싶습니다.', '01094567890', DATE(NOW()), 'PENDING', FLOOR(RAND() * 16)),
('한식마당', '한식', '신사동', '정성껏 준비한 한식을 제공하고 싶습니다.', '01095678901', DATE(NOW()), 'PENDING', FLOOR(RAND() * 16)),
('분식의 달인', '분식', '청담동', '달인의 손길로 만드는 분식을 선보이고 싶습니다.', '01096789012', DATE(NOW()), 'PENDING', FLOOR(RAND() * 16));





-- 이거 이전에 shop 데이터부터 넣어야됨
INSERT INTO REVIEWS (USER_UK_ID, SHOP_UK_ID, REVIEW_RATING, REVIEW_COMMENT, REVIEW_CONTENT)
VALUES (1, 1, 5, '맛있어요', '맛있어요'),
(1, 3, 5, '맛있어요', '맛있어요'),
(2, 2, 5, '맛있어요', '맛있어요'),
(1, 2, 5, '맛있어요', '맛있어요'),
(2, 3, 5, '맛있어요', '맛있어요');



commit;
