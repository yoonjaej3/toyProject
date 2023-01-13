package com.jyj.toyProject.api.member.repository.impl;
import com.jyj.toyProject.api.member.dto.*;
import com.jyj.toyProject.api.member.entity.Member;
import com.jyj.toyProject.api.member.enums.Type;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.jyj.toyProject.api.member.entity.QMember.member;

@Repository
public class MemberQueryRepository  {
    private final JPAQueryFactory queryFactory;

    public MemberQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<MemberSellerDto>findMemberSeller(Type type){
        return queryFactory.select(new QMemberSellerDto(
                member.name,
                member.phone,
                member.email,
                member.companyNumber,
                member.type
                ))
                .from(member)
                .fetch();
    }

    public List<MemberBuyerDto>findMemberBuyer(Type type){
        return queryFactory.select(new QMemberBuyerDto(
                        member.name,
                        member.phone,
                        member.email,
                        member.type
                ))
                .from(member)
                .fetch();
    }

    public List<MemberOrganizerDto>findMemberOrganizer(Type type){
        return queryFactory.select(new QMemberOrganizerDto(
                        member.name,
                        member.phone,
                        member.email,
                        member.organizerName,
                        member.type
                ))
                .from(member)
                .fetch();
    }

    public List<Member> findSeqById(String id){
        return queryFactory.select(member)
                .from(member)
                .where(member.id.eq(id))
                .fetch();
    }

}
