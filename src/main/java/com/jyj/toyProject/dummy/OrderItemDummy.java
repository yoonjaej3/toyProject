package com.jyj.toyProject.dummy;

import com.jyj.toyProject.modules.item.entity.Item;
import com.jyj.toyProject.modules.order.entity.OrderItem;
import com.jyj.toyProject.modules.order.entity.Orders;

import com.jyj.toyProject.modules.order.repository.interfaces.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("dev")
public class OrderItemDummy {
    private final OrderItemRepository orderItemRepository;

    public OrderItem createOrderItem(Orders order, Item item){
        OrderItem orderItem=OrderItem.builder()
                .order(order)
                .item(item)
                .build();

        OrderItem savedOrderItem=orderItemRepository.save(orderItem);
        return savedOrderItem;
    }
}
