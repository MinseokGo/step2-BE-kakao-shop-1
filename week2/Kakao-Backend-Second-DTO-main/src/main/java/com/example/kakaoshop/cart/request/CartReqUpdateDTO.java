package com.example.kakaoshop.cart.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CartReqUpdateDTO {
    private int cartId;
    private int quantity;

    @Builder
    public CartReqUpdateDTO(int cartId, int quantity) {
        this.cartId = cartId;
        this.quantity = quantity;
    }
}