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

## **과제 설명**
```
1. 요구사항 시나리오를 보고 부족해 보이는 기능을 하나 이상 체크하여 README에 내용을 작성하시오.
2. 제시된 화면설계를 보고 해당 화면설계와 배포된 기존 서버의 API주소를 매칭하여 README에 내용을 작성하시오. (카카오 화면설계 시나리오가 있음)
3. 배포된 서버에 모든 API를 POSTMAN으로 요청해본 뒤 응답되는 데이터를 확인하고 부족한 데이터가 무엇인지 체크하여 README에 내용을 작성하시오.
4. 테이블 설계를 하여 README에 ER-Diagram을 추가하여 제출하시오.
```

</br>

## **과제 수행 내용**

### **1번**

**1. 아이디 중복 체크**

대부분 인터넷 커뮤니티에서는 이메일을 그대로 사용하기 보다는 아이디를 사용한다.
지금은 제품을 리뷰하는 기능이 없지만 나중에 제품 리뷰 기능이 추가될 때 사용자의 아이디가 중복되면 누가 작성했는지 구분이 힘들어질 수도 있다. 이메일을 제품 리뷰에 사용하면 리뷰 작성자들의 개인 정보 노출 문제가 생긴다. 따라서 이메일 중복 체크와 동일하게 아이디 중복 체크도 필요하다고 생각한다.
</br>

**2. 장바구니 품목 삭제 기능과 선택 주문 기능**

지금은 장바구니에 한번 담은 품목은 삭제를 할 수 없다. 수량을 직접 입력해서 변경을 하려 해도 하얀색 배경에서 넘어가지 않는 버그가 발생한다. 장바구니에 넣었다 그 상품을 취소하는 일이 빈번한 만큼 장바구니에 담은 품목을 삭제할 수 있는 기능이 있어야 한다. 또한 장바구니에 들어있는 전체 품목을 한번에 삭제하는 기능을 추가하면 장바구니의 모든 품목 구매 후 삭제할 때와 공통으로 사용할 수 있을 것이다. 

대부분의 쇼핑 어플에서 선택한 품목만 주문할 수 있는 기능을 제공하고 있는데 이를 위해서는 주문하기에서 선택된 cartId만을 결제할 수 있도록 하고 선택하지 않은 품목은 장바구니에 그대로 남겨놓을 수 있도록 해야 한다. 지금은 장바구니의 품목과 결제 예정중인 품목을 따로 구분하지 않고 결제하기 클릭 시 해당 사용자 장바구니의 품목을 모두 결제하는 구조처럼 보여 장바구니의 품목을 선택해서 구매할 수 없을 것 같다.
</br>

**3. 리뷰 기능**

지금은 상품 위에 일괄적으로 별 4개를 확인할 수 있는데 리뷰 기능을 추가하여 사용자에게 상품에 대한 정보를 추가적으로 확인할 수 있게 한다. 따라서 리뷰 테이블이 따로 필요할 것이고 상품에 대한 모든 리뷰를 불러와 평균 별점을 계산한 후 상품 위에 띄워주는 과정이 필요할 것이다.
</br>

**4. 배송비 청구 기능**

현재는 모든 상품이 무료 배송이기 때문에 전 상품에 무료 배송 배너가 뜬다. 실제 서비스시 무료 배송이 아닌 상품도 있을 것이기 때문에 product 테이블의 필드에 배송비가 추가되어야 할 것이다. 또한 숨겨진 옵션에 배송비를 추가하여 장바구니 담기시 배송비 옵션도 자동으로 담기게 하여 배송비를 청구할 수 있다.
</br>

**5. 판매자 추가**

실제 카카오 쇼핑하기는 다수의 판매자가 가입하여 물건을 등록할 수 있는 오픈마켓 서비스이다. 따라서 이 경우 사용자를 판매자 객체와 소비자 객체로 분리해야 할 것이다. 또한 판매자로 로그인, 회원가입(판매자 등록)하는 서비스와 판매자가 상품 , 옵션, 재고 등록 및 수정을 할 수 있는 api를 모두 구현해야 할 것이다. 카카오 쇼핑하기에서는 쇼핑하기 홈과 판매자 홈이 따로 존재한다. 따라서 동일한 판매자의 물품만을 모아놓은 판매자 홈도 따로 구현을 해야 할 것이다. 이를 위해서는 이 상품은 어떤 판매자가 판매하는 지에 대한 정보를 알아야한다. 그러므로 product에 판매자의 id를 외래키로 추가할 수 있다.
</br>

**6. 상품 카테고리 추가**

상품의 카테고리를 추가하여 특정 카테고리의 상품만 노출하게 하는 기능을 구현하면 소비자는 아주 많은 상품들 중 원하는 카테고리만을 볼 수 있다. 또한 많은 인터넷 쇼핑몰 서비스에서 쿠폰 기능을 지원하는데 이 때 전체 상품에 적용되는 쿠폰도 존재하고 특정 카테고리에서만 적용되는 쿠폰도 존재한다. 상품마다 이러한 카테고리를 지정하면 후에 쿠폰의 적용 범위를 다양하게 지정할 수 있을 것이다. 
식품, 패션, 가전과 같은 카테고리는 대분류로, 패션 중 여성의류, 남성의류, 신발들은 중분류로, 신발 중 스니커즈, 슬리퍼, 러닝화 등은 소분류로 볼 수 있다. 이러한 대분류, 중분류, 소분류 필드를 상품 객체에 추가함으로써 원하는 카테고리에 해당하는 상품만을 사용자에게 노출할 수 있다.


## **과제 상세 : 수강생들이 과제를 진행할 때, 유념해야할 것**
아래 항목은 반드시 포함하여 과제 수행해주세요!
>- 부족한 기능에 대한 요구사항을 미리 예상할 수 있는가? (예를 들면 상품등록 api가 기존 요구사항에는 없는데 추후 필요하지는 않을지, 이런 부분들을 생각하였는지) 
>- 요구사항에 맞는 API를 분석하고 사용자 시나리오를 설계하였는가? (예를 들어 배포된 서버와 화면 설계를 제시해줄 예정인데, 특정 버튼을 클릭했을 때 어떤 API가 호출되어야 할지를 아는지)
>- 응답되는 데이터가 프론트앤드 화면에 모두 반영될 수 있는지를 체크하였는가?(예를 들어 배송관련 비용이 있는데, 이런것들이 API에는 없는데 이런 부분을 캐치할 수 있는지)
>- 테이블 설계가 모든 API를 만족할 수 있게 나왔는가? (테이블이 효율적으로 나왔는가 보다는 해당 테이블로 요구사항을 만족할 수 있는지에 대한 여부만)
>- 테이블명이 이해하기 쉽게 만들어졌는가? (상품테이블이 product이면 이해하기 쉽지만, material이라고 하면 이해하기 어렵기 때문)

</br>

### **2번**

**1. 메인 화면**

- GET /products : 상품의 내역들을 가져온다.
</br>

**2. 로그인 화면**

- POST /login : 사용자가 이메일 비밀번호를 입력하면 이 정보를 전송하여 로그인 성공 여부를 반환한다.
</br>

**3. 회원가입 화면**

- POST /check : 사용자가 작성한 이메일을 전송하여 이메일 중복 여부를 반환한다.
- POST /join : 이메일, 이름, 비밀번호를 전송하여 회원가입 성공 여부를 반환한다.
</br>

**4. 상품 상세 페이지 화면**

- GET /products/{products_id} : 상품의 상세 옵션들을 가져온다.
- POST /carts/add : 선택한 옵션들을 전송하여 이 옵션들을 장바구니에 담는다. request 헤더의 Authorization 필드에 토큰값이 필요하다.
</br>

**5. 장바구니 화면**

- GET /carts : 장바구니에 담은 품목들을 확인할 수 있다.
- POST /carts/update : 장바구니에서 수정한 정보를 전송하고 DB에 반영한 후 주문하기로 넘어간다.
</br>

**6. 주문하기 화면**

- POST /orders/save : 필수로 동의받아야 하는 항목이 true라면 토큰 정보를 같이 보내 해당 사용자 장바구니의 모든 품목을 구매하고 장바구니를 비운다. 
</br>

**7. 주문 완료 화면**

- GET /products : 상품의 내역을 볼 수 있는 메인페이지로 이동한다.
</br>


## **코드리뷰 관련: PR시, 아래 내용을 포함하여 코멘트 남겨주세요.**
**1. PR 제목과 내용을 아래와 같이 작성 해주세요.**

>- PR 제목 : 부산대BE_라이언_1주차 과제

</br>

**2. PR 내용 :**

>- 코드 작성하면서 어려웠던 점
>- 코드 리뷰 시, 멘토님이 중점적으로 리뷰해줬으면 하는 부분

# 2주차

카카오 테크 캠퍼스 2단계 - BE - 2주차 클론 과제
</br>
</br>

## **과제명**
```
1. 전체 API 주소 설계
2. Mock API Controller 구현
```

## **과제 설명**
```
1. API주소를 설계하여 README에 내용을 작성하시오.
2. 가짜 데이터를 설계하여 응답하는 스프링부트 컨트롤러를 작성하고 소스코드를 업로드하시오.
```

</br>

## **과제 상세 : 수강생들이 과제를 진행할 때, 유념해야할 것**
아래 항목은 반드시 포함하여 과제 수행해주세요!
>- 전체 API 주소 설계가 RestAPI 맞게 설계되었는가? (예를 들어 배포된 서버는 POST와 GET으로만 구현되었는데, 학생들은 PUT과 DELETE도 배울 예정이라 이부분이 반영되었고, 주소가 RestAPI에 맞게 설계되었는지)
>- 가짜 데이터를 설계하여 Mock API를 잘 구현하였는가? (예를 들어 DB연결없이 컨트롤러만 만들어서 배포된 서버의 응답과 동일한 형태로 데이터가 응답되는지 여부)
</br>

## **코드리뷰 관련: PR시, 아래 내용을 포함하여 코멘트 남겨주세요.**
**1. PR 제목과 내용을 아래와 같이 작성 해주세요.**

>- PR 제목 : 부산대BE_라이언_2주차 과제

</br>

**2. PR 내용 :**

>- 코드 작성하면서 어려웠던 점
>- 코드 리뷰 시, 멘토님이 중점적으로 리뷰해줬으면 하는 부분

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
>- 레포지토리 단위테스트가 구현되었는가?
>- 테스트 메서드끼리 유기적으로 연결되지 않았는가? (테스트는 격리성이 필요하다)
>- Persistene Context를 clear하여서 테스트가 구현되었는가? (더미데이터를 JPA를 이용해서 insert 할 예정인데, 레포지토리 테스트시에 영속화된 데이터 때문에 쿼리를 제대로 보지 못할 수 있기 때문에)
>- 테스트 코드의 쿼리 관련된 메서드가 너무 많은 select를 유발하지 않는지? (적절한 한방쿼리, 효율적인 in query, N+1 문제 등이 해결된 쿼리)
</br>

## **코드리뷰 관련: PR시, 아래 내용을 포함하여 코멘트 남겨주세요.**
**1. PR 제목과 내용을 아래와 같이 작성 해주세요.**

>- PR 제목 : 부산대BE_라이언_3주차 과제

</br>

**2. PR 내용 :**

>- 코드 작성하면서 어려웠던 점
>- 코드 리뷰 시, 멘토님이 중점적으로 리뷰해줬으면 하는 부분

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
>- 컨트롤러 단위테스트가 구현되었는가?
>- Mockito를 이용하여 stub을 구현하였는가?
>- 인증이 필요한 컨트롤러를 테스트할 수 있는가?
>- 200 ok만 체크한 것은 아닌가? (해당 컨트롤러에서 제일 필요한 데이터에 대한 테스트가 구현되었는가?)
</br>

## **코드리뷰 관련: PR시, 아래 내용을 포함하여 코멘트 남겨주세요.**
**1. PR 제목과 내용을 아래와 같이 작성 해주세요.**

>- PR 제목 : 부산대BE_라이언_4주차 과제 

</br>

**2. PR 내용 :**

>- 코드 작성하면서 어려웠던 점
>- 코드 리뷰 시, 멘토님이 중점적으로 리뷰해줬으면 하는 부분

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
>- 실패 단위 테스트가 구현되었는가?
>- 모든 예외에 대한 실패 테스트가 구현되었는가?
</br>

## **코드리뷰 관련: PR시, 아래 내용을 포함하여 코멘트 남겨주세요.**
**1. PR 제목과 내용을 아래와 같이 작성 해주세요.**

>- PR 제목 : 부산대BE_라이언_5주차 과제

</br>

**2. PR 내용 :**

>- 코드 작성하면서 어려웠던 점
>- 코드 리뷰 시, 멘토님이 중점적으로 리뷰해줬으면 하는 부분

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
>- 통합테스트가 구현되었는가?
>- API문서가 구현되었는가?
>- 배포가 정상적으로 되었는가?
>- 서비스에 문제가 발생했을 때, 로그를 통해 문제를 확인할 수 있는가?
</br>

## **코드리뷰 관련: PR시, 아래 내용을 포함하여 코멘트 남겨주세요.**
**1. PR 제목과 내용을 아래와 같이 작성 해주세요.**

>- PR 제목 : 부산대BE_라이언_6주차 과제

</br>

**2. PR 내용 :**

>- 코드 작성하면서 어려웠던 점
>- 코드 리뷰 시, 멘토님이 중점적으로 리뷰해줬으면 하는 부분
