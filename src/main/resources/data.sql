
--MEMBER
INSERT INTO MEMBER
(MEMBER_SEQ, MEMBER_ID, EMAIL, NAME, PHONE, TYPE)
VALUES(1,'MMMMMM1', 'member1@naver.com', '주윤재', '01090626317', 'Buyer');

INSERT INTO MEMBER
(MEMBER_SEQ,MEMBER_ID, EMAIL, NAME, PHONE, TYPE)
VALUES(2,'MMMMMM2', 'member2@test.com', '박미선', '01090626417', 'Buyer');

INSERT INTO MEMBER
(MEMBER_SEQ,MEMBER_ID, EMAIL, NAME, PHONE, TYPE)
VALUES(3,'MMMMMM3', 'member3@test.com', '주윤식', '01090126317', 'Buyer');

INSERT INTO MEMBER
(MEMBER_SEQ,MEMBER_ID, EMAIL, NAME, PHONE, TYPE)
VALUES(4,'MMMMMM4', 'member4@test.com', '권휘', '01030626317', 'Buyer');

INSERT INTO MEMBER
(MEMBER_SEQ,MEMBER_ID, EMAIL, NAME, PHONE, TYPE)
VALUES(5,'MMMMMM5', 'member5@test.com', '박수종', '01060626317', 'Buyer');

INSERT INTO MEMBER
(MEMBER_SEQ,MEMBER_ID, EMAIL, NAME, PHONE, TYPE)
VALUES(6,'MMMMMM6', 'member6@test.com', '하두현', '01020126317', 'Seller');

INSERT INTO MEMBER
(MEMBER_SEQ,MEMBER_ID, EMAIL, NAME, PHONE, TYPE)
VALUES(7,'MMMMMM7', 'member7@test.com', '박재성', '01060646317', 'Seller');

INSERT INTO MEMBER
(MEMBER_SEQ,MEMBER_ID, EMAIL, NAME, PHONE, TYPE, COMPANY_NUMBER, ORGANIZER_NAME)
VALUES(8,'MMMMMM8', 'member8@test.com', '이병규', '01080626417', 'Organizer','100','유한컴퍼니');

INSERT INTO MEMBER
(MEMBER_SEQ,MEMBER_ID, EMAIL, NAME, PHONE, TYPE, COMPANY_NUMBER, ORGANIZER_NAME)
VALUES(9,'MMMMMM9', 'member9@test.com', '이웅희', '01010626312', 'Organizer','999','뱅크웨어글로벌');

INSERT INTO MEMBER
(MEMBER_SEQ,MEMBER_ID, EMAIL, NAME, PHONE, TYPE)
VALUES(10,'MMMMMM10', 'member10@test.com', '관리자', '01050624317', 'Admin');

--FESTIVAL
INSERT INTO FESTIVAL
(FESTIVAL_SEQ,FESTIVAL_ID, NAME, START_DATE, END_DATE)
VALUES(1,'FFFFFF1', '여의도 불꽃놀이 축제', '20220101', '20220630');

INSERT INTO FESTIVAL
(FESTIVAL_SEQ,FESTIVAL_ID, NAME, START_DATE, END_DATE)
VALUES(2,'FFFFFF2', '한강 밤도꺠비 시장', '20220401', '20220831');

--STORE
INSERT INTO STORE
(STORE_SEQ,STORE_ID, NAME, PHONE, FESTIVAL_SEQ)
VALUES(1,'SSSSSS1', '버거킹', '15881012', 1);

INSERT INTO STORE
(STORE_SEQ,STORE_ID, NAME, PHONE, FESTIVAL_SEQ)
VALUES(2,'SSSSSS2', '피자헛', '15880232', 1);

INSERT INTO STORE
(STORE_SEQ,STORE_ID, NAME, PHONE, FESTIVAL_SEQ)
VALUES(3,'SSSSSS3', '교촌치킨', '15882321', 1);

INSERT INTO STORE
(STORE_SEQ,STORE_ID, NAME, PHONE, FESTIVAL_SEQ)
VALUES(4,'SSSSSS4', '맥도날드', '16332323', 2);

INSERT INTO STORE
(STORE_SEQ,STORE_ID, NAME, PHONE, FESTIVAL_SEQ)
VALUES(5,'SSSSSS5', '한식당', '19883232', 2);


--ITEM
INSERT INTO ITEM
(ITEM_SEQ, ITEM_ID, IMAGE_FILE_NAME, IMAGE_FILE_URL, NAME, PRICE, STORE_SEQ)
VALUES(1, 'IIIIII1', '와퍼_사진', 'http://sdsdsdsd.com', '와퍼', '10000', 1);

INSERT INTO ITEM
(ITEM_SEQ, ITEM_ID, IMAGE_FILE_NAME, IMAGE_FILE_URL, NAME, PRICE, STORE_SEQ)
VALUES(2, 'IIIIII2', '치킨버거_사진', 'http://sdsdsdsd.com', '치킨버거', '20000', 2);

INSERT INTO ITEM
(ITEM_SEQ, ITEM_ID, IMAGE_FILE_NAME, IMAGE_FILE_URL, NAME, PRICE, STORE_SEQ)
VALUES(3, 'IIIIII3', '빅맥_사진', 'http://sdsdsdsd.com', '빅맥', '5000', 4);

INSERT INTO ITEM
(ITEM_SEQ, ITEM_ID, IMAGE_FILE_NAME, IMAGE_FILE_URL, NAME, PRICE, STORE_SEQ)
VALUES(4, 'IIIIII4', '레드콤보_사진', 'http://sdsdsdsd.com', '레드콤보', '40000', 3);


--ORDERS
INSERT INTO ORDERS
(ORDER_SEQ,ORDER_ID, MEMBER_SEQ, ITEM_SEQ, PAY_DATE, PAY_TYPE, TYPE, REQUEST)
VALUES(1,'OOOOOO1', 1, 1, '20220101', 'Card', 'COMPLETE','요청사항1');

INSERT INTO ORDERS
(ORDER_SEQ,ORDER_ID, MEMBER_SEQ, ITEM_SEQ, PAY_DATE, PAY_TYPE, TYPE, REQUEST)
VALUES(2,'OOOOOO2', 1, 2, '20220101', 'Card', 'COMPLETE','요청사항1');

INSERT INTO ORDERS
(ORDER_SEQ,ORDER_ID, MEMBER_SEQ, ITEM_SEQ, PAY_DATE, PAY_TYPE, TYPE, REQUEST)
VALUES(3,'OOOOOO3', 1, 1, '20220101', 'Card', 'COMPLETE','요청사항1');

INSERT INTO ORDERS
(ORDER_SEQ,ORDER_ID, MEMBER_SEQ, ITEM_SEQ, PAY_DATE, PAY_TYPE, TYPE, REQUEST)
VALUES(4,'OOOOOO4', 1, 2, '20220101', 'Card', 'CANCEL','요청사항1');

INSERT INTO ORDERS
(ORDER_SEQ,ORDER_ID, MEMBER_SEQ, ITEM_SEQ, PAY_DATE, PAY_TYPE, TYPE, REQUEST)
VALUES(5,'OOOOOO5', 1, 3, '20220101', 'Card', 'COMPLETE','요청사항1');

INSERT INTO ORDERS
(ORDER_SEQ,ORDER_ID, MEMBER_SEQ, ITEM_SEQ, PAY_DATE, PAY_TYPE, TYPE, REQUEST)
VALUES(6,'OOOOOO6', 1, 1, '20220101', 'Card', 'COMPLETE','요청사항1');

INSERT INTO ORDERS
(ORDER_SEQ,ORDER_ID, MEMBER_SEQ, ITEM_SEQ, PAY_DATE, PAY_TYPE, TYPE, REQUEST)
VALUES(7,'OOOOOO7', 1, 4, '20220101', 'Card', 'WAIT','요청사항1');

INSERT INTO ORDERS
(ORDER_SEQ,ORDER_ID, MEMBER_SEQ, ITEM_SEQ, PAY_DATE, PAY_TYPE, TYPE, REQUEST)
VALUES(8,'OOOOOO8', 1, 4, '20220101', 'Card', 'COMPLETE','요청사항1');
