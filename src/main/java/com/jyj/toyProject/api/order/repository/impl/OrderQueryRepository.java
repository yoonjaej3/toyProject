package com.jyj.toyProject.api.order.repository.impl;

import com.jyj.toyProject.api.order.dto.OrderResponeDto;
import com.jyj.toyProject.api.order.dto.QOrderResponeDto;
import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.repository.interfaces.OrderRepositoryCustom;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;
import static com.jyj.toyProject.api.order.entity.QOrders.*;

@Repository
public class OrderQueryRepository implements OrderRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public OrderQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<OrderResponeDto>findOrder(String memberName,String storeName){

        return queryFactory.select(new QOrderResponeDto(
                orders.id,
                orders.member.id,
                orders.item.id,
                orders.request,
                orders.type,
                orders.payType,
                orders.payDate,
                orders.member.name,
                orders.item.name

                ))
                .from(orders)
                .where(eqMember(memberName),
                        eqStore(storeName))
                .fetch();

    }

    private BooleanExpression eqMember(String name) {

        if (StringUtils.hasText(name))
            return orders.member.name.eq(name);

        return null;
    }

    private BooleanExpression eqStore(String name) {

        if (StringUtils.hasText(name))
            return orders.item.name.eq(name);

        return null;
    }

    public Orders findOrderByOrderId(String orderId){
        return queryFactory.select(orders)
                .from(orders)
                .where(orders.id.eq(orderId))
                .fetch().get(0);

    }

    public List<OrderResponeDto> findOrderByPaging(Pageable pageable, String memberName, String storeName) {

        return queryFactory.select(new QOrderResponeDto(
                        orders.id,
                        orders.member.id,
                        orders.item.id,
                        orders.request,
                        orders.type,
                        orders.payType,
                        orders.payDate,
                        orders.member.name,
                        orders.item.name

                ))
                .from(orders)
                .where(eqMember(memberName),
                        eqStore(storeName))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

    }
}
