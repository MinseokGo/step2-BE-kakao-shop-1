package com.example.kakao.order.domain.service;

import com.example.kakao.cart.domain.service.CartRepository;
import com.example.kakao.cart.entity.CartEntity;
import com.example.kakao.order.domain.converter.OrderConverter;
import com.example.kakao.order.domain.converter.OrderItemConverter;
import com.example.kakao.order.domain.model.OrderCashier;
import com.example.kakao.order.domain.model.OrderItem;
import com.example.kakao.order.entity.OrderEntity;
import com.example.kakao.order.entity.OrderItemEntity;
import com.example.kakao.order.web.converter.OrderResponseConverter;
import com.example.kakao.order.web.response.OrderResponse;
import com.example.kakao.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SaveOrderUseCase {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartRepository cartRepository;

    @Transactional
    public OrderResponse execute(User user) {
        List<CartEntity> cartEntities = getCartItem(user);
        List<OrderItem> orderItems = toOrderItem(cartEntities);

        OrderEntity orderEntity = saveOrderEntity(user, orderItems);
        List<OrderItemEntity> orderItemEntities = saveOrderItemEntity(orderItems, orderEntity);

        deleteCarts(cartEntities);

        return OrderResponseConverter.from(orderEntity, orderItemEntities);
    }

    private OrderEntity saveOrderEntity(User user, List<OrderItem>orderItems) {
        return orderRepository.save(OrderConverter.to(user, getTotalPrice(orderItems)));
    }

    private List<OrderItemEntity> saveOrderItemEntity(List<OrderItem>orderItems, OrderEntity orderEntity){
        List<OrderItemEntity> orderItemEntities = orderItems.stream()
                .map(x -> OrderItemConverter.to(x, orderEntity))
                .collect(Collectors.toList());

        return orderItemRepository.saveAllAndFlush(orderItemEntities);
    }

    private List<OrderItem> toOrderItem(List<CartEntity>cartEntities) {
        return cartEntities.stream()
                .map(x -> OrderItemConverter.to(x.getProductOptionEntity(), x.getQuantity()))
                .map(OrderItemConverter::from)
                .collect(Collectors.toList());
    }
    private int getTotalPrice(List<OrderItem> orderItems) {
        OrderCashier orderCashier = new OrderCashier(orderItems);
        return orderCashier.calculateTotalPrice();
    }

    private List<CartEntity> getCartItem(User user){
        return cartRepository.findByUser(user);
    }

    private void deleteCarts(List<CartEntity>entities){
        cartRepository.deleteAll(entities);
    }
}
