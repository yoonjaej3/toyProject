package com.jyj.toyProject.api.member.controller;

import com.jyj.toyProject.api.member.dto.MemberDto;
import com.jyj.toyProject.api.member.entity.Member;
import com.jyj.toyProject.api.member.enums.Type;
import com.jyj.toyProject.api.member.repository.interfaces.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class MemberApiControllerTest {

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    void clean(){

        memberRepository.deleteAll();

    }

    @Test
    @DisplayName("/member/register 요청시 회원 등록")
    void 회원등록() throws Exception{

        //given
        MemberDto memberDto = MemberDto.builder()
                .id("MMMMMM1")
                .email("member1@naver.com")
                .name("주윤재")
                .phone("01090626317")
                .type(Type.Buyer)
                .build();


    }

}