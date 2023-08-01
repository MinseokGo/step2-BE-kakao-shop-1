package com.example.kakaoshop.order;


import com.example.kakaoshop._core.utils.ApiUtils;
import com.example.kakaoshop.order.response.OrderRespFindAllDTO;
import com.example.kakaoshop.order.response.ProductDTO;
import com.example.kakaoshop.order.response.OrderItemDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderRestController {

    @PostMapping("/orders/save")
    public ResponseEntity<?> findAll(){
        // 첫 번째
        // 오더 아이템 리스트 만들기
        List<OrderItemDTO> orderItemDTOList = new ArrayList<>();

        // 오더 아이템 리스트에 담기
        OrderItemDTO orderItemDTO1 = OrderItemDTO.builder()
                .id(4)
                .optionName("01. 슬라이딩 지퍼백 크리스마스에디션 4종")
                .quantity(10)
                .price(100000)
                .build();
        orderItemDTOList.add(orderItemDTO1);

        OrderItemDTO orderItemDTO2 = OrderItemDTO.builder()
                .id(5)
                .optionName("02. 슬라이딩 지퍼백 플라워에디션 5종")
                .quantity(10)
                .price(109000)
                .build();
        orderItemDTOList.add(orderItemDTO2);

        // 두 번째
        // productDTO 리스트 만들기
        List<ProductDTO> productDTOList = new ArrayList<>();

        // productDTO 리스트 담기
        ProductDTO productDTO1 = ProductDTO.builder()
                .productName("기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전")
                .orderItems(orderItemDTOList)
                .build();
        productDTOList.add(productDTO1);

        // 세 번째
        // responseDTO 만들기
        OrderRespFindAllDTO responseDTO = new OrderRespFindAllDTO(2, productDTOList, 209000);

        return ResponseEntity.ok(ApiUtils.success(responseDTO));
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){

        OrderRespFindAllDTO responseDTO;

        if(id == 2) {
            // 첫 번째
            // 오더 아이템 리스트 만들기
            List<OrderItemDTO> orderItemDTOList = new ArrayList<>();

            // 오더 아이템 리스트에 담기
            OrderItemDTO orderItemDTO1 = OrderItemDTO.builder()
                    .id(4)
                    .optionName("01. 슬라이딩 지퍼백 크리스마스에디션 4종")
                    .quantity(10)
                    .price(100000)
                    .build();
            orderItemDTOList.add(orderItemDTO1);

            OrderItemDTO orderItemDTO2 = OrderItemDTO.builder()
                    .id(5)
                    .optionName("02. 슬라이딩 지퍼백 플라워에디션 5종")
                    .quantity(10)
                    .price(109000)
                    .build();
            orderItemDTOList.add(orderItemDTO2);

            // 두 번째
            // productDTO 리스트 만들기
            List<ProductDTO> productDTOList = new ArrayList<>();

            // productDTO 리스트 담기
            ProductDTO productDTO1 = ProductDTO.builder()
                    .productName("기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전")
                    .orderItems(orderItemDTOList)
                    .build();
            productDTOList.add(productDTO1);

            // 세 번째
            // responseDTO 만들기
            responseDTO = new OrderRespFindAllDTO(2, productDTOList, 209000);
        }else {
            return ResponseEntity.badRequest().body(ApiUtils.error("해당 주문을 찾을 수 없습니다 : " + id, HttpStatus.BAD_REQUEST));
        }

        return ResponseEntity.ok(ApiUtils.success(responseDTO));
    }
}