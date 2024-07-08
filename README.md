# 카카오 쇼핑하기 클론 프로젝트
## 🔅 프로젝트 소개
카카오 쇼핑하기 서버 API 클론 프로젝트입니다.


## 개발 기간
2023.06 - 2023.08


## 사용 기술 스택
- `JDK 11`
- `Springboot 2.7.6`
- `Inmemory DB`
- `Spring security`
- `Spring Data JPA`

## 🙋‍♀️ 서비스 기능
### User
| API | URI | HTTP Method | 
| --- | --- | --- |
| 회원가입 | /auth/join | POST | 
| 로그인 | /auth/login | POST |

### Product
| API | URI | HTTP Method | 
| --- | --- | --- |
| 전체 상품 조회 | /products | GET | 
| 개별 상품 조회 | /products/{id} | GET |
<br>
(전체 상품 조회는 페이지를 Param으로 받아 매핑한다. page의 디폴트 값은 0이다.)

### Cart
| API | URI | HTTP Method | 
| --- | --- | --- |
| 장바구니 조회 | /carts | GET | 
| 장바구니 담기 | /carts/add | POST |
| 장바구니 수정 | /carts/update | POST |

### Order
| API | URI | HTTP Method | 
| --- | --- | --- |
| 결제하기 | /orders/save | POST |
| 주문 확인 | /orders/{id} | GET |

## 프로젝트 구조
```
  🗂️ 
   └─ src
        │   ├── docs
        │   │   └── asciidoc
        │   │       └── api-docs.adoc
        │   ├── main
        │   │   ├── java
        │   │   │   └── com
        │   │   │       └── example
        │   │   │           └── kakao
        │   │   │               ├── KakaoApplication.java
        │   │   │               ├── _core
        │   │   │               │   ├── errors
        │   │   │               │   │   ├── GlobalExceptionHandler.java
        │   │   │               │   │   ├── GlobalValidationHandler.java
        │   │   │               │   │   └── exception
        │   │   │               │   │       ├── Exception400.java
        │   │   │               │   │       ├── Exception401.java
        │   │   │               │   │       ├── Exception403.java
        │   │   │               │   │       ├── Exception404.java
        │   │   │               │   │       ├── Exception405.java
        │   │   │               │   │       └── Exception500.java
        │   │   │               │   ├── security
        │   │   │               │   │   ├── CustomUserDetails.java
        │   │   │               │   │   ├── CustomUserDetailsService.java
        │   │   │               │   │   ├── JWTProvider.java
        │   │   │               │   │   ├── JwtAuthenticationFilter.java
        │   │   │               │   │   └── SecurityConfig.java
        │   │   │               │   └── utils
        │   │   │               │       ├── ApiUtils.java
        │   │   │               │       ├── FakeStore.java
        │   │   │               │       └── FilterResponseUtils.java
        │   │   │               ├── cart
        │   │   │               │   ├── Cart.java
        │   │   │               │   ├── CartJPARepository.java
        │   │   │               │   ├── CartRequest.java
        │   │   │               │   ├── CartResponse.java
        │   │   │               │   ├── CartRestController.java
        │   │   │               │   └── CartService.java
        │   │   │               ├── log
        │   │   │               │   ├── ErrorLog.java
        │   │   │               │   └── ErrorLogJPARepository.java
        │   │   │               ├── order
        │   │   │               │   ├── Order.java
        │   │   │               │   ├── OrderJPARepository.java
        │   │   │               │   ├── OrderResponse.java
        │   │   │               │   ├── OrderRestController.java
        │   │   │               │   ├── OrderService.java
        │   │   │               │   └── item
        │   │   │               │       ├── Item.java
        │   │   │               │       └── ItemJPARepository.java
        │   │   │               ├── product
        │   │   │               │   ├── Product.java
        │   │   │               │   ├── ProductJPARepository.java
        │   │   │               │   ├── ProductResponse.java
        │   │   │               │   ├── ProductRestController.java
        │   │   │               │   ├── ProductService.java
        │   │   │               │   └── option
        │   │   │               │       ├── Option.java
        │   │   │               │       └── OptionJPARepository.java
        │   │   │               └── user
        │   │   │                   ├── User.java
        │   │   │                   ├── UserJPARepository.java
        │   │   │                   ├── UserRequest.java
        │   │   │                   ├── UserResponse.java
        │   │   │                   ├── UserRestController.java
        │   │   │                   └── UserService.java
        │   │   └── resources
        │   │       ├── application-ide.yml
        │   │       ├── application-local.yml
        │   │       ├── application-prod.yml
        │   │       ├── application-test.yml
        │   │       ├── application.yml
        │   │       ├── db
        │   │       │   └── teardown.sql
        │   │       └── static
        │   │           └── docs
        │   │               └── api-docs.html
        │   └── test
        │       └── java
        │           └── com
        │               └── example
        │                   └── kakao
        │                       ├── MyRestDoc.java
        │                       ├── _core
        │                       │   ├── regex
        │                       │   │   └── RegexTest.java
        │                       │   └── util
        │                       │       └── DummyEntity.java
        │                       ├── cart
        │                       │   └── CartIntegrationTest.java
        │                       ├── order
        │                       │   └── OrderIntegrationTest.java
        │                       ├── product
        │                       │   └── ProductIntegrationTest.java
        │                       └── user
        │                           └── UserIntegrationTest.java
        └── startFront.sh
```

## 고민해본 것들
1. carts/add는 같은 상품 추가에 대한 경우 개수 증가, carts/update의 경우 증감 버튼 클릭 시 개수 증감이 이루어져야 하는데, 나중에 비즈니스 로직 구성 시 "개수 증가 로직 중복"에 대해서 어떻게 처리하면 좋을지에 대한 고민 </br>
-> 증가 또는 감소에 대한 별도의 메서드를 만들어두면 중복을 제거하기로 결정 </br>
[PR 링크](https://github.com/Kakao-tech-campus-BE/step2-BE-kakao-shop/pull/35)

2. 테이블 설계 시, cart_tb에 price 필드를 넣을지 안넣을지에 대한 고민 </br>
(1) cart_tb에 price가 없다면 option_tb을 참조하여 price를 가져와야 하는데, 이때 정합성은 보존되지만 조회 성능이 떨어지게 됨 </br>
(2) cart_tb에 price가 있다면 조회 성능은 유지되지만 업데이트 된 option 가격에 대해 고려해야하고 변경되었을 경우 쓰기(write)를 해야하므로 쓰기 성능이 떨어짐 </br>
-> price에 대한 업데이트를 고려하면 쓰기 성능에서 성능 저하가 고려됨. option_tb의 PK를 cart_tb에서 FK로 참조하기 때문에(단 한번의 조인) 조회 성능 저하는 크게 고려되지 않는 것으로 피드백 받음. </br>
-> 엔티티 참조를 통해 price를 참조하여 정합성을 보장하기로 결정. </br>
-> 이후에 반정규화를 통해 price를 필드로 넣고 DB 트리거를 고민해볼 수 있을 거 같음. </br>
[PR 링크](https://github.com/Kakao-tech-campus-BE/step2-BE-kakao-shop/pull/35)

3. orders/save와 orders/{id}의 경우 요구하는 JSON 응답이 같음. 이런 경우 DTO의 중복 발생 </br>
-> 중복을 피하기 위해 이름이 다른 DTO를 두개 작성하려했으나, DTO 파일을 많이 작성하면 패키지 구조가 복잡할 것 같아 이너 클래스로 작성. 이너 클래스로 작성하게 되면 추후에 기능이 요구하는 JSON 응답이 달라져도 하나의 이너 클래스만 수정하면 되기 때문에 선택함 </br>
[PR 링크](https://github.com/Kakao-tech-campus-BE/step2-BE-kakao-shop/pull/102)

5. Lazy Loading을 하는 객체를 참조할 때 어떤 방식을 어느 이유에서 채택하면 더 좋은 성능을 가질 수 있을지에 대한 고민 </br>
-> 일반적으로는 지연로딩을 사용하는 것이 성능적으로는 더 이득이므로 사용하시되 n+1 문제가 발생한다면 fetchType이나 fetch join을 사용해서 해결 </br>
-> Paging을 할 때 중복 데이터에 대한 고민도 해볼 수 있음. (batch size 조절) </br>
[PR 링크](https://github.com/Kakao-tech-campus-BE/step2-BE-kakao-shop/pull/162)

7. 상품을 추가하고 업데이트하는 책임과 해당 책임을 수행하기 전에 예외를 캐치하는 책임을 구분하고자 예외를 처리하는 로직을 메서드로 따로 빼서 구현 </br>
(1) 중복이 되지 않는데 나중을 위해서라도 빼둬야할까? (나중이라도 중복이 발생할 수도 있어서..?) -> OCP 준수를 위해  </br>
(2) 책임을 나누어서 구현해야 가독성도 좋아지고 해당 메서드가 무슨 역할을 가진 메서드인지 한눈에 알 수 있지 않을까? -> 가독성을 위해  </br>
(3) 하나의 책임에 집중하기 위해 하나의 책임만 남겨둬야 할까? -> SRP 준수를 위해  </br>
-> 메서드 길이가 길면 유지보수, 가독성 측면에서 좋지 않을 거라 판단하고 메서드 분리 결정 </br>
[PR 링크](https://github.com/Kakao-tech-campus-BE/step2-BE-kakao-shop/pull/162)




