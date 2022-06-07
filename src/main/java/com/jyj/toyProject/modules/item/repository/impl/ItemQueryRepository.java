package com.jyj.toyProject.modules.item.repository.impl;


import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ItemQueryRepository {
    private final JPAQueryFactory queryFactory;

    public ItemQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
}
