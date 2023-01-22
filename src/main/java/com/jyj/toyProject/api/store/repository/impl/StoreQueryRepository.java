package com.jyj.toyProject.api.store.repository.impl;

import com.jyj.toyProject.api.store.dto.QStoreResponseDto;
import com.jyj.toyProject.api.store.dto.StoreResponseDto;
import com.jyj.toyProject.api.store.entity.Store;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;
import static com.jyj.toyProject.api.store.entity.QStore.*;

@Repository
public class StoreQueryRepository {
    private final JPAQueryFactory queryFactory;

    public StoreQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<StoreResponseDto>findStore(String festivalName){

        return queryFactory.select(new QStoreResponseDto(
                store.id,
                store.festival.id,
                store.name,
                store.phone,
                store.festival.name

        ))
                .from(store)
                .where(eqFestival(festivalName))
                .fetch();

    }

    private BooleanExpression eqFestival(String name) {

        if (StringUtils.hasText(name))
            return store.festival.name.eq(name);

        return null;
    }

    public Store findStoreByStoreId(String storeId){
        return queryFactory.select(store)
                .from(store)
                .where(store.id.eq(storeId))
                .fetch().get(0);

    }
}
