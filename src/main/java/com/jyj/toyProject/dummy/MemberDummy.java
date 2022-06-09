package com.jyj.toyProject.dummy;


import com.jyj.toyProject.modules.member.entity.Member;
import com.jyj.toyProject.modules.member.enums.Type;
import com.jyj.toyProject.modules.member.repository.interfaces.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("dev")
public class MemberDummy {

    private final MemberRepository memberRepository;

    public static Member createMember(int index, Type type, String organizerName, String companyNumber){
        return Member.builder()
                .name("test"+index)
                .phone("0100000000"+index)
                .email("test"+index+"@test.com")
                .organizerName(organizerName)
                .companyNumber(companyNumber)
                .type(type)
                .build();

    }
}
