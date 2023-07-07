# step2-BE-kakao-shop

카카오 테크 캠퍼스 2단계 카카오 쇼핑하기 백엔드 클론 프로젝트 레포지토리입니다.

# 1주차

카카오 테크 캠퍼스 2단계 - BE - 1주차 클론 과제
</br>
</br>

## **과제명**

```
1. 요구사항분석/API요청 및 응답 시나리오 분석
2. 요구사항 추가 반영 및 테이블 설계도
```

## **과제**

### 1. 요구사항 시나리오를 보고 부족해 보이는 기능을 하나 이상 체크하여 README에 내용을 작성하시오.

</br>

- 판매자 관리 페이지

  - 할인 [Discount]
  - 쿠폰 [Coupon]
  - 상품 등록/수정/삭제 [Product]
  - 상품 평점 [Rating]
  - 상품 판매 현황 [ProductSales]
  - C/S 리뷰 관리 및 고객 응대 페이지 [CustomerService]
  - 재고 관리 페이지 [InventoryManagement]

- 구매자 개인 페이지

  - 위시리스트 [Wishlist]
  - 결제 정보 저장 [PaymentInfo]
  - 배송지 정보 저장 [Address]
  - 상품 구매 내역 [PurchaseHistory]
  - 상품 배송 상태 [DeliveryStatus]
  - 리뷰 [Review]
  - 구매 확정 페이지 [Confirmation]
  - 환불/반품 요청 페이지 [Refund/ReturnRequest]

- 웹 어드민 페이지
  - 사용자 행동 로그 [UserBehaviorLog]
  - 트래픽 수집 [TrafficData]
  - 구매자 관리 페이지 []

</br></br>

### 2. 제시된 화면설계를 보고 해당 화면설계와 배포된 기존 서버의 API주소를 매칭하여 README에 내용을 작성하시오.

| 기능    | 기능 설명                            | 사용자 인터랙션             | 호출되는 API | 엔드포인트             | 상태            |
| ------- | ------------------------------------ | --------------------------- | ------------ | ---------------------- | --------------- |
| 기능1   | 회원 가입                            | 가입 버튼 클릭              | POST         | `/check`               | 구현 완료       |
| 기능1   | 이메일 중복 체크                     | 이메일 입력 후 Tab          | GET          | `/join`                | 구현 완료       |
| 기능2   | 로그인                               | 로그인 버튼 클릭            | POST         | `/login`               | 구현 완료       |
| 기능3   | 로그아웃                             | 로그아웃 버튼 클릭          | POST         | `/logout`              | 미구현          |
| 기능4   | 전체 상품 조회                       | 메인페이지/회원가입완료시   | GET          | `/products`            | 구현 완료       |
| 기능4   | 전체 상품 조회 페이징                | 페이지 넘버 클릭            | GET          | `/products?page={int}` | 구현 완료       |
| 기능5   | 개별 상품 상세조회                   | 개별 상품 클릭              | GET          | `/products/{id}`       | 구현 완료       |
| 기능6,7 | 상품 옵션 선택/옵션확인 및 수량 결정 | 옵션 선택 후 확인 버튼 클릭 | N/A          | N/A                    | 프론트엔드 처리 |
| 기능8   | 장바구니 추가                        | 장바구니 추가 버튼 클릭     | POST         | `/carts/add`           | 구현 완료       |
| 기능9   | 장바구니 확인                        | 장바구니 아이콘 클릭        | GET          | `/carts`               | 구현 완료       |
| 기능10  | 장바구니 수량 결정(수정)             | 수량 수정                   | PUT          | `/carts/update`        | 구현 완료       |
| 기능11  | 주문                                 | 주문 버튼 클릭              | POST         | `/orders/save`         | 구현 완료       |
| 기능12  | 결제                                 | 결제 버튼 클릭              | POST         | `/payment`             | 미구현          |
| 기능13  | 주문 결과 확인                       | 주문 확인 클릭              | GET          | `/orders/{id}`         | 구현 완료       |

</br>

- 기능 5에서 장바구니에 담고 결제를 진행할수도 있지만 바로 기능 11 결제를 진행할 수 있다.
  - orders/save가 무조건 장바구니에서 가져와야하는것 같은데 바로 구매 가능하도록 기능 구현 필요
- 기능 10
  - 항목 삭제 기능을 추가해야 할것 같다.
  - 선택한 상품만 주문하는 기능을 추가하면 좋을것 같다.
- 기능 11
  - 배송지 저장(회원마다 여러 장소 등록가능) DB생성 요망
  - 배송 요청사항 Order에 추가
  - 동의 여부는 필수이기에 프론트에서 처리
- 기능 12는 대부분 결제 API를 서드파티에서 가져와서 사용한다.

</br></br>

### 3. 배포된 서버에 모든 API를 POSTMAN으로 요청해본 뒤 응답되는 데이터를 확인하고 부족한 데이터가 무엇인지 체크하여 README에 내용을 작성하시오.

- 에러메세지가 잘 주어져있지만 응답코드는 400으로 통일되어있는 경우가 많다. 409나 422등 구분을 해주는게 좋을수 있다.
- 기능9에서 항목 추가시에 Option_price와 carts_price가 혼동의 위험이 있으니 carts_total_price/order_final_price 처럼 바꿔주면 좋을것 같다.
- /carts 경로로 카트에 같은 product를 입력시에 500 이 발생한다.
- /carts/update 경로로 quantity를 0으로 설정하면 항목이 사라지지 않고 남아있다.(프론트에서 0이 되지 않게 했지만 보안 위험성 존재한다.)
- 2번에서도 언급했지만 배송지(관련된 추가 배송료) 에 대한 데이터를 추가해야한다.

</br></br>

### 4. 테이블 설계를 하여 README에 ER-Diagram을 추가하여 제출하시오.

![image](https://github.com/ChoMinGi/PNUreminder-DBserver/assets/81455273/4df8af54-0a3d-4a44-ae32-d986a967aded)

- 본 테이블들로 주어진 명세서 내의 API구현이 가능하다.

### [pdf] 테이블 설계

#### ERD

#### Entity 코드

UserEntity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

ProductEntity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 1000)
    private String description;

    private String image;

    @Column(nullable = false)
    private Integer price;

    @Column(name = "product_name", nullable = false)
    private String productName;

OrderEntity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

OptionEntity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "option_name", nullable = false)
    private String optionName;

    @Column(nullable = false)
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

CartEntity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private OptionEntity option;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

CartItemEntity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private OptionEntity option;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

</br>

## **과제 상세 : 수강생들이 과제를 진행할 때, 유념해야할 것**

아래 항목은 반드시 포함하여 과제 수행해주세요!

> - 부족한 기능에 대한 요구사항을 미리 예상할 수 있는가? (예를 들면 상품등록 api가 기존 요구사항에는 없는데 추후 필요하지는 않을지, 이런 부분들을 생각하였는지)
> - 요구사항에 맞는 API를 분석하고 사용자 시나리오를 설계하였는가? (예를 들어 배포된 서버와 화면 설계를 제시해줄 예정인데, 특정 버튼을 클릭했을 때 어떤 API가 호출되어야 할지를 아는지)
> - 응답되는 데이터가 프론트앤드 화면에 모두 반영될 수 있는지를 체크하였는가?(예를 들어 배송관련 비용이 있는데, 이런것들이 API에는 없는데 이런 부분을 캐치할 수 있는지)
> - 테이블 설계가 모든 API를 만족할 수 있게 나왔는가? (테이블이 효율적으로 나왔는가 보다는 해당 테이블로 요구사항을 만족할 수 있는지에 대한 여부만)
> - 테이블명이 이해하기 쉽게 만들어졌는가? (상품테이블이 product이면 이해하기 쉽지만, material이라고 하면 이해하기 어렵기 때문)

</br>

## **코드리뷰 관련: PR시, 아래 내용을 포함하여 코멘트 남겨주세요.**

**1. PR 제목과 내용을 아래와 같이 작성 해주세요.**

> - PR 제목 : 부산대BE\_라이언\_1주차 과제

</br>

**2. PR 내용 :**

> - 코드 작성하면서 어려웠던 점
> - 코드 리뷰 시, 멘토님이 중점적으로 리뷰해줬으면 하는 부분

# 2주차

카카오 테크 캠퍼스 2단계 - BE - 2주차 클론 과제
</br>
</br>

## **과제명**

```
1. 전체 API 주소 설계
2. Mock API Controller 구현
```

## **과제**

### 1. API주소를 설계하여 README에 내용을 작성하시오.

|  Module  |   Method    |    Endpoint    |  Description   |
| :------: | :---------: | :------------: | :------------: |
| 장바구니 |     GET     |     /cart      |      조회      |
| 장바구니 |    POST     |   /cart/add    |   상품 담기    |
| 장바구니 | POST(PATCH) |     /carts     |   옵션 변경    |
| 장바구니 |   DELETE    |  /carts/{id}   |   항목 삭제    |
|   상품   |     GET     |   /products    | 전체 목록 조회 |
|   상품   |     GET     | /products/{id} |   상세 조회    |
|   주문   |    POST     |   /order/pay   |    주문하기    |
|   주문   |     GET     |    /orders     | 내역 전체 조회 |
|   주문   |     GET     |  /orders/{id}  | 내역 상세 조회 |

</br>

### 2. 가짜 데이터를 설계하여 응답하는 스프링부트 컨트롤러를 작성하고 소스코드를 업로드하시오.

</br>

과제 상세에나 추후 과제 설명에 보면 "가짜 DTO", "DB연결 없이" 라는 조건을 확인하여 Entity를 만들 당시에 JPA 연관매핑을 진행하지 않고 필드 선언만 하려했으나 1. Product와 ProductOption이 매핑이 진행되어있고 2. User에는 매핑이 되어있지 않아서 User와의 매핑은 무시하고

- productOption > product (구현되어 있었음)
- orderItem > productOption, order
- cart > productOption

위 관계에만 한정하여 적용을 하였습니다.

</br>

또한 제공해주셨던 productOption의 @Table 옵션에 @Index 를 통해 인덱싱을 진행한것을 확인하여

- orderItem > productOption, order

옵션에 대해서도 인덱싱을 진행하였습니다.

```
@Table(name="order_item_tb",
    indexes = {
        @Index(name="order_item_option_id_idx", columnList="product_option_tb"),
        @Index(name="order_item_order_id_idx", columnList="order_id")
    }
)
```

#### 새롭게 작성/수정한 DTO, Entity, Test 리스트

- kakaoshop
  - KakaoshopApplication.java
  - cart
    - Cart.java
    - request
      - CartItemReqDTO.java
      - CartItemUpdateReqDTO.java
    - response
      - CartItemUpdateDTO.java
      - CartUpdateDTO.java
  - order
    - Order.java
    - item
      - OrderItem.java
      - response
        - OrderItemDTO.java
    - response
      - OrderProductDTO.java
      - OrderRespFindByIdDTO.java
- test
  - cart
    - CartRestControllerTest.java
  - order
    - OrderRestControllerTest.java
  - product
    - ProductRestControllerTest.java

## **과제 상세 : 수강생들이 과제를 진행할 때, 유념해야할 것**

아래 항목은 반드시 포함하여 과제 수행해주세요!

> - 전체 API 주소 설계가 RestAPI 맞게 설계되었는가? (예를 들어 배포된 서버는 POST와 GET으로만 구현되었는데, 학생들은 PUT과 DELETE도 배울 예정이라 이부분이 반영되었고, 주소가 RestAPI에 맞게 설계되었는지)
> - 가짜 데이터를 설계하여 Mock API를 잘 구현하였는가? (예를 들어 DB연결없이 컨트롤러만 만들어서 배포된 서버의 응답과 동일한 형태로 데이터가 응답되는지 여부)
>   </br>

## **코드리뷰 관련: PR시, 아래 내용을 포함하여 코멘트 남겨주세요.**

**1. PR 제목과 내용을 아래와 같이 작성 해주세요.**

> - PR 제목 : 부산대BE\_라이언\_2주차 과제

</br>

**2. PR 내용 :**

> - 코드 작성하면서 어려웠던 점
> - 코드 리뷰 시, 멘토님이 중점적으로 리뷰해줬으면 하는 부분

1. 왜 장바구니 엔티티에는 인덱싱이 이루어지지 않았을지

- User에 연결되어 있기에 사용자 id 에 대한 인덱싱이 유리하기 때문인가요? 하지만 엄청 많은 물건을 주문하는 소비자에 대응하기 위해선 필요할것 같기도 합니다. 현업에서는 어떻게 대응을 하는지 궁금합니다.
- 현업에서는 인덱싱 전략에 대해 결정할때 팀원간의 회의를 통해 정해지나요? 미리 fakeDB로 실험을 진행해보나요?

# 3주차

카카오 테크 캠퍼스 2단계 - BE - 3주차 클론 과제
</br>
</br>

## **과제명**

```
1. 레포지토리 단위테스트
```

## **과제 설명**

```
1. 레포지토리 단위테스트를 구현하여 소스코드를 제출하시오.
2. 쿼리를 테스트하면서 가장 좋은 쿼리를 작성해보시오.
```

</br>

## **과제 상세 : 수강생들이 과제를 진행할 때, 유념해야할 것**

아래 항목은 반드시 포함하여 과제 수행해주세요!

> - 레포지토리 단위테스트가 구현되었는가?
> - 테스트 메서드끼리 유기적으로 연결되지 않았는가? (테스트는 격리성이 필요하다)
> - Persistene Context를 clear하여서 테스트가 구현되었는가? (더미데이터를 JPA를 이용해서 insert 할 예정인데, 레포지토리 테스트시에 영속화된 데이터 때문에 쿼리를 제대로 보지 못할 수 있기 때문에)
> - 테스트 코드의 쿼리 관련된 메서드가 너무 많은 select를 유발하지 않는지? (적절한 한방쿼리, 효율적인 in query, N+1 문제 등이 해결된 쿼리)
>   </br>

## **코드리뷰 관련: PR시, 아래 내용을 포함하여 코멘트 남겨주세요.**

**1. PR 제목과 내용을 아래와 같이 작성 해주세요.**

> - PR 제목 : 부산대BE\_라이언\_3주차 과제

</br>

**2. PR 내용 :**

> - 코드 작성하면서 어려웠던 점
> - 코드 리뷰 시, 멘토님이 중점적으로 리뷰해줬으면 하는 부분

# 4주차

카카오 테크 캠퍼스 2단계 - BE - 4주차 클론 과제
</br>
</br>

## **과제명**

```
1. 컨트롤러 단위 테스트
```

## **과제 설명**

```
1. 컨트롤러 단위테스트를 작성한뒤 소스코드를 업로드하시오.
2. stub을 구현하시오.
```

</br>

## **과제 상세 : 수강생들이 과제를 진행할 때, 유념해야할 것**

아래 항목은 반드시 포함하여 과제 수행해주세요!

> - 컨트롤러 단위테스트가 구현되었는가?
> - Mockito를 이용하여 stub을 구현하였는가?
> - 인증이 필요한 컨트롤러를 테스트할 수 있는가?
> - 200 ok만 체크한 것은 아닌가? (해당 컨트롤러에서 제일 필요한 데이터에 대한 테스트가 구현되었는가?)
>   </br>

## **코드리뷰 관련: PR시, 아래 내용을 포함하여 코멘트 남겨주세요.**

**1. PR 제목과 내용을 아래와 같이 작성 해주세요.**

> - PR 제목 : 부산대BE\_라이언\_4주차 과제

</br>

**2. PR 내용 :**

> - 코드 작성하면서 어려웠던 점
> - 코드 리뷰 시, 멘토님이 중점적으로 리뷰해줬으면 하는 부분

# 5주차

카카오 테크 캠퍼스 2단계 - BE - 5주차 클론 과제
</br>
</br>

## **과제명**

```
1. 실패 단위 테스트
```

## **과제 설명**

```
1. 컨트롤러 단위테스트를 구현하는데, 실패 테스트 코드를 구현하시오.
2. 어떤 문제가 발생할 수 있을지 모든 시나리오를 생각해본 뒤, 실패에 대한 모든 테스트를 구현하시오.
```

</br>

## **과제 상세 : 수강생들이 과제를 진행할 때, 유념해야할 것**

아래 항목은 반드시 포함하여 과제 수행해주세요!

> - 실패 단위 테스트가 구현되었는가?
> - 모든 예외에 대한 실패 테스트가 구현되었는가?
>   </br>

## **코드리뷰 관련: PR시, 아래 내용을 포함하여 코멘트 남겨주세요.**

**1. PR 제목과 내용을 아래와 같이 작성 해주세요.**

> - PR 제목 : 부산대BE\_라이언\_5주차 과제

</br>

**2. PR 내용 :**

> - 코드 작성하면서 어려웠던 점
> - 코드 리뷰 시, 멘토님이 중점적으로 리뷰해줬으면 하는 부분

# 6주차

카카오 테크 캠퍼스 2단계 - BE - 6주차 클론 과제
</br>
</br>

## **과제명**

```
1. 카카오 클라우드 배포
```

## **과제 설명**

```
1. 통합테스트를 구현하시오.
2. API문서를 구현하시오. (swagger, restdoc, word로 직접 작성, 공책에 적어서 제출 등 모든 방법이 다 가능합니다)
3. 프론트앤드에 입장을 생각해본뒤 어떤 문서를 가장 원할지 생각해본뒤 API문서를 작성하시오.
4. 카카오 클라우드에 배포하시오.
5. 배포한 뒤 서비스 장애가 일어날 수 있으니, 해당 장애에 대처할 수 있게 로그를 작성하시오. (로그는 DB에 넣어도 되고, 외부 라이브러리를 사용해도 되고, 파일로 남겨도 된다 - 단 장애 발생시 확인을 할 수 있어야 한다)
```

</br>

## **과제 상세 : 수강생들이 과제를 진행할 때, 유념해야할 것**

아래 항목은 반드시 포함하여 과제 수행해주세요!

> - 통합테스트가 구현되었는가?
> - API문서가 구현되었는가?
> - 배포가 정상적으로 되었는가?
> - 서비스에 문제가 발생했을 때, 로그를 통해 문제를 확인할 수 있는가?
>   </br>

## **코드리뷰 관련: PR시, 아래 내용을 포함하여 코멘트 남겨주세요.**

**1. PR 제목과 내용을 아래와 같이 작성 해주세요.**

> - PR 제목 : 부산대BE\_라이언\_6주차 과제

</br>

**2. PR 내용 :**

> - 코드 작성하면서 어려웠던 점
> - 코드 리뷰 시, 멘토님이 중점적으로 리뷰해줬으면 하는 부분
