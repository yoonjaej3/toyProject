package com.jyj.toyProject.modules.member.dto;

import com.jyj.toyProject.modules.member.entity.Member;
import com.jyj.toyProject.modules.member.enums.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
public class MemberDto {

    private Long id;
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

}
