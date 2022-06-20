package com.jyj.toyProject.modules.order.repository.interfaces;

import com.jyj.toyProject.modules.order.entity.Orders;
import com.jyj.toyProject.modules.order.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository  extends JpaRepository<Orders,Long> {
    List<Orders> findByType(Status complete);
}
