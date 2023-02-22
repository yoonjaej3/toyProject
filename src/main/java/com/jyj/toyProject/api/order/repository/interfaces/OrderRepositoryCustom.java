package com.jyj.toyProject.api.order.repository.interfaces;

import com.jyj.toyProject.api.order.dto.OrderResponeDto;
import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.enums.Status;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepositoryCustom {

    List<OrderResponeDto>findOrder(String memberName, String storeName);

    Orders findOrderByOrderId(String orderId);

    List<OrderResponeDto> findOrderByPaging(Pageable pageable, String memberName, String storeName);

}
