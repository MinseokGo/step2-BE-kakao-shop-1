package com.example.kakaoshop.cart;

import com.example.kakaoshop._core.utils.ApiUtils;
import com.example.kakaoshop.cart.request.CartRequest;
import com.example.kakaoshop.cart.response.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                                .id(2)
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

        RespFindAllDTO responseDTO = new RespFindAllDTO(productDTOList, 104500);

        return ResponseEntity.ok(ApiUtils.success(responseDTO));
    }

    @PostMapping("/carts")
    public ResponseEntity<?> addProduct(@RequestBody List<CartRequest.AddDTO> addDTO){
        return ResponseEntity.ok(ApiUtils.success(null));
    }

    @PatchMapping("/carts")
    public ResponseEntity<?> updateCarts(@RequestBody List<CartRequest.UpdateDTO> updateDTO){
        List<CartUpdateDTO> cartUpdateDTOList = new ArrayList<>();

        CartUpdateDTO cartUpdateDTO1 = CartUpdateDTO.builder()
                .cartId(updateDTO.get(0).getCartId())
                .optionId(1)
                .optionName("01. 슬라이딩 지퍼백 크리스마스에디션 4종")
                .quantity(updateDTO.get(0).getQuantity())
                .price(10000)
                .build();

        cartUpdateDTOList.add(cartUpdateDTO1);

        CartUpdateDTO cartUpdateDTO2 = CartUpdateDTO.builder()
                .cartId(updateDTO.get(1).getCartId())
                .optionId(2)
                .optionName("02. 슬라이딩 지퍼백 플라워에디션 5종")
                .quantity(updateDTO.get(1).getQuantity())
                .price(109000)
                .build();

        cartUpdateDTOList.add(cartUpdateDTO2);

        RespUpdateCartsDTO responseDTO = new RespUpdateCartsDTO(cartUpdateDTOList, 104500);

        return ResponseEntity.ok(ApiUtils.success(responseDTO));
    }
}