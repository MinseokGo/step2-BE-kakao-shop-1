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

## **과제 상세 : 수강생들이 과제를 진행할 때, 유념해야할 것**
아래 항목은 반드시 포함하여 과제 수행해주세요!
>- 부족한 기능에 대한 요구사항을 미리 예상할 수 있는가? (예를 들면 상품등록 api가 기존 요구사항에는 없는데 추후 필요하지는 않을지, 이런 부분들을 생각하였는지) 
>- 요구사항에 맞는 API를 분석하고 사용자 시나리오를 설계하였는가? (예를 들어 배포된 서버와 화면 설계를 제시해줄 예정인데, 특정 버튼을 클릭했을 때 어떤 API가 호출되어야 할지를 아는지)
>- 응답되는 데이터가 프론트앤드 화면에 모두 반영될 수 있는지를 체크하였는가?(예를 들어 배송관련 비용이 있는데, 이런것들이 API에는 없는데 이런 부분을 캐치할 수 있는지)
>- 테이블 설계가 모든 API를 만족할 수 있게 나왔는가? (테이블이 효율적으로 나왔는가 보다는 해당 테이블로 요구사항을 만족할 수 있는지에 대한 여부만)
>- 테이블명이 이해하기 쉽게 만들어졌는가? (상품테이블이 product이면 이해하기 쉽지만, material이라고 하면 이해하기 어렵기 때문)

</br>

## **코드리뷰 관련: PR시, 아래 내용을 포함하여 코멘트 남겨주세요.**
**1. PR 제목과 내용을 아래와 같이 작성 해주세요.**

>- PR 제목 : 부산대BE_라이언_1주차 과제

</br>

**2. PR 내용 :**

>- 코드 작성하면서 어려웠던 점
>- 코드 리뷰 시, 멘토님이 중점적으로 리뷰해줬으면 하는 부분

## **과제명**
1. 요구사항 시나리오에서 부족해 보이는 기능을 하나 이상 체크
2. 제시된 화면 설계와 API 주소 매칭  
> (기능1) 회원 가입(버튼 클릭) : /join  
> (기능2) 로그인(버튼 클릭) : /login  
> (기능3) 로그아웃(버튼 클릭) : /logout  
> (기능4) 전체 상품 목록 조회 : /products  
> (기능5) 개별 상품 상세 조회(상품 클릭) : /products/1  
> (기능6) 상품 옵션 선택 :   
> (기능7) 옵션 확인 및 수량 결정 :   
> (기능8) 장바구니 담기(버튼 클릭) : /carts/add  
> (기능9) 장바구니 보기(버튼 클릭) : /carts  
> (기능10) 장바구니 상품 옵션 확인 및 수량 결정 : /carts/update  
> (기능11) 주문 : /orders  
> (기능12) 결제 : /orders/save  
> (기능13) 주문 결과 확인 : /orders/1  

3. 현재 배포된 서버의 모든 API를 테스트하고 부족한 데이터를 찾고 개선하기
>3.1. 전체 상품 목록 조회 (/products)  
>- 정상요청 - 일치  
>- param 사용(?page=1) - 일치  

> 3.2. 개별 상품 상세 조회 (/products/1)  
>- 정상요청 - 일치  

> 3.3. 이메일 중복 체크,미사용 기능 (/check)  
>- 정상요청 - 일치
>- 실패예시 1(중복) - 일치
>- 실패예시 2(양식) - 일치

> 3.4. 회원가입 (/join)  
>- 정상요청 - 일치
>- 실패예시 1(이메일양식) - 일치
>- 실패예시 2(비밀번호양식) - 일치
>- 실패예시 3(중복) - 일치
>- 실패예시 4(비밀번호길이) - 일치

> 3.5. 로그인 (/login)  
> 중복전송을 하면 중복로그인이 되므로 세션을 추가하여  
> 중복 로그인등을 검사할 필요가 있어보임   
>- 정상요청 - 일치
>- 실패예시 1(이메일양식) - 일치
>- 실패예시 2(비밀번호양식) - 일치
>- 실패예시 3(미등록계정) - 일치
>- 실패예시 4(비밀번호길이) - 일치

> 3.6 장바구니 담기 (/carts/add)  
같은 상품을 담으면 추가되야하는데 오류가 발생함(개선필요)  
주문하기 또는 장바구니 수정과의 유사한 처리가 발생하여야 한다.
>- 정상요청 - 일치

> 3.7 장바구니 조회 (/carts)
>- 정상요청 - 일치

> 3.8 주문하기 또는 장바구니 수정 (/carts/update)  
자료상에서는 앞에서 담지 않았던 상품을 담았기에
요청의 일관성이 깨진다.  
그러므로 앞에서 담은 장바구니의 상품id를 기반으로 재요청했다.  
>- 정상요청 - 성공

> 3.9 결재하기 (/orders/save)  
장바구니의 내용을 주문 아이템으로 옮긴뒤 응답
>- 정상요청 - 성공

> 3.10 주문 결과 확인 (/orders/1)
방금 결재한 주문의 결과를 다시 상기시켜주기 위한 응답  
경로가 1로 되어있는데 이걸 index로 봐야할지는 고민중
>- 정상요청 - 성공
4. 테이블을 설계하여 E-R diagram 제출하기
5. 현재 배포된 서버의 기준이 모호해서 코드가 공개된 기존 서버를 기준으로한 새로운 테스트
>5.1. 전체 상품 목록 조회 (/products)  
>- 미구현

> 5.2. 개별 상품 상세 조회 (/products/1)  
>- 미구현

> 5.3. 이메일 중복 체크,미사용 기능 (/check)  
>- 정상요청 - 일치
>- 실패예시 1(중복) - 불일치 -> 계정이 추가되어있지 않아서 이럴 수
>- 실패예시 2(양식) - 일치

> 5.4. 회원가입 (/join)  
>- 정상요청 - 일치
>- 실패예시 1(이메일양식) - 일치
>- 실패예시 2(비밀번호양식) - 일치
>- 실패예시 3(중복) - 불일치 -> 5.3에서의 추측처럼 계정이 들어가 있지 않았음
>- 실패예시 4(비밀번호길이) - 일치

> 5.5. 로그인 (/login)  
> 굳이 로그인에서 비밀번호의 자세한 오류를 보여줘야할 필요가 있는지는 궁금함
>- 정상요청 - 일치
>- 실패예시 1(이메일양식) - 일치
>- 실패예시 2(비밀번호양식) - 일치
>- 실패예시 3(미등록계정) - 일치
>- 실패예시 4(비밀번호길이) - 일치

> 5.6 장바구니 담기 (/carts/add)  
>- 미구현

> 5.7 장바구니 조회 (/carts)
>- 미구현

> 5.8 주문하기 또는 장바구니 수정 (/carts/update)  
>- 미구현

> 5.9 결재하기 (/orders/save)  
>- 미구현

> 5.10 주문 결과 확인 (/orders/1)
>- 미구현
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
