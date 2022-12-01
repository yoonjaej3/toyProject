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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;
    private final MemberQueryRepository memberQueryRepository;

    @GetMapping("/member/Buyer")
    public List<MemberBuyerDto> memberBuyerList(String type) {


        List<MemberBuyerDto> member = memberQueryRepository.findMemberBuyer(Type.valueOf("Buyer"));

        return member;

    }

    @GetMapping("/member/Seller")
    public List<MemberSellerDto> memberSellerList(String type) {


        List<MemberSellerDto> member = memberQueryRepository.findMemberSeller(Type.valueOf("Seller"));

        return member;

    }

    @GetMapping("/member/ORGANIZER")
    public List<MemberOrganizerDto> memberOrganizerList(@PathVariable("type") String type) {


        List<MemberOrganizerDto> member = memberQueryRepository.findMemberOrganizer(Type.valueOf("Organizer"));

        return member;

    }

    @GetMapping("/members")
    public List<Member> findAll() {

       return memberService.findMembers();

    }

    //TODO :저장

    //TODO : 삭제

    //TODO : 업데이트




}
