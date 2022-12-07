package com.jyj.toyProject.api.order.enums;

import com.jyj.toyProject.api.utils.document.EnumType;
import lombok.Getter;

@Getter
public enum PayType implements EnumType {
    Card("카드"),
    Cash("현금")
    ;

    private final String description;
    PayType(String description) {
        this.description = description;
    }

    @Override
    public String getName() {
        return this.name();
    }

    public String getDescription() {
        return description;
    }
}
