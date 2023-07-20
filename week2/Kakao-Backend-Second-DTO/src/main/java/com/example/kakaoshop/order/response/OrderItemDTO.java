package com.example.kakaoshop.order.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderItemDTO {
    private Long id;
    private String optionName;
    private int quantity;
    private int price;

    @Builder
    public OrderItemDTO(Long id, String optionName, int quantity, int price) {
        this.id = id;
        this.optionName = optionName;
        this.quantity = quantity;
        this.price = price;
    }
}