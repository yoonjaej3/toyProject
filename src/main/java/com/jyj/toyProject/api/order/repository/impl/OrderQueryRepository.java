package com.jyj.toyProject.api.order.repository.impl;

import com.jyj.toyProject.api.order.dto.OrderDto;
import com.jyj.toyProject.api.order.dto.QOrderDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.jyj.toyProject.api.member.entity.QMember.member;
import static com.jyj.toyProject.api.store.entity.QStore.store;
import static com.jyj.toyProject.api.order.entity.QOrders.*;

@Repository
public class OrderQueryRepository {
    private final JPAQueryFactory queryFactory;

    public OrderQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<OrderDto>findAllOrder(){

        return queryFactory.select(new QOrderDto(
                orders.member.name,
                orders.store.name,
                orders.request,
                orders.type,
                orders.payType,
                orders.payDate
                ))
                .from(orders)
                .fetch();

    }

    public List<OrderDto>findOrderByMemberId(Long memberId){
        return queryFactory.select(new QOrderDto(
                        orders.member.name,
                        orders.store.name,
                        orders.request,
                        orders.type,
                        orders.payType,
                        orders.payDate
                ))
                .from(orders)
                .join(orders.member,member)
                .where(member.seq.eq(memberId))
                .fetch();

    }

    public List<OrderDto>findOrderByStoreId(Long storeId){
        return queryFactory.select(new QOrderDto(
                orders.member.name,
                orders.store.name,
                orders.request,
                orders.type,
                orders.payType,
                orders.payDate
        ))
                .from(orders)
                .join(orders.store,store)
                .where(store.seq.eq(storeId))
                .fetch();

    }

}
