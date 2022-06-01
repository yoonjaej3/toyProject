package com.jyj.toyProject.modules.member.enums;

import com.jyj.toyProject.modules.utils.document.EnumType;
import lombok.Getter;

@Getter
public enum Type implements EnumType {
    Seller("판매자"),
    Buyer("구매자"),
    Admin("관리자");

    private final String description;

    Type(String description) {
        this.description=description;
    }

    @Override
    public String getName() {
        return this.description;
    }

    @Override
    public String getDescription(){
        return this.description;
    }

}
