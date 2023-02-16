package com.jyj.toyProject.api.order.collection;

import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.enums.PayType;
import lombok.Getter;

@Getter
public class Amount {

    private final Orders order;

    public Amount(Orders order) {

        long checkAmount = checkAmount(order);

        this.order= Orders.builder()
                .id(order.getId())
                .member(order.getMember())
                .item(order.getItem())
                .request(order.getRequest())
                .type(order.getType())
                .payDate(order.getPayDate())
                .payType(order.getPayType())
                .amount(checkAmount)
                .build();

    }

    private long checkAmount(Orders order) {

        /*
         * 현금일 경우
         * 가격 동일
         * 카드일 경우
         * 10% 가격 추가
         */

        if(order.getPayType().equals(PayType.Card)){

            return order.getItem().getPrice() * 9 / 10 ;

        }

        return order.getItem().getPrice();

    }

}
