package com.example.kakaoshop.domain.product;

import com.example.kakaoshop.domain.product.option.ProductOption;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductMockRepository {

  List<Product> findAll() {
    // return mock data
    return List.of(
      new Product(1, "기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전", "", "/images/1.jpg", 1000),
      new Product(2, "[황금약단밤 골드]2022년산 햇밤 칼집밤700g외/군밤용/생율", "", "/images/2.jpg", 2000),
      new Product(3, "삼성전자 JBL JR310 외 어린이용/성인용 헤드셋 3종!", "", "/images/3.jpg", 30000),
      new Product(4, "바른 누룽지맛 발효효소 2박스 역가수치보장 / 외 7종", "", "/images/4.jpg", 4000),
      new Product(5, "[더주] 컷팅말랑장족, 숏다리 100g/300g 외 주전부리 모음 /중독성 최고/마른안주", "", "/images/5.jpg", 5000),
      new Product(6, "굳지않는 앙금절편 1,050g 2팩 외 우리쌀떡 모음전", "", "/images/6.jpg", 15900),
      new Product(7, "eoe 이너딜리티 30포, 오렌지맛 고 식이섬유 보충제", "", "/images/7.jpg", 26800),
      new Product(8, "제나벨 PDRN 크림 2개. 피부보습/진정 케어", "", "/images/8.jpg", 25900),
      new Product(9, "플레이스테이션 VR2 호라이즌 번들. 생생한 몰입감", "", "/images/9.jpg", 797000)
    );
  }

  Product findById(int id) {
    // return mock data
    if (id == 1) {
      List<ProductOption> optionList = new ArrayList<>();
      optionList.add(new ProductOption(1, "01. 슬라이딩 지퍼백 크리스마스에디션 4종", 10000));
      optionList.add(new ProductOption(2, "02. 슬라이딩 지퍼백 플라워에디션 5종", 10900));
      optionList.add(new ProductOption(3, "고무장갑 베이지 S(소형) 6팩", 9900));
      optionList.add(new ProductOption(4, "뽑아쓰는 키친타올 130매 12팩", 16900));
      optionList.add(new ProductOption(4, "2겹 식빵수세미 6매", 8900));

      return new Product(
        1,
        "기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전",
        "",
        "/images/1.jpg",
        1000,
        optionList
      );
    } else if (id == 2) {
      List<ProductOption> optionList = new ArrayList<>();
      optionList.add(new ProductOption(6, "22년산 햇단밤 700g(한정판매)", 9900));
      optionList.add(new ProductOption(7, "22년산 햇단밤 1kg(한정판매)", 14500));
      optionList.add(new ProductOption(8, "밤깎기+다회용 구이판 세트", 5500));

      return new Product(
        2,
        "[황금약단밤 골드]2022년산 햇밤 칼집밤700g외/군밤용/생율",
        "",
        "/images/2.jpg",
        2000,
        optionList
      );
    } else {
      throw new IllegalArgumentException("해당 상품이 존재하지 않습니다.");
    }
  }
}