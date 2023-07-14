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

</br>

# **1주차 과제 제출**

### **1. 요구사항 시나리오를 보고 부족해 보이는 기능을 하나 이상 체크하여 README에 내용을 작성하시오.**

1. (장바구니) 상품 수량 수정 시 DB 갱신

    현재 장바구니 화면에서 상품의 수량을 수정한 후, 주문을 하지 않고 다른 화면으로 이동하면 해당 수정 정보가 DB에 갱신되지 않는다.
    </br>
    그러므로 수량을 조정하는 버튼을 클릭할 때 혹은 다른 화면으로 이동 시에 장바구니에 담긴 상품 정보를 서버로 전달해주는 API가 필요할 것으로 보인다. 

2. (상세 페이지, 장바구니) 상품 삭제 기능

    현재 상품 상세 페이지와 장바구니 화면에서 선택한 상품을 삭제할 수 있는 방법이 없다. 다만 이는 프론트 측에서 구현이 가능할 것으로 보인다.

3. (장바구니) 같은 제품 담을 시 업데이트 기능

    현재 장바구니에 담겨있는 상품(옵션)을 다시 선택하여 장바구니에 담으려고 하면 오류가 발생한다. 이를 장바구니에 담겨있는 상품의 개수에 새로 담으려는 상품의 개수가 더해지도록 기능을 수정해야 한다. 

4. (메인) 상품 검색 기능

    현재는 검색 기능이 없다. 이를 추가하면 사용자의 편의에 도움이 될 것으로 보인다.

</br>

### **2. 제시된 화면설계를 보고 해당 화면설계와 배포된 기존 서버의 API주소를 매칭하여 README에 내용을 작성하시오. (카카오 화면설계 시나리오가 있음)**

| 기능 | 사용자 시나리오 | 도메인 | 메소드 |
|------|----------------|--------|--------|
|**로그인 및 회원가입 관련**|
|[(기능1) 회원 가입](#기능1-회원-가입)|회원가입 버튼을 눌렀을 때 동작|/join|POST|
|[(기능2) 로그인](#기능2-로그인)|로그인 버튼을 눌렀을 때 동작|/login|POST|
|(기능3) 로그아웃|로그아웃 버튼을 눌렀을 때 동작|프론트에서 구현|        |
|[(추가기능) 이메일 중복 체크](#추가기능-이메일-중복-체크)|이메일 중복 확인 버튼을 눌렀을 때 동작|/check|POST|
|**상품 조회 관련**|
|[(기능4) 전체 상품 목록 조회](#기능4-전체-상품-목록-조회)|1. 로고 클릭 시</br>2. 로그인 후</br>3. base URL로 접속 시|/products|GET|
|[(기능5) 개별 상품 상세 조회](#기능5-개별-상품-상세-조회)|개별 상품 클릭 시|/products/{productID}|GET|
|(기능6) 상품 옵션 선택|상세 페이지에서 옵션 클릭 시|프론트에서 구현|        |
|(기능7) 옵션 확인 및 수량 결정|(기능 6)에서 선택된 옵션의 개수 조정 버튼 클릭 시|프론트에서 구현|        |
|**장바구니, 결제 및 주문 관련**|
|[(기능8) 장바구니 담기](#기능8-장바구니-담기)|장바구니 담기 버튼을 눌렀을 때 동작|/carts/add|POST|
|[(기능9) 장바구니 보기](#기능9-장바구니-보기)|장바구니 이모티콘을 눌렀을 때 동작|/carts|GET|
|(기능10) 장바구니 상품 확인 및 수량 결정|장바구니 내에서 수량 조절 버튼 클릭 시|프론트에만 구현되어있음 -> 백엔드에서도 구현 필요|        |
|[(기능11) 주문](#기능11-주문)|주문하기 버튼을 눌렀을 때 동작|/carts/update|POST|
|[(기능12) 결제](#기능12-결제)|결제하기 버튼을 눌렀을 때 동작|/orders/save|POST|
|[(기능13) 주문 결과 확인](#기능13-주문-결과-확인)|/orders/save 동작 성공 이후 동작|/orders/{orderID}|GET|

</br>

### **3. 배포된 서버에 모든 API를 POSTMAN으로 요청해본 뒤 응답되는 데이터를 확인하고 부족한 데이터가 무엇인지 체크하여 README에 내용을 작성하시오.**

* #### **(기능1) 회원 가입**

    * **요청 데이터**

        ```json
        {
            "username":"mata",
            "email":"meta@nate.com",
            "password":"meta1234!"

        }
        ```
    * **응답 데이터**

        ```json
        {
            "success": true,
            "response": null,
            "error": null
        }
        ```

    * **에러 처리**
        1. 이메일 양식
            
            ```json
            {
                "success" : false,
                "response" : null,
                "error" : {
                    "message" : "이메일 형식으로 작성해주세요:email",
                    "status" : 400
                }
            }
            ```
            
        2. 비밀번호 양식
            
            ```json
            {
                "success": false,
                "response": null,
                "error": {
                    "message": "영문, 숫자, 특수문자가 포함되어야하고 공백이 포함될 수 없습니
                    다.:password",
                    "status": 400
                }
            }
            ```
            
        3. 동일한 이메일로 가입
            
            ```json
            {
                "success": false,
                "response": null,
                "error": {
                    "message": "동일한 이메일이 존재합니다 : ssar@nate.com",
                    "status": 400
                }
            }
            ```
            
        4. 비밀번호 길이

            ```json
            {
                "success": false,
                "response": null,
                "error": {
                    "message": "8에서 20자 이내여야 합니다.:password",
                    "status": 400
                }
            }
            ```
---
* #### **(기능2) 로그인**

    * **요청 데이터**
        
        ```json
        {
            "email":"ssar@nate.com",
            "password":"meta1234!"
        }
        ```
        
        +Response Header에 JWT 토큰 추가
    
    * **응답 데이터**
        
        ```json
        {
            "success": true,
            "response": null,
            "error": null
        }
        ```
        
    * **에러 처리**
        1. 이메일 형식
            
            ```json
            {
                "success": false,
                "response": null,
                "error": {
                    "message": "이메일 형식으로 작성해주세요:email",
                    "status": 400
                }
            }
            ```
            
        2. 비밀번호 형식
            
            ```json
            {
                "success": false,
                "response": null,
                "error": {
                    "message": "영문, 숫자, 특수문자가 포함되어야하고 공백이 포함될 수 없습니
                    다.:password",
                    "status": 400
                }
            }
            ```
            
        3. 가입되지 않은 사용자
            
            ```json
            {
                "success": false,
                "response": null,
                "error": {
                    "message": "인증되지 않았습니다",
                    "status": 401
                }
            }
            ```
            
        4. 비밀번호 길이
            
            ```json
            {
                "success": false,
                "response": null,
                "error": {
                    "message": "8에서 20자 이내여야 합니다.:password",
                    "status": 400
                }
            }
            ```
---
* #### **(추가기능) 이메일 중복 체크**

    * **요청 데이터**
    
        ```json
        {
            "email":"meta@nate.com"
        }
        ```
    
    * **응답 데이터**
        
        ```json
        {
            "success": true,
            "response": null,
            "error": null
        }
        ```
        
    * **에러 처리**
        1. 동일한 이메일 존재
            
            ```json
            {
                "success": false,
                "response": null,
                "error": {
                    "message": "동일한 이메일이 존재합니다 : ssar@nate.com",
                    "status": 400
                }
            }
            ```
            
        2. 이메일 형식
            
            ```json
            {
                "success": false,
                "response": null,
                "error": {
                    "message": "이메일 형식으로 작성해주세요:email",
                    "status": 400
                }
            }
            ```
---
* #### **(기능4) 전체 상품 목록 조회** !추가 데이터 필요!

    * **파라미터**
    
        page = {number}
        
        default = 0
    
    * **응답 데이터**
        
        ```json
        {
            "success": true,
            "response": [
                {
                    "id": 1,
                    "productName": "기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외
                    주방용품 특가전",
                    "description": "",
                    "image": "/images/1.jpg",
                    "price": 1000
                },
                {
                    "id": 2,
                    "productName": "[황금약단밤 골드]2022년산 햇밤 칼집밤700g외/군밤용/생율",
                    "description": "",
                    "image": "/images/2.jpg",
                    "price": 2000
                },
                {
                    "id": 3,
                    "productName": "삼성전자 JBL JR310 외 어린이용/성인용 헤드셋 3종!",
                    "description": "",
                    "image": "/images/3.jpg",
                    "price": 30000
                },
                {
                    "id": 4,
                    "productName": "바른 누룽지맛 발효효소 2박스 역가수치보장 / 외 7종",
                    "description": "",
                    "image": "/images/4.jpg",
                    "price": 4000
                },
                {
                    "id": 5,
                    "productName": "[더주] 컷팅말랑장족, 숏다리 100g/300g 외 주전부리 모음 /
                    중독성 최고/마른안주",
                    "description": "",
                    "image": "/images/5.jpg",
                    "price": 5000
                },
                {
                    "id": 6,
                    "productName": "굳지않는 앙금절편 1,050g 2팩 외 우리쌀떡 모음전",
                    "description": "",
                    "image": "/images/6.jpg",
                    "price": 15900
                },
                {
                    "id": 7,
                    "productName": "eoe 이너딜리티 30포, 오렌지맛 고 식이섬유 보충제",
                    "description": "",
                    "image": "/images/7.jpg",
                    "price": 26800
                },
                {
                    "id": 8,
                    "productName": "제나벨 PDRN 크림 2개. 피부보습/진정 케어",
                    "description": "",
                    "image": "/images/8.jpg",
                    "price": 25900
                },
                {
                    "id": 9,
                    "productName": "플레이스테이션 VR2 호라이즌 번들. 생생한 몰입감",
                    "description": "",
                    "image": "/images/9.jpg",
                    "price": 797000
                }
            ],
            "error": null
        }
        ```

    * **추가 데이터**

        "상품을 저장해둔 데이터베이스에서 **주문이 가능한** 전체 상품 목록을 Response로 반환"이라는 요구사항을 충족하기 위해서 재고 데이터를 추가해야 한다.
---
* #### **(기능5) 개별 상품 상세 조회**

    * **파라미터**

        없음
        
    * **응답 데이터**
        
        ```json
        {
            "success": true,
            "response": {
                "id": 1,
                "productName": "기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용
                품 특가전",
                "description": "",
                "image": "/images/1.jpg",
                "price": 1000,
                "starCount": 5,
                "options": [
                    {
                        "id": 1,
                        "optionName": "01. 슬라이딩 지퍼백 크리스마스에디션 4종",
                        "price": 10000
                    },
                    {
                        "id": 2,
                        "optionName": "02. 슬라이딩 지퍼백 플라워에디션 5종",
                        "price": 10900
                    },
                    {
                        "id": 3,
                        "optionName": "고무장갑 베이지 S(소형) 6팩",
                        "price": 9900
                    },
                    {
                        "id": 4,
                        "optionName": "뽑아쓰는 키친타올 130매 12팩",
                        "price": 16900
                    },
                    {
                        "id": 5,
                        "optionName": "2겹 식빵수세미 6매",
                        "price": 8900
                    }
                ]
            },
            "error": null
        }
        ```        
---
* #### **(기능8) 장바구니 담기**

    * **요청 데이터**
    
        ```json
        [
            {
                "optionId":1,
                "quantity":5
            },
            {
                "optionId":2,
                "quantity":5
            }
        ]
        ```
    
        +Response Header에 JWT 토큰 추가
    
    * **응답 데이터**
        
        ```json
        {
            "success": true,
            "response": null,
            "error": null
        }
        ```
---
* #### **(기능9) 장바구니 보기** !추가 데이터 필요!

    * **파라미터**
    
        없음
        
        +Response Header에 JWT 토큰 추가
    
    * **응답 데이터**
        
        ```json
        {
            "success": true,
            "response": {
            "products": [
                {
                "id": 1,
                "productName": "기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션
                외 주방용품 특가전",
                "carts": [
                        {
                            "id": 4,
                            "option": {
                                "id": 1,
                                "optionName": "01. 슬라이딩 지퍼백 크리스마스에디션 4
                                종",
                                "price": 10000
                            },
                            "quantity": 5,
                            "price": 50000
                            },
                            {
                                "id": 5,
                                "option": {
                                "id": 2,
                                "optionName": "02. 슬라이딩 지퍼백 플라워에디션 5종",
                                "price": 10900
                            },
                            "quantity": 5,
                            "price": 54500
                        }
                    ]
                }
            ],
            "totalPrice": 104500
            },
            "error": null
        }
        ```
    * **추가 데이터**

        1. "장바구니에 담긴 상품 데이터(**이미지**, 상품명, 옵션 등)를 Response로 반환" 이라는 요구사항을 충족하기 위해서 상품의 이미지 데이터를 추가해야 한다.
        2. 또한 현재 다른 유저로 로그인을 해도 과거 다른 유저가 장바구니에 담아놓은 정보가 사라지지 않는 오류가 발견된다.

---
* #### **(기능11) 주문** !추가 데이터 필요!

    * **요청 데이터**
    
        ```json
        [
            {
                "cartId":4,
                "quantity":10
            },
            {
                "cartId":5,
                "quantity":10
            }
        ]
        ```
        
        +Response Header에 JWT 토큰 추가
    
    * **응답 데이터**
        
        ```json
        {
            "success": true,
            "response": {
            "carts": [
                {
                    "cartId": 4,
                    "optionId": 1,
                    "optionName": "01. 슬라이딩 지퍼백 크리스마스에디션 4종",
                    "quantity": 10,
                    "price": 100000
                },
                {
                    "cartId": 5,
                    "optionId": 2,
                    "optionName": "02. 슬라이딩 지퍼백 플라워에디션 5종",
                    "quantity": 10,
                    "price": 109000
                }
            ],
            "totalPrice": 209000
            },
            "error": null
        }
        ```
    * **추가 데이터**

        "옵션 데이터뿐 아니라 **해당 옵션들의 상품명**, 옵션명도 같이 반환"이라는 요구사항을 충족하기 위해서 상품의 이름 데이터가 추가되어야 한다.
---
* #### **(기능12) 결제**

    * **요청 데이터**
    
        ```json
        {
            "success": true,
            "response": {
                "id": 2,
                "products": [
                    {
                        "productName": "기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션
                        외 주방용품 특가전",
                        "items": [
                            {
                                "id": 4,
                                "optionName": "01. 슬라이딩 지퍼백 크리스마스에디션 4종",
                                "quantity": 10,
                                "price": 100000
                            },
                            {
                            "id": 5,
                            "optionName": "02. 슬라이딩 지퍼백 플라워에디션 5종",
                            "quantity": 10,
                            "price": 109000
                            }
                        ]
                    }
                ],
                "totalPrice": 209000
            },
            "error": null
        }
        ```
        
        +Response Header에 JWT 토큰 추가
    
    * **응답 데이터**
        
        ```json
        {
            "success": true,
            "response": {
                "id": 2,
                "products": [
                    {
                        "productName": "기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션
                        외 주방용품 특가전",
                        "items": [
                            {
                                "id": 4,
                                "optionName": "01. 슬라이딩 지퍼백 크리스마스에디션 4종",
                                "quantity": 10,
                                "price": 100000
                            },
                            {
                                "id": 5,
                                "optionName": "02. 슬라이딩 지퍼백 플라워에디션 5종",
                                "quantity": 10,
                                "price": 109000
                            }
                        ]
                    }
                ],
                "totalPrice": 209000
            },
            "error": null
        }
        ```
---
* #### **(기능13) 주문 결과 확인**

    * **파라미터**
        
        없음
        
        +Response Header에 JWT 토큰 추가
    
    * **응답 데이터**
        
        ```json
        {
            "success": true,
            "response": {
                    "id": 2,
                    "products": [
                            {
                                "productName": "기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션
                                외 주방용품 특가전",
                                "items": [
                                    {
                                        "id": 4,
                                        "optionName": "01. 슬라이딩 지퍼백 크리스마스에디션 4종",
                                        "quantity": 10,
                                        "price": 100000
                                    },
                                    {
                                        "id": 5,
                                        "optionName": "02. 슬라이딩 지퍼백 플라워에디션 5종",
                                        "quantity": 10,
                                        "price": 109000
                                }
                            ]
                        }
                    ],
                    "totalPrice": 209000
                },
            "error": null
        }
        ```
</br>

### **4. 테이블 설계를 하여 README에 ER-Diagram을 추가하여 제출하시오.**

![ER Diagram](./img/ERD.jpg)

(각 테이블 별 정보는 pdf에 첨부되어있습니다.)

</br>

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
>- User 도메인을 제외한 전체 API 주소 설계가 RestAPI 맞게 설계되었는가?  POST와 GET으로만 구현되어 있어도 됨.	
>- 가짜 데이터를 설계하여 Mock API를 잘 구현하였는가? (예를 들어 DB연결없이 컨트롤러만 만들어서 배포된 서버의 응답과 동일한 형태로 데이터가 응답되는지 여부)
>- DTO에 타입은 올바르게 지정되었는가?
>- DTO에 이름은 일관성이 있는가? (예를 들어 어떤 것은 JoinDTO, 어떤 것은 joinDto, 어떤 것은 DtoJoin 이런식으로 되어 있으면 일관성이 없는것이다)
>- DTO를 공유해서 쓰면 안된다 (동일한 데이터가 응답된다 하더라도, 화면은 수시로 변경될 수 있기 때문에 DTO를 공유하고 있으면 배점을 받지 못함)
</br>

## **코드리뷰 관련: PR시, 아래 내용을 포함하여 코멘트 남겨주세요.**
**1. PR 제목과 내용을 아래와 같이 작성 해주세요.**

>- PR 제목 : 부산대BE_라이언_2주차 과제

</br>

**2. PR 내용 :**

>- 코드 작성하면서 어려웠던 점
>- 코드 리뷰 시, 멘토님이 중점적으로 리뷰해줬으면 하는 부분

</br> 

# **2주차 과제 제출**

### **1. API주소를 설계하여 README에 내용을 작성하시오.**

| 기능 | 사용자 시나리오 | 도메인 | 메소드 |
|------|----------------|--------|--------|
|**로그인 및 회원가입 관련**|
|(기능1) 회원 가입|회원가입 버튼을 눌렀을 때 동작|/join|POST|
|(기능2) 로그인|로그인 버튼을 눌렀을 때 동작|/login|POST|
|(기능3) 로그아웃|로그아웃 버튼을 눌렀을 때 동작|프론트에서 구현|        |
|(추가기능) 이메일 중복 체크|이메일 중복 확인 버튼을 눌렀을 때 동작|/check|POST|
|**상품 조회 관련**|
|(기능4) 전체 상품 목록 조회|1. 로고 클릭 시</br>2. 로그인 후</br>3. base URL로 접속 시|/products|GET|
|(기능5) 개별 상품 상세 조회|개별 상품 클릭 시|/products/{productID}|GET|
|(기능6) 상품 옵션 선택|상세 페이지에서 옵션 클릭 시|프론트에서 구현|        |
|(기능7) 옵션 확인 및 수량 결정|(기능 6)에서 선택된 옵션의 개수 조정 버튼 클릭 시|프론트에서 구현|        |
|(추가기능) 상품 검색|검색 버튼 클릭 시|/products/search?name={name}|GET|
|**장바구니, 결제 및 주문 관련**|
|(기능8) 장바구니 담기|장바구니 담기 버튼을 눌렀을 때 동작|/carts/add|PATCH|
|(기능9) 장바구니 보기|장바구니 이모티콘을 눌렀을 때 동작|/carts|GET|
|(추가기능) 장바구니 상품 삭제|삭제 버튼 클릭 시|/carts/update|DELETE
|(기능10) 장바구니 상품 확인 및 수량 결정|장바구니 내에서 수량 변경 버튼 클릭 시|/carts/update|PATCH|
|(기능11) 주문|주문하기 버튼을 눌렀을 때 동작|/carts/update|DELETE|
|(기능12) 결제|결제하기 버튼을 눌렀을 때 동작|/orders/save|POST|
|(기능13) 주문 결과 확인|/orders/save 동작 성공 이후 동작|/orders/{orderID}|GET|

</br>

### **2. 가짜 데이터를 설계하여 응답하는 스프링부트 컨트롤러를 작성하고 소스코드를 업로드하시오.**

+ 2week 폴더에 업로드 했습니다.

+ UserRestController의 경우 강사님이 작성하셨고 수정하지 말라고 하셔서 email 중복 확인 API를 구현하지 않았습니다. 

+ 그 외에 강사님이 작성하신 코드는 주석으로 표시해 두었습니다. 참고 부탁드립니다. 

+ 해당 과제는 1번 과제에서 작성한 Http Method를 따르지 않고 1주차에 제공받은 API 문서를 기준으로 작성되었습니다. API 문서는 2week 폴더에 함께 업로드 했습니다.

+ **Postman을 이용한 TEST 결과 값**

    + **/carts/add**

        ![/carts/add](./img/carts-add.png)

    + **/carts/update**

        ![/carts/update](./img/carts-update.png)

    + **orders/save**

        ![/orders/save](./img/orders-save.png)

    + **orders/{id}**

         ![/orders/id](./img/orders-id.png)

</br>

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
>- BDD 패턴으로 구현되었는가? given, when, then

</br>

# **3주차 과제 제출**

### **1. 레포지토리 단위테스트를 구현하여 소스코드를 제출하시오.**

+ 3week 폴더에 업로드 했습니다.

+ UserJPARepositoryTest의 경우 강사님이 작성하셨고 수정하지 말라고 하셔서 추가 구현은 하지 않았습니다.

+ 그 외에 강사님이 작성하신 코드는 주석으로 표시해 두었습니다. 참고 부탁드립니다.

+ 즉시로딩과 지연로딩을 고려하여 테스트 케이스를 짰습니다. 다만 PR 내용에서도 말씀 드렸듯 연속적인 연관 관계(ex. cart - option - product)에 대한 처리가 미숙해서 코드가 복잡할 수 있습니다.

</br>

### **2. 쿼리를 테스트하면서 가장 좋은 쿼리를 작성해보시오.**

+ 장바구니 조회
</br>

    두 번의 select 쿼리만을 사용하는 cart_mFindByUserId_lazy_test 함수가 제일 효율적인 것으로 추측된다.

    ```sql
    select
        product0_.id as id1_4_0_,
        product0_.description as descript2_4_0_,
        product0_.image as image3_4_0_,
        product0_.price as price4_4_0_,
        product0_.product_name as product_5_4_0_ 
    from
        product_tb product0_ 
    where
        product0_.id=?

    select
        cart0_.id as id1_0_0_,
        option1_.id as id1_2_1_,
        user2_.id as id1_5_2_,
        cart0_.option_id as option_i4_0_0_,
        cart0_.price as price2_0_0_,
        cart0_.quantity as quantity3_0_0_,
        cart0_.user_id as user_id5_0_0_,
        option1_.option_name as option_n2_2_1_,
        option1_.price as price3_2_1_,
        option1_.product_id as product_4_2_1_,
        user2_.email as email2_5_2_,
        user2_.password as password3_5_2_,
        user2_.roles as roles4_5_2_,
        user2_.username as username5_5_2_ 
    from
        cart_tb cart0_ 
    inner join
        option_tb option1_ 
            on cart0_.option_id=option1_.id 
    inner join
        user_tb user2_ 
            on cart0_.user_id=user2_.id 
    where
        cart0_.user_id=?
    ```
</br>

+ 장바구니 업데이트
</br>

    장바구니 물건 각각을 수정해야하므로 업데이트 해야할 상품의 개수만큼 update 쿼리를 실행해야한다. 

    ```sql
    update
        cart_tb 
    set
        option_id=?,
        price=?,
        quantity=?,
        user_id=? 
    where
        id=?

    .
    .
    .
    ```
</br>

+ 주문 상품 조회
</br>

    세 번의 select 쿼리와 2번의 inner join만을 사용하는 item_mFindByOrderId_lazy_test 함수가 제일 효율적인 것으로 추측된다.

    ```sql
    select
        product0_.id as id1_4_0_,
        product0_.description as descript2_4_0_,
        product0_.image as image3_4_0_,
        product0_.price as price4_4_0_,
        product0_.product_name as product_5_4_0_ 
    from
        product_tb product0_ 
    where
        product0_.id=?

    select
        user0_.id as id1_5_0_,
        user0_.email as email2_5_0_,
        user0_.password as password3_5_0_,
        user0_.roles as roles4_5_0_,
        user0_.username as username5_5_0_ 
    from
        user_tb user0_ 
    where
        user0_.id=?

    select
        item0_.id as id1_1_0_,
        option1_.id as id1_2_1_,
        order2_.id as id1_3_2_,
        item0_.option_id as option_i4_1_0_,
        item0_.order_id as order_id5_1_0_,
        item0_.price as price2_1_0_,
        item0_.quantity as quantity3_1_0_,
        option1_.option_name as option_n2_2_1_,
        option1_.price as price3_2_1_,
        option1_.product_id as product_4_2_1_,
        order2_.user_id as user_id2_3_2_ 
    from
        item_tb item0_ 
    inner join
        option_tb option1_ 
            on item0_.option_id=option1_.id 
    inner join
        order_tb order2_ 
            on item0_.order_id=order2_.id 
    where
        item0_.order_id=?
    ```
</br>

+ 주문 조회
</br>

    한 번의 select 쿼리를 사용하는 order_mFindByOrderId_lazy_test 함수가 제일 효율적인 것으로 추측된다.

    ```sql
    select
        order0_.id as id1_3_0_,
        user1_.id as id1_5_1_,
        order0_.user_id as user_id2_3_0_,
        user1_.email as email2_5_1_,
        user1_.password as password3_5_1_,
        user1_.roles as roles4_5_1_,
        user1_.username as username5_5_1_ 
    from
        order_tb order0_ 
    inner join
        user_tb user1_ 
            on order0_.user_id=user1_.id 
    where
        order0_.user_id=?
    ```
</br>

+ 주문 생성
</br>

    주문 물건 각각을 생성해야하므로 주문한 상품 종류의 수만큼 insert 쿼리를 실행해야한다. 장바구니에서 주문한 제품을 삭제할 때는 deleteAllInBatch를 사용하여 한번의 delete 쿼리를 실행한다. 

    ```sql
    insert 
    into
        order_tb
        (id, user_id) 
    values
        (default, ?)
    .
    .
    .
    delete 
    from
        cart_tb 
    where
        id=? 
        or id=?
    ```

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
>- 모든 요청과 응답이 json으로 처리되어 있는가?
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
>- 예외에 대한 처리를 ControllerAdvice or RestControllerAdvice로 구현하였는가?
>- Validation 라이브러리를 사용하여 유효성 검사가 되었는가?
>- 테스트는 격리되어 있는가?
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
```

</br>

## **과제 상세 : 수강생들이 과제를 진행할 때, 유념해야할 것**
아래 항목은 반드시 포함하여 과제 수행해주세요!
>- 통합테스트가 구현되었는가?
>- API문서가 구현되었는가?
>- 배포가 정상적으로 되었는가?
>- 프로그램이 정상 작동되고 있는가?
>- API 문서에 실패 예시가 작성되었는가?
</br>

## **코드리뷰 관련: PR시, 아래 내용을 포함하여 코멘트 남겨주세요.**
**1. PR 제목과 내용을 아래와 같이 작성 해주세요.**

>- PR 제목 : 부산대BE_라이언_6주차 과제

</br>

**2. PR 내용 :**

>- 코드 작성하면서 어려웠던 점
>- 코드 리뷰 시, 멘토님이 중점적으로 리뷰해줬으면 하는 부분