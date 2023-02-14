package com.jyj.toyProject.api.item.repository.impl;


import com.jyj.toyProject.api.item.dto.ItemResponseDto;
import com.jyj.toyProject.api.item.dto.QItemResponseDto;


import static com.jyj.toyProject.api.item.entity.QItem.*;

import com.jyj.toyProject.api.item.entity.Item;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class ItemQueryRepository {
    private final JPAQueryFactory queryFactory;

    public ItemQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<ItemResponseDto> findStore(String storeName){

        return queryFactory.select(new QItemResponseDto(
                item.id,
                item.name,
                item.price,
                item.store.name
        ))
                .from(item)
                .where(eqStore(storeName))
                .fetch();

    }

    private BooleanExpression eqStore(String name) {

        if (StringUtils.hasText(name))
            return item.store.name.eq(name);

        return null;
    }

    public Item findItemByItdmId(String itemId){

        return queryFactory.select(item)
                .from(item)
                .where(item.id.eq(itemId))
                .fetch().get(0);

    }

}
