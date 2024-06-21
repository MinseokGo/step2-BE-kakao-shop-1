# 카카오 쇼핑하기 클론 프로젝트
## 🔅 프로젝트 소개
카카오 쇼핑하기 서버 API 클론 프로젝트입니다.


## 개발 기간
2023.06 - 2023.08


## 사용 기술 및 협업 스텍
- `JDK 11`
- `Springboot 2.7.6`
- `Inmemory DB`
- `Spring security`
- `Spring Data JPA`

## 🙋‍♀️ 서비스 기능

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
©generated by Project Tree Generator


🎯 중점을 둔 기능
FE
1. 캔버스 기반의 도형 및 드로잉 기능 (TLdraw 활용)
사용자가 웹 애플리케이션 내에서 직관적으로 드로잉하고 도형을 그릴 수 있는 기능을 제공할 수 있도록 구현했습니다.
깃허브 URL
2. 웹 소켓 통신을 이용한 실시간 협업 및 동시 편집 기능
Yjs 라이브러리(yjs, y-websocket, y-presence)를 활용하여 실시간 협업 및 동시 편집 기능을 구현하여 여러 사용자가 동일한 캔버스(TLdraw) 페이지에 대해 동시에 작업할 수 있도록 했습니다.
3. 반응형 디자인 및 최적화된 사용자 인터페이스
react-select, react-modal 등의 라이브러리를 활용하여 사용자 인터페이스를 최적화하고, 반응형 웹 디자인을 구현하여 다양한 디바이스에서의 사용자 경험을 향상시킵니다.
깃허브 URL
4. 소셜 로그인 및 사용자 인증

BE
1. 소셜 로그인
카카오 소셜로그인, 구글 소셜 로그인 이용
깃허브 URL
2. 실시간 웹 소켓 통신
깃허브 URL
3. 앨범 페이지 기능
깃허브 URL
