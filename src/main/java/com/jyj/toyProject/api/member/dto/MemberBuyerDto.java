package com.jyj.toyProject.api.member.dto;

import com.jyj.toyProject.api.member.enums.Type;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberBuyerDto {
    private String name;
    private String phone;
    private String email;
    private Type type;


    @QueryProjection
    public MemberBuyerDto(String name, String phone, String email, Type type){
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.type=type;
    }
}
