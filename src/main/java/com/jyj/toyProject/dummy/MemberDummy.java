package com.jyj.toyProject.dummy;


import com.jyj.toyProject.modules.member.entity.Member;
import com.jyj.toyProject.modules.member.enums.Type;
import com.jyj.toyProject.modules.member.repository.interfaces.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.jyj.toyProject.modules.member.enums.Type.Seller;

@Component
@RequiredArgsConstructor
@Profile("dev")
public class MemberDummy {

    private final MemberRepository memberRepository;

    public Member createMember(int index,Type type){
        Member member=Member.builder()
                .name("test"+index)
                .phone("0100000000"+index)
                .email("test"+index+"@test.com")
                .type(type)
                .build();
        Member savedMember = memberRepository.save(member);
        return savedMember;
    }
}
