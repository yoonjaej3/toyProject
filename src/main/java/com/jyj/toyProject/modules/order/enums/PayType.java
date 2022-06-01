package com.jyj.toyProject.modules.order.enums;

import com.jyj.toyProject.modules.utils.document.EnumType;
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
