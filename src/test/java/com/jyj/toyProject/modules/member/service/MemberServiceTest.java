package com.jyj.toyProject.modules.member.service;

import com.jyj.toyProject.dummy.DummyTest;
import com.jyj.toyProject.modules.member.entity.Member;
import com.jyj.toyProject.modules.member.enums.Type;
import com.jyj.toyProject.modules.member.repository.interfaces.MemberRepository;
import com.jyj.toyProject.modules.order.repository.interfaces.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("사용자 등록")
    public  void 사용자등록() throws Exception{

        //given
        Member member1 = Member.builder()
                .name("test1")
                .phone("01000000001")
                .email("test1@test.com")
                .organizerName(null)
                .companyNumber(null)
                .type(Type.Buyer)
                .build();

        //when
        Long memberId = memberService.registerMember(member1);

        //then
        Member member2 = memberRepository.findById(memberId).get();

        assertEquals(member1,member2);

    }
}