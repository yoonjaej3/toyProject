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
                .phone("01000000001")
                .email("test1@test.com")
                .organizerName(null)
                .companyNumber(null)
                .type(Type.Buyer)
                .build();

        //when
        Member member= MemberDummy.createMember(1,Type.Buyer,null,null);
        memberRepository.save(member);

        MemberBuyerDto myMember1=memberQueryRepository.findMemberBuyer(Type.Buyer).get(0);

        //then
        assertEquals(member1.getName(),myMember1.getName());
        assertEquals(member1.getPhone(),myMember1.getPhone());
    
    }
}