package com.jyj.toyProject.modules.festival.repository.impl;


import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class FestivalQueryRepository {
    private final JPAQueryFactory queryFactory;

    public FestivalQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
}
