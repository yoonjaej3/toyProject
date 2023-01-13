package com.jyj.toyProject.api.member.controller;

import com.jyj.toyProject.api.member.dto.MemberBuyerDto;
import com.jyj.toyProject.api.member.dto.MemberDto;
import com.jyj.toyProject.api.member.dto.MemberOrganizerDto;
import com.jyj.toyProject.api.member.dto.MemberSellerDto;
import com.jyj.toyProject.api.member.entity.Member;
import com.jyj.toyProject.api.member.enums.Type;
import com.jyj.toyProject.api.member.repository.impl.MemberQueryRepository;
import com.jyj.toyProject.api.member.repository.interfaces.MemberRepository;
import com.jyj.toyProject.api.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/members")
    public Long register(@RequestBody MemberDto memberdto){

        return memberService.registerMember(memberdto.toEntity());

    }

    @Transactional
    @DeleteMapping("/members/{id}")
    public void delete(@PathVariable("id") Long memberId){

        memberService.deleteMember(memberId);

    }

    @Transactional
    @PutMapping("/members")
    public String update(@RequestBody MemberDto memberDto){

        Optional<Member> member = memberRepository.findById(memberDto.getSeq());

        member.ifPresent(m->memberService.updateMember(memberDto.getSeq(),memberDto.getName()));

        return "성공";

    }

}
