package com.jyj.toyProject.modules.member.controller;

import com.jyj.toyProject.modules.member.dto.MemberBuyerDto;
import com.jyj.toyProject.modules.member.repository.interfaces.MemberRepository;
import com.jyj.toyProject.modules.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @GetMapping("/member/memberBuyer")
    public String memberBuyerList(Model model){

        List<MemberBuyerDto> member = memberRepository.findAll()
                .stream()
                .map(m->new MemberBuyerDto()).collect(Collectors.toList());

        return "member/memberBuyer/list";

    }

    //TODO :


}
