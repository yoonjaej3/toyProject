package com.jyj.toyProject.modules.member.dto;

import com.jyj.toyProject.modules.member.enums.Type;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberDto {
    private String name;
    private String phone;
    private String email;
    private Type type;


    @QueryProjection
    public MemberDto(String name, String phone,String email,Type type){
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.type=type;
    }
}
