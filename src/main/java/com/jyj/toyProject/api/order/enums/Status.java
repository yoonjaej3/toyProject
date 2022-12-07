package com.jyj.toyProject.api.order.enums;

import com.jyj.toyProject.api.utils.document.EnumType;
import lombok.Getter;

@Getter
public enum Status implements EnumType {
    WAIT("결제 대기 중"),
    COMPLETE("결제 완료"),
    CANCEL("결제 취소")
    ;

    private final String description;
    Status(String description) {
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
