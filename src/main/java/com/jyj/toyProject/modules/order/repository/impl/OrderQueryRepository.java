package com.jyj.toyProject.modules.order.repository.impl;


import com.jyj.toyProject.modules.order.dto.OrderBuyerDto;
import com.jyj.toyProject.modules.order.dto.QOrderBuyerDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.jyj.toyProject.modules.order.entity.QOrders.*;
import static com.jyj.toyProject.modules.store.entity.QStore.*;

@Repository
public class OrderQueryRepository {
    private final JPAQueryFactory queryFactory;

    public OrderQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<OrderBuyerDto>findBuyerByStoreId(Long storeId){
        return queryFactory.select(new QOrderBuyerDto(
                orders.member,
                orders.store,
                orders.request,
                orders.type,
                orders.payType,
                orders.payDate
        ))
                .from(orders)
                .join(orders.store,store)
                .where(store.id.eq(storeId))
                .fetch();

    }
}
