package com.jyj.toyProject.api.order.repository.impl;


import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class OrderItemQueryRepository {
    private final JPAQueryFactory queryFactory;

    public OrderItemQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
}
