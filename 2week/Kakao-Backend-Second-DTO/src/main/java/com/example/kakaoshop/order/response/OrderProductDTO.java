package com.example.kakaoshop.order.response;

import com.example.kakaoshop.order.item.response.OrderItemDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class OrderProductDTO {

    private String productName;
    private List<OrderItemDTO> items;

    @Builder
    public OrderProductDTO(String productName, List<OrderItemDTO> items) {
        this.productName = productName;
        this.items = items;
    }
}
