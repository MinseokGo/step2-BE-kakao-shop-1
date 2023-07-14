package com.example.kakaoshop.cart;

import com.example.kakaoshop._core.utils.ApiUtils;
import com.example.kakaoshop.cart.request.CartRequestDTO;
import com.example.kakaoshop.cart.request.CartUpdateRequestDTO;
import com.example.kakaoshop.cart.response.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CartRestController {

    @GetMapping("/carts")
    public ResponseEntity<?> findAll() {
        // 카트 아이템 리스트 만들기
        List<CartItemDTO> cartItemDTOList = new ArrayList<>();

        // 카트 아이템 리스트에 담기
        CartItemDTO cartItemDTO1 = CartItemDTO.builder()
                .id(4)
                .quantity(5)
                .price(50000)
                .build();
        cartItemDTO1.setOption(ProductOptionDTO.builder()
                                .id(1)
                                .optionName("01. 슬라이딩 지퍼백 크리스마스에디션 4종")
                                .price(10000)
                                .build());
        cartItemDTOList.add(cartItemDTO1);

        CartItemDTO cartItemDTO2 = CartItemDTO.builder()
                .id(5)
                .quantity(5)
                .price(54500)
                .build();
        cartItemDTO2.setOption(ProductOptionDTO.builder()
                                .id(1)
                                .optionName("02. 슬라이딩 지퍼백 크리스마스에디션 5종")
                                .price(10900)
                                .build());
        cartItemDTOList.add(cartItemDTO2);

        // productDTO 리스트 만들기
        List<ProductDTO> productDTOList = new ArrayList<>();

        // productDTO 리스트에 담기
        productDTOList.add(
                ProductDTO.builder()
                        .id(1)
                        .productName("기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전")
                        .cartItems(cartItemDTOList)
                        .build()
        );

        CartResponseFindAllDTO responseDTO = new CartResponseFindAllDTO(productDTOList, 104500);

        return ResponseEntity.ok(ApiUtils.success(responseDTO));
    }

    @PostMapping("/carts")
    public ResponseEntity<?> addCart(@RequestBody List<CartRequestDTO> cartRequestDTOList){

        return ResponseEntity.ok(ApiUtils.success(null));
    }

    @PostMapping("/carts/update")
    public ResponseEntity<?> updateCart(@RequestBody List<CartUpdateRequestDTO> cartUpdateRequestDTOList){
        List<CartUpdateItemDTO> cartUpdateItemDTOList = new ArrayList<>();
        CartUpdateItemDTO cartUpdateItemDTO1 = CartUpdateItemDTO.builder()
                .cartId(1)
                .optionId(2)
                .optionName("22년산 햇단밤 700g(한정판매)")
                .price(5000)
                .quantity(2)
                .build();
        cartUpdateItemDTOList.add(cartUpdateItemDTO1);

        CartUpdateItemDTO cartUpdateItemDTO2 = CartUpdateItemDTO.builder()
                .cartId(3)
                .optionId(1)
                .optionName("달달한 꿀사과")
                .price(2345)
                .quantity(1)
                .build();
        cartUpdateItemDTOList.add(cartUpdateItemDTO2);

        CartUpdateResponseDTO responseDTO = new CartUpdateResponseDTO(cartUpdateItemDTOList, 12345);
        return ResponseEntity.ok().body(responseDTO);
    }
}