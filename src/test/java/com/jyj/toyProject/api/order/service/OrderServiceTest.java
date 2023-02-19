package com.jyj.toyProject.api.order.service;

import com.jyj.toyProject.api.order.dto.OrderRequestDto;
import com.jyj.toyProject.api.order.dto.OrderRequestSearchDto;
import com.jyj.toyProject.api.order.dto.OrderResponeDto;
import com.jyj.toyProject.api.order.repository.impl.OrderQueryRepository;
import com.jyj.toyProject.api.order.entity.Orders;
import com.jyj.toyProject.api.order.enums.PayType;
import com.jyj.toyProject.api.order.enums.Status;
import com.jyj.toyProject.api.order.repository.interfaces.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderQueryRepository orderQueryRepository;


    @BeforeEach
    void clean() {
        orderRepository.deleteAll();
    }

    @Test
    @DisplayName("주문등록")
    public void  주문_등록() throws Exception{

        //given
        OrderRequestDto orderRequestDto = OrderRequestDto.builder()
                .orderId("OOOOOO1")
                .request("요청사항10000")
                .payType(PayType.Card)
                .memberId("MMMMMM1")
                .itemId("IIIIII1")
                .type(Status.COMPLETE)
                .build();

        //when
        orderService.registerOrder(orderRequestDto);

        //then
        assertEquals(1L,orderRepository.count());
        Orders order = orderRepository.findAll().get(0);
        assertEquals("OOOOOO1",order.getId());
        assertEquals("COMPLETE",order.getType().toString());
    }

    @Test
    @DisplayName("주문등록(가게명X 예외처리)")
    public void  주문_등록_가게명X_예외처리() throws Exception{

        //given
        OrderRequestDto orderRequestDto = OrderRequestDto.builder()
                .orderId("OOOOOO1")
                .request("요청사항10000")
                .payType(PayType.Card)
                .memberId("MMMMMM1")
                .type(Status.COMPLETE)
                .build();

        //when
        Exception exception = assertThrows(RuntimeException.class, ()->{
            orderService.registerOrder(orderRequestDto);
        });

        //then
        String expectedMessage = "메뉴명은 필수 입력 값입니다.";
        String acutalMessage = exception.getMessage();
        assertEquals(acutalMessage,expectedMessage);
    }

    @Test
    @DisplayName("주문취소")
    public void  주문_취소() throws Exception{

        //given
        OrderRequestDto orderRequestDto = OrderRequestDto.builder()
                .orderId("OOOOOO1")
                .request("요청사항10000")
                .payType(PayType.Card)
                .memberId("MMMMMM1")
                .itemId("IIIIII1")
                .type(Status.COMPLETE)
                .build();

        orderService.registerOrder(orderRequestDto);

        //when
        Exception exception = assertThrows(RuntimeException.class, ()->{

            orderService.cancelOrder(orderRequestDto.getOrderId());

        });

        //then
        String expectedMessage = "결제 완료된 주문은 취소하실 수 없습니다.";
        String acutalMessage = exception.getMessage();
        assertEquals(acutalMessage,expectedMessage);
    }

    @Test
    @DisplayName("주문조회")
    public void  주문_조회() throws Exception{

        //given
        OrderRequestDto orderRequestDto = OrderRequestDto.builder()
                .orderId("OOOOOO1")
                .request("요청사항10000")
                .payType(PayType.Card)
                .memberId("MMMMMM1")
                .itemId("IIIIII1")
                .type(Status.COMPLETE)
                .build();

        orderService.registerOrder(orderRequestDto);

        OrderRequestSearchDto orderRequestSearchDto = OrderRequestSearchDto.builder()
                .memberName("주윤재")
                .build();

        //when
        orderService.findOrder(orderRequestSearchDto);

        //then
        assertEquals(1L,orderRepository.count());
        OrderResponeDto orderResponeDto = orderQueryRepository.findOrder(orderRequestSearchDto.getMemberName(),orderRequestSearchDto.getItemName()).get(0);
        assertEquals("OOOOOO1",orderResponeDto.getOrderId());
        assertEquals("주윤재",orderResponeDto.getMemberName());


    }
}