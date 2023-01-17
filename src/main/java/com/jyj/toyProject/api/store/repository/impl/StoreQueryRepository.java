package com.jyj.toyProject.api.store.repository.impl;
import com.jyj.toyProject.api.store.dto.QStoreResponseDto;
import com.jyj.toyProject.api.store.dto.StoreResponseDto;
import com.jyj.toyProject.api.store.entity.QStore;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StoreQueryRepository {
    private final JPAQueryFactory queryFactory;

    public StoreQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<StoreResponseDto> findAllStore(){
        return queryFactory.select(new QStoreResponseDto(

                QStore.store.id,
                QStore.store.festival,
                QStore.store.name,
                QStore.store.phone

        ))
                .from(QStore.store)
                .fetch();
    }
}
