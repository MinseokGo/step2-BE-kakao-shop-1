package com.example.kakaoshop.order.response;

import com.example.kakaoshop.order.response.ProductOptionDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.websocket.server.ServerEndpoint;

@Getter@Setter
public class OrderItemDTO {
    private int id;
    private ProductOptionDTO option;
    private int quantity;
    private int price;

    @Builder
    public OrderItemDTO(int id, ProductOptionDTO option, int quantity, int price) {
        this.id = id;
        this.option = option;
        this.quantity = quantity;
        this.price = price;
    }

}