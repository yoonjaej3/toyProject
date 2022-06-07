package com.jyj.toyProject.modules.order.repository.interfaces;

import com.jyj.toyProject.modules.order.entity.OrderItem;
import com.jyj.toyProject.modules.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
