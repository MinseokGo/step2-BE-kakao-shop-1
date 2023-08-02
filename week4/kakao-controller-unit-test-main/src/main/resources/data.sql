INSERT INTO user_tb (email, password, username, roles)
VALUES ('gihae0805@nate.com', '{bcrypt}$2a$10$IFUlc8nHrgh9jyGGSDqchOU1mTa6kFyZEeX/izkFXcFLaxmBO7mCq', 'gihae0805', 'ROLE_USER');

INSERT INTO product_tb (product_name, description, image, price)
VALUES
    ('기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전', '', '1.jpg', 1000),
    ('[황금약단밤 골드]2022년산 햇밤 칼집밤700g외/군밤용/생율', '', '2.jpg', 2000),
    ('삼성전자 JBL JR310 외 어린이용/성인용 헤드셋 3종!', '', '3.jpg', 30000),
    ('바른 누룽지맛 발효효소 2박스 역가수치보장 / 외 7종', '', '4.jpg', 4000),
    ('[더주] 컷팅말랑장족, 숏다리 100g/300g 외 주전부리 모음 /중독성 최고/마른안주', '', '5.jpg', 5000),
    ('굳지않는 앙금절편 1,050g 2팩 외 우리쌀떡 모음전', '', '6.jpg', 15900),
    ('eoe 이너딜리티 30포', '', '7.jpg', 26800),
    ('제나벨 PDRN 크림 2개. 피부보습/진정 케어', '', '8.jpg', 25900),
    ('플레이스테이션 VR2 호라이즌 번들. 생생한 몰입감', '', '9.jpg', 797000),
    ('통영 홍 가리비 2kg, 2세트 구매시 1kg 추가증정', '', '10.jpg', 8900),
    ('아삭한 궁채 장아찌 1kg 외 인기 반찬 모음전', '', '11.jpg', 6900),
    ('깨끗한나라 순수소프트 30롤 2팩. 무형광, 도톰 3겹', '', '12.jpg', 28900),
    ('생활공작소 초미세모 칫솔 12입 2개+가글 증정', '', '13.jpg', 9900),
    ('경북 영천 샤인머스켓 가정용 1kg 2수 내외', '', '14.jpg', 9900),
    ('[LIVE][5%쿠폰] 홈카페 Y3.3 캡슐머신 베이직 세트', '', '15.jpg', 148000);

INSERT INTO option_tb (product_id, option_name, price)
VALUES
    (1, '01. 슬라이딩 지퍼백 크리스마스에디션 4종', 10000),
    (1, '02. 슬라이딩 지퍼백 플라워에디션 5종', 10900),
    (1, '고무장갑 베이지 S(소형) 6팩', 9900),
    (1, '뽑아쓰는 키친타올 130매 12팩', 16900),
    (1, '2겹 식빵수세미 6매', 8900),
    (2, '22년산 햇단밤 700g(한정판매)', 9900),
    (2, '22년산 햇단밤 1kg(한정판매)', 14500),
    (2, '밤깎기+다회용 구이판 세트', 5500),
    (3, 'JR310 (유선 전용) - 블루', 29900),
    (3, 'JR310BT (무선 전용) - 레드', 49900),
    (3, 'JR310BT (무선 전용) - 그린', 49900),
    (3, 'JR310BT (무선 전용) - 블루', 49900),
    (3, 'T510BT (무선 전용) - 블랙', 52900),
    (3, 'T510BT (무선 전용) - 화이트', 52900),
    (4, '선택01_바른곡물효소 누룽지맛 2박스', 17900),
    (4, '선택02_바른곡물효소누룽지맛 6박스', 50000),
    (4, '선택03_바른곡물효소3박스+유산균효소3박스', 50000),
    (4, '선택04_바른곡물효소3박스+19종유산균3박스', 50000),
    (5, '01. 말랑컷팅장족 100g', 4900),
    (5, '02. 말랑컷팅장족 300g', 12800),
    (5, '03. 눌린장족 100g', 4900),
    (6, '굳지않는 쑥 앙금 절편 1050g', 15900),
    (6, '굳지않는 흑미 앙금 절편 1050g', 15900),
    (6, '굳지않는 흰 가래떡 1050g', 15900),
    (7, '이너딜리티 1박스', 26800),
    (7, '이너딜리티 2박스+사은품 2종', 49800),
    (8, '제나벨 PDRN 자생크림 1+1', 25900),
    (9, '플레이스테이션 VR2 호라이즌 번들', 839000),
    (9, '플레이스테이션 VR2', 797000),
    (10, '홍가리비2kg(50미이내)', 8900),
    (11, '궁채 절임 1kg', 6900),
    (11, '양념 깻잎 1kg', 8900),
    (11, '된장 깻잎 1kg', 8900),
    (11, '간장 깻잎 1kg', 7900),
    (11, '고추 무침 1kg', 8900),
    (11, '파래 무침 1kg', 9900),
    (12, '01_순수소프트 27m 30롤 2팩', 28900),
    (12, '02_벚꽃 프리미엄 27m 30롤 2팩', 32900),
    (13, '(증정) 초미세모 칫솔 12개 x 2개', 11900),
    (13, '(증정) 잇몸케어 치약 100G 3개 x 2개', 16900),
    (13, '(증정) 구취케어 치약 100G 3개 x 2개', 16900),
    (13, '(증정)화이트케어 치약 100G 3개 x 2개', 19900),
    (13, '(증정) 어린이 칫솔 12EA', 9900),
    (14, '[가정용] 샤인머스켓 1kg 2수내외', 9900),
    (14, '[특품] 샤인머스켓 1kg 1-2수', 12900),
    (14, '[특품] 샤인머스켓 2kg 2-3수', 23900),
    (15, '화이트', 148000),
    (15, '블랙', 148000);

