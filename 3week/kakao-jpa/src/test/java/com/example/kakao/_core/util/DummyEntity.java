package com.example.kakao._core.util;

import com.example.kakao.cart.Cart;
import com.example.kakao.order.Order;
import com.example.kakao.order.item.Item;
import com.example.kakao.product.Product;
import com.example.kakao.product.option.Option;
import com.example.kakao.user.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DummyEntity {
    protected User newUser(String username){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return User.builder()
                .email(username+"@nate.com")
                .password(passwordEncoder.encode("meta1234!"))
                .username(username)
                .roles(username.equals("admin") ? "ROLE_ADMIN" : "ROLE_USER")
                .build();
    }

    protected Product newProduct(String productName, int imageNumber, int price) {
        return Product.builder()
                .productName(productName)
                .description("")
                .image("/images/" + imageNumber + ".jpg")
                .price(price)
                .build();
    }

    protected Option newOption(Product product, String optionName, int price) {
        return Option.builder()
                .product(product)
                .optionName(optionName)
                .price(price)
                .build();
    }

    protected Cart newCart(User user, Option option, Integer quantity){
        return Cart.builder()
                .user(user)
                .option(option)
                .quantity(quantity)
                .price(option.getPrice() * quantity)
                .build();
    }

    protected Item newItem(Cart cart, Order order){
        return Item.builder()
                .order(order)
                .option(cart.getOption())
                .quantity(cart.getQuantity())
                .price(cart.getOption().getPrice() * cart.getQuantity())
                .build();
    }

    protected Order newOrder(int id, User user){
        return Order.builder()
                .id(id)
                .user(user)
                .build();
    }


    /*OrderItem에서 일괄로 Order를 만들어 User와 연결하는 메서드를 만들면서 옳지 않다고 판단하였고
    따라서 삭제를 하려다가 혹시나 레포지토리 테스트를 할때 일반적으로(변수로) 구현하고 싶기에 만들어 봤지만 불편한것 같습니다.
    newSimpleOrder, orderSimpleDummyList, OrderJPARepositoryTest의 setUp 에 사용됨
     */
    private int orderId = 1;
    protected Order newSimpleOrder(User user){
        return Order.builder()
                .user(user)
                .id(orderId++)
                .build();
    }
    protected List<Order> orderSimpleDummyList(List<User> userListPS) {
        return userListPS.stream()
                .flatMap(user -> Stream.generate(() -> newSimpleOrder(user)).limit(3))
                .collect(Collectors.toList());
    }

    protected List<Order> orderDummyObject(User user) {
        return Arrays.asList(
                newOrder(1,user),
                newOrder(2,user)
        );
    }
    protected List<Cart> cartDummyObject(User user, List<Option>  optionListPS) {
        return Arrays.asList(
                newCart(user, optionListPS.get(0),5),
                newCart(user, optionListPS.get(5),5),
                newCart(user, optionListPS.get(10),5),
                newCart(user, optionListPS.get(15),5)
        );
    }

    protected List<Item> orderItemDummyList(List<Cart> cartListPS, List<Order> orderListPS){
        return Arrays.asList(
                newItem(cartListPS.get(0),orderListPS.get(0)),
                newItem(cartListPS.get(1),orderListPS.get(0)),
                newItem(cartListPS.get(2),orderListPS.get(0)),
                newItem(cartListPS.get(3),orderListPS.get(1))
        );
    }


    // product repository 테스트할 때 가져옴
    protected List<Product> productDummyList(){
        return Arrays.asList(
                newProduct("기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전", 1, 1000),
                newProduct("[황금약단밤 골드]2022년산 햇밤 칼집밤700g외/군밤용/생율", 2, 2000),
                newProduct("삼성전자 JBL JR310 외 어린이용/성인용 헤드셋 3종!", 3, 30000),
                newProduct("바른 누룽지맛 발효효소 2박스 역가수치보장 / 외 7종", 4, 4000),
                newProduct("[더주] 컷팅말랑장족, 숏다리 100g/300g 외 주전부리 모음 /중독성 최고/마른안주", 5, 5000),
                newProduct("굳지않는 앙금절편 1,050g 2팩 외 우리쌀떡 모음전", 6, 15900),
                newProduct("eoe 이너딜리티 30포, 오렌지맛 고 식이섬유 보충제", 7, 26800),
                newProduct("제나벨 PDRN 크림 2개. 피부보습/진정 케어", 8, 25900),
                newProduct("플레이스테이션 VR2 호라이즌 번들. 생생한 몰입감", 9, 797000),
                newProduct("통영 홍 가리비 2kg, 2세트 구매시 1kg 추가증정", 10, 8900),
                newProduct("아삭한 궁채 장아찌 1kg 외 인기 반찬 모음전", 11, 6900),
                newProduct("깨끗한나라 순수소프트 30롤 2팩. 무형광, 도톰 3겹", 12, 28900),
                newProduct("생활공작소 초미세모 칫솔 12입 2개+가글 증정", 13, 9900),
                newProduct("경북 영천 샤인머스켓 가정용 1kg 2수 내외", 14, 9900),
                newProduct("[LIVE][5%쿠폰] 홈카페 Y3.3 캡슐머신 베이직 세트", 15, 148000)
        );
    }

    protected List<User> userDummyList(){
        return Arrays.asList(
                newUser("user1"),
                newUser("user2"),
                newUser("user3"),
                newUser("user4"),
                newUser("user5"),
                newUser("user6"),
                newUser("user7"),
                newUser("user8"),
                newUser("user9"),
                newUser("user10")
        );
    }


    // 나중에 테스트하기 편하기 위해서 수량과 유저를 하드코딩 하였음
    protected List<Cart> cartDummyList(List<User> userListPS, List<Option> optionListPS) {
        List<Cart> user1Carts = IntStream.range(0, 6)
                .mapToObj(i -> newCart(userListPS.get(0), optionListPS.get(i), i + 1))
                .collect(Collectors.toList());

        List<Cart> user2Carts = IntStream.range(6, 12)
                .mapToObj(i -> newCart(userListPS.get(1), optionListPS.get(i), 12 - i))
                .collect(Collectors.toList());

        List<Cart> carts = new ArrayList<>(user1Carts);
        carts.addAll(user2Carts);

        return carts;
    }





    protected List<Option> optionDummyList(List<Product> productListPS) {
        return Arrays.asList(
                newOption(productListPS.get(0), "01. 슬라이딩 지퍼백 크리스마스에디션 4종", 10000),
                newOption(productListPS.get(0), "02. 슬라이딩 지퍼백 플라워에디션 5종", 10900),
                newOption(productListPS.get(0), "고무장갑 베이지 S(소형) 6팩", 9900),
                newOption(productListPS.get(0), "뽑아쓰는 키친타올 130매 12팩", 16900),
                newOption(productListPS.get(0), "2겹 식빵수세미 6매", 8900),
                newOption(productListPS.get(1), "22년산 햇단밤 700g(한정판매)", 9900),
                newOption(productListPS.get(1), "22년산 햇단밤 1kg(한정판매)", 14500),
                newOption(productListPS.get(1), "밤깎기+다회용 구이판 세트", 5500),
                newOption(productListPS.get(2), "JR310 (유선 전용) - 블루", 29900),
                newOption(productListPS.get(2), "JR310BT (무선 전용) - 레드", 49900),
                newOption(productListPS.get(2), "JR310BT (무선 전용) - 그린", 49900),
                newOption(productListPS.get(2), "JR310BT (무선 전용) - 블루", 49900),
                newOption(productListPS.get(2), "T510BT (무선 전용) - 블랙", 52900),
                newOption(productListPS.get(2), "T510BT (무선 전용) - 화이트", 52900),
                newOption(productListPS.get(3), "선택01_바른곡물효소 누룽지맛 2박스", 17900), //15
                newOption(productListPS.get(3), "선택02_바른곡물효소누룽지맛 6박스", 50000),
                newOption(productListPS.get(3), "선택03_바른곡물효소3박스+유산균효소3박스", 50000),
                newOption(productListPS.get(3), "선택04_바른곡물효소3박스+19종유산균3박스", 50000),
                newOption(productListPS.get(4), "01. 말랑컷팅장족 100g", 4900),
                newOption(productListPS.get(4), "02. 말랑컷팅장족 300g", 12800),
                newOption(productListPS.get(4), "03. 눌린장족 100g", 4900),
                newOption(productListPS.get(5), "굳지않는 쑥 앙금 절편 1050g", 15900),
                newOption(productListPS.get(5), "굳지않는 흑미 앙금 절편 1050g", 15900),
                newOption(productListPS.get(5), "굳지않는 흰 가래떡 1050g", 15900),
                newOption(productListPS.get(6), "이너딜리티 1박스", 26800), //25
                newOption(productListPS.get(6), "이너딜리티 2박스+사은품 2종", 49800),
                newOption(productListPS.get(7), "제나벨 PDRN 자생크림 1+1", 25900),
                newOption(productListPS.get(8), "플레이스테이션 VR2 호라이즌 번들", 839000),
                newOption(productListPS.get(8), "플레이스테이션 VR2", 797000),
                newOption(productListPS.get(9),"홍가리비2kg(50미이내)", 8900), //30
                newOption(productListPS.get(10), "궁채 절임 1kg", 6900),
                newOption(productListPS.get(10), "양념 깻잎 1kg", 8900),
                newOption(productListPS.get(10), "된장 깻잎 1kg", 8900),
                newOption(productListPS.get(10), "간장 깻잎 1kg", 7900),
                newOption(productListPS.get(10), "고추 무침 1kg", 8900),
                newOption(productListPS.get(10), "파래 무침 1kg", 9900),
                newOption(productListPS.get(11), "01_순수소프트 27m 30롤 2팩", 28900),
                newOption(productListPS.get(11), "02_벚꽃 프리미엄 27m 30롤 2팩", 32900),
                newOption(productListPS.get(12), "(증정) 초미세모 칫솔 12개 x 2개", 11900),
                newOption(productListPS.get(12), "(증정) 잇몸케어 치약 100G 3개 x 2개", 16900),
                newOption(productListPS.get(12), "(증정) 구취케어 치약 100G 3개 x 2개", 16900),
                newOption(productListPS.get(12), "(증정)화이트케어 치약 100G 3개 x 2개", 19900),
                newOption(productListPS.get(12), "(증정) 어린이 칫솔 12EA", 9900),
                newOption(productListPS.get(13), "[가정용] 샤인머스켓 1kg 2수내외", 9900),
                newOption(productListPS.get(13), "[특품] 샤인머스켓 1kg 1-2수", 12900), //45
                newOption(productListPS.get(13), "[특품] 샤인머스켓 2kg 2-3수", 23900),
                newOption(productListPS.get(14), "화이트", 148000),
                newOption(productListPS.get(14), "블랙", 148000)
        );
    }
}
