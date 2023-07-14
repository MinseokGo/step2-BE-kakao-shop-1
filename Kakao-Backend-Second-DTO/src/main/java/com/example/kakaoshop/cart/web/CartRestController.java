package com.example.kakaoshop.cart.web;

import com.example.kakaoshop._core.security.CustomUserDetails;
import com.example.kakaoshop._core.utils.ApiUtils;
import com.example.kakaoshop.cart.domain.service.CartService;
import com.example.kakaoshop.cart.web.request.CartSaveRequest;
import com.example.kakaoshop.cart.web.request.CartUpdateRequest;
import com.example.kakaoshop.cart.web.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
public class CartRestController {
    private final CartService cartService;

    @GetMapping("")
    public ResponseEntity<ApiUtils.ApiResult<CartFindAllResponse>> findAll(@AuthenticationPrincipal CustomUserDetails user) {
        return ResponseEntity.ok(ApiUtils.success(cartService.getCartsByUser(user.getUser())));
    }

    @PostMapping("")
    public ResponseEntity<ApiUtils.ApiResult> saveCarts(@AuthenticationPrincipal CustomUserDetails user, @Valid @RequestBody CartSaveRequest cartSaveRequest) {
        cartService.addCarts(user.getUser(), cartSaveRequest);
        return ResponseEntity.ok(ApiUtils.successWithoutData());
    }

    @PutMapping("")
    public ResponseEntity<ApiUtils.ApiResult<CartUpdateResponse>> updateCarts(@AuthenticationPrincipal CustomUserDetails user, @Valid @RequestBody CartUpdateRequest cartUpdateRequest) {

        List<CartChangedOptionResponse> changedOptions = new ArrayList<>();

        CartChangedOptionResponse singleChangedOption = CartChangedOptionResponse.builder()
                .cartId(4L)
                .optionId(1L)
                .optionName("01. 슬라이딩 지퍼백 크리스마스에디션 4종")
                .quantity(10)
                .price(100000)
                .build();

        CartChangedOptionResponse singleChangedOption2 = CartChangedOptionResponse.builder()
                .cartId(5L)
                .optionId(2L)
                .optionName("02. 슬라이딩 지퍼백 플라워에디션 5종")
                .quantity(10)
                .price(109000)
                .build();

        changedOptions.add(singleChangedOption);
        changedOptions.add(singleChangedOption2);

        int totalPrice = singleChangedOption.getPrice() + singleChangedOption2.getPrice();


        CartUpdateResponse cartUpdateResponse = CartUpdateResponse.builder()
                .cartChangedOptionResponses(changedOptions)
                .totalPrice(totalPrice)
                .build();

        return new ResponseEntity<>(ApiUtils.success(cartUpdateResponse), HttpStatus.OK);

    }
}