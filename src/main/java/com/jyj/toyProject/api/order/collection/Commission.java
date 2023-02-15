package com.jyj.toyProject.api.order.collection;

import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.enums.PayType;

public class Commission {



    private final Long price;

    public Commission(Orders order) {

        this.price = addCommission(order);

    }

    private long addCommission(Orders order) {

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
