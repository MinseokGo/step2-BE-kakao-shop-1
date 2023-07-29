package com.example.kakao.cart.web.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CartReqeust {

    @NotNull
    private Long optionId;
    @NotNull
    private Integer quantity;

}
