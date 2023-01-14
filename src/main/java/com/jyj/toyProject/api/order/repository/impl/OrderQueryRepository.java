package com.jyj.toyProject.api.order.repository.impl;

import com.jyj.toyProject.api.order.dto.OrderResponeDto;
import com.jyj.toyProject.api.order.dto.QOrderResponeDto;
import com.jyj.toyProject.api.order.entity.Orders;
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

    public List<OrderResponeDto>findAllOrder(){

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
                .fetch();

    }

    public List<OrderResponeDto>findOrderByMemberId(Long memberId){
        return queryFactory.select(new QOrderResponeDto(
                        orders.id,
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

    public List<OrderResponeDto>findOrderByStoreId(Long storeId){
        return queryFactory.select(new QOrderResponeDto(
                orders.id,
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

    public Orders findOrderByOrderId(String orderId){
        return queryFactory.select(orders)
                .from(orders)
                .where(orders.id.eq(orderId))
                .fetch().get(0);

    }
}
