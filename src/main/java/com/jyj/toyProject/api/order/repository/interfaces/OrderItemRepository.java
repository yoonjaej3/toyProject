package com.jyj.toyProject.api.order.repository.interfaces;

import com.jyj.toyProject.api.order.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
