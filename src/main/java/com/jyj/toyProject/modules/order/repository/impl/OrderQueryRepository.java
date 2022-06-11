package com.jyj.toyProject.modules.order.repository.impl;


import com.jyj.toyProject.modules.member.entity.Member;
import com.jyj.toyProject.modules.order.dto.OrderBuyerDto;
import com.jyj.toyProject.modules.order.dto.QOrderBuyerDto;
import com.jyj.toyProject.modules.order.entity.QOrders;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OrderQueryRepository {
    private final JPAQueryFactory queryFactory;

    public OrderQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<OrderBuyerDto>findBuyerByMember(Member member){
        return queryFactory.select(new QOrderBuyerDto(
                QOrders.orders.member,
                QOrders.orders.request,
                QOrders.orders.type,
                QOrders.orders.payType,
                QOrders.orders.payDate
        ))
                .from(QOrders.orders)
                .where(QOrders.orders.member.eq(member))
                .fetch();

    }
}
