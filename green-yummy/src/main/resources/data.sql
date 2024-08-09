

INSERT INTO users (name, email, password, id) VALUES ('john_doe', 'john@example.com', '12345', 'johoho');
INSERT INTO users (name, email, password, id) VALUES ('jooheu', 'john@gmail.com', '12345' ,'joho');
INSERT INTO users (name, email, password, id) VALUES ('jooho', 'joo@gmail.com', '$2a$10$bRGXy/TfBZpdpiy85bDS7eMcTFsyKAVtZnARm/xWwoR2vFz3mWQ.W' ,'joo');
INSERT INTO users (name, email, password, id) VALUES ('joohoo', 'abc@gmail.com', '$2a$10$bRGXy/TfBZpdpiy85bDS7eMcTFsyKAVtZnARm/xWwoR2vFz3mWQ.W' ,'abc');
-- id : abc, joo / 비밀번호 : 12345

INSERT INTO Notifications (author, title, content, post_date, view_count)
VALUES ('admin', '공지사항 제목', '공지사항 내용입니다.kkkkkkk', NOW(), 0);
INSERT INTO Notifications (author, title, content, post_date, view_count)
VALUES ('admin', '공지사항 제목2', '공지사항 내용입니다2.kkkkkkk', NOW(), 0);



INSERT INTO REVIEWS (USER_UK_ID, SHOP_UK_ID, REVIEW_RATING, REVIEW_COMMENT, REVIEW_CONTENT)
VALUES (1, 1, 5, '맛있어요', '맛있어요'),
(1, 3, 5, '맛있어요', '맛있어요'),
(2, 2, 5, '맛있어요', '맛있어요'),
(1, 2, 5, '맛있어요', '맛있어요'),
(2, 3, 5, '맛있어요', '맛있어요');





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


commit;
