package com.jyj.toyProject.modules.member.repository.impl;


import com.jyj.toyProject.modules.member.dto.MemberDto;
import com.jyj.toyProject.modules.member.dto.QMemberDto;
import com.jyj.toyProject.modules.member.enums.Type;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.jyj.toyProject.modules.member.entity.QMember.member;

@Repository
public class MemberQueryRepository  {
    private final JPAQueryFactory queryFactory;

    public MemberQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<MemberDto>findMemberByType(Type type){
        return queryFactory.select(new QMemberDto(
                member.name,
                member.phone,
                member.email,
                member.type
                ))
                .from(member)
                .fetch();
    }
}
