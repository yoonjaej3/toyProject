package com.jyj.toyProject.api.store.repository.impl;


import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class StoreQueryRepository {
    private final JPAQueryFactory queryFactory;

    public StoreQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
}
