package com.jyj.toyProject.api.festival.repository.impl;

import com.jyj.toyProject.api.festival.dto.FestivalResponseDto;
import com.jyj.toyProject.api.festival.dto.QFestivalResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.hibernate.sql.Select;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.jyj.toyProject.api.festival.entity.QFestival.festival;

@Repository
public class FestivalQueryRepository {
    private final JPAQueryFactory queryFactory;

    public FestivalQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<FestivalResponseDto> findAllFestival(){
        return queryFactory.select(new QFestivalResponseDto(

                festival.id
                ,festival.name
                ,festival.startDate
                ,festival.endDate

        ))
                .from(festival)
                .fetch();
    }

}
