package com.jyj.toyProject.modules.member.controller;

import com.jyj.toyProject.modules.member.dto.MemberBuyerDto;
import com.jyj.toyProject.modules.member.dto.MemberOrganizerDto;
import com.jyj.toyProject.modules.member.dto.MemberSellerDto;
import com.jyj.toyProject.modules.member.entity.Member;
import com.jyj.toyProject.modules.member.enums.Type;
import com.jyj.toyProject.modules.member.repository.impl.MemberQueryRepository;
import com.jyj.toyProject.modules.member.repository.interfaces.MemberRepository;
import com.jyj.toyProject.modules.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.xml.transform.Result;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;
    private final MemberQueryRepository memberQueryRepository;

    @GetMapping("/member/memberBuyer")
    public String memberBuyerList(Model model){

        List<MemberBuyerDto> member = memberRepository.findAll()
                .stream()
                .map(m->new MemberBuyerDto()).collect(Collectors.toList());

        return "member/memberBuyer/list";

    }

    @GetMapping("/member/{type}")
    public String memberTypeList(@PathVariable("type") String type) {

        if (type.equalsIgnoreCase("BUYER")) {

            List<MemberBuyerDto> member = memberQueryRepository.findMemberBuyer(Type.valueOf("Buyer"));

            return member.toString();

        } else if (type.equalsIgnoreCase("SELLER")) {

            List<MemberSellerDto> member = memberQueryRepository.findMemberSeller(Type.valueOf("Seller"));

            return member.toString();

        } else if (type.equalsIgnoreCase("ORGANIZER")) {

            List<MemberOrganizerDto> member = memberQueryRepository.findMemberOrganizer(Type.valueOf("Organizer"));

            return member.toString();

        }

        return "nothing";
    }

    //TODO :


}
