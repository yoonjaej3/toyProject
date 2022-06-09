package com.jyj.toyProject.modules.member.dto;

import com.jyj.toyProject.modules.member.enums.Type;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSellerDto {
    private String name;
    private String phone;
    private String email;
    private String companyNumber;
    private Type type;


    @QueryProjection
    public MemberSellerDto(String name, String phone, String email, String companyNumber, Type type){
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.companyNumber=companyNumber;
        this.type=type;
    }
}
