package com.jyj.toyProject.modules.member.dto;

import com.jyj.toyProject.modules.member.enums.Type;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberOrganizerDto {
    private String name;
    private String phone;
    private String email;
    private String organizerName;
    private Type type;


    @QueryProjection
    public MemberOrganizerDto(String name, String phone, String email, String organizerName, Type type){
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.organizerName=organizerName;
        this.type=type;
    }
}
