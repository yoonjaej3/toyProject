package com.jyj.toyProject.api.member.dto;

import com.jyj.toyProject.api.member.entity.Member;
import com.jyj.toyProject.api.member.enums.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberDto {

    private Long seq;
    private String id;
    private String name;
    private String phone;
    private String email;
    private String companyNumber;
    private String organizerName;
    private Type type;

    public MemberDto(Member member){
        this.id= member.getId();
        this.name=member.getName();
        this.phone=member.getPhone();
        this.email=member.getEmail();
        this.companyNumber=member.getCompanyNumber();
        this.organizerName=member.getOrganizerName();
        this.type=member.getType();
    }

    public Member toEntity(){

        return Member.builder()
                .name(name)
                .phone(phone)
                .email(email)
                .type(type)
                .build();

    }

}
