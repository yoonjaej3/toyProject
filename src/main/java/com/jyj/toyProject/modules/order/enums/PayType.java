package com.jyj.toyProject.modules.order.enums;

import com.jyj.toyProject.modules.utils.document.EnumType;
import lombok.Getter;

@Getter
public enum PayType implements EnumType {
    Card("์นด๋"),
    Cash("ํ๊ธ")
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
