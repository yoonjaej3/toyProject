package com.jyj.toyProject.modules.member.repository.impl;

import com.jyj.toyProject.dummy.MemberDummy;
import com.jyj.toyProject.modules.member.dto.MemberBuyerDto;
import com.jyj.toyProject.modules.member.entity.Member;
import com.jyj.toyProject.modules.member.enums.Type;
import com.jyj.toyProject.modules.member.repository.interfaces.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberQueryRepositoryTest {

    @Autowired
    MemberQueryRepository memberQueryRepository;

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("구매자조회")
    public void  find_buyer_members() throws Exception{
        //given
        Member member1= Member.builder()
                .name("test1")
                .phone("0100000001")
                .email("test1@test.com")
                .organizerName(null)
                .companyNumber(null)
                .type(Type.Buyer)
                .build();

        //when
        Member member= MemberDummy.createMember(1,Type.Buyer,"1111","1111");
        System.out.println(member);
        System.out.println(member.getId());
        System.out.println(member.getName());
        memberRepository.save(member);

        System.out.println(memberRepository);

        MemberBuyerDto myMember1=memberQueryRepository.findMemberBuyer(Type.Buyer).get(0);

        //then
        System.out.println(member1.getName());
        System.out.println(myMember1.getName());
        assertEquals(member1.getName(),myMember1.getName());
    
    }
}