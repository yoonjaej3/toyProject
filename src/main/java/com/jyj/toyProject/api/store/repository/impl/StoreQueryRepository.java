package com.jyj.toyProject.api.store.repository.impl;


import com.jyj.toyProject.api.member.entity.Member;
import com.jyj.toyProject.api.store.entity.QStore;

import com.jyj.toyProject.api.store.entity.Store;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.jyj.toyProject.api.member.entity.QMember.member;

@Repository
public class StoreQueryRepository {
    private final JPAQueryFactory queryFactory;

    public StoreQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<Store> findSeqById(String id){
        return queryFactory.select(QStore.store)
                .from(QStore.store)
                .where(QStore.store.id.eq(id))
                .fetch();
    }
}
