package com.jyj.toyProject.api.order.repository.impl;

import com.jyj.toyProject.api.order.dto.OrderResponeDto;
import com.jyj.toyProject.api.order.dto.QOrderResponeDto;
import com.jyj.toyProject.api.order.entity.Orders;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import static com.jyj.toyProject.api.member.entity.QMember.member;
import static com.jyj.toyProject.api.store.entity.QStore.store;
import static com.jyj.toyProject.api.order.entity.QOrders.*;

@Repository
public class OrderQueryRepository {
    private final JPAQueryFactory queryFactory;

    public OrderQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<OrderResponeDto>findOrder(String memberName,String storeName){

        return queryFactory.select(new QOrderResponeDto(
                orders.id,
                orders.member.id,
                orders.store.id,
                orders.request,
                orders.type,
                orders.payType,
                orders.payDate
                ))
                .from(orders)
//                .where(eqMember(memberName),
//                        eqStore(storeName))
                .fetch();

    }

    private BooleanExpression eqMember(String name) {

        if (StringUtils.hasText(name))
            return member.name.eq(name);

        return null;
    }

    private BooleanExpression eqStore(String name) {

        if (StringUtils.hasText(name))
            return store.name.eq(name);

        return null;
    }

    public Orders findOrderByOrderId(String orderId){
        return queryFactory.select(orders)
                .from(orders)
                .where(orders.id.eq(orderId))
                .fetch().get(0);

    }
}
