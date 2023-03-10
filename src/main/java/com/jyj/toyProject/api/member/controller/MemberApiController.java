package com.jyj.toyProject.api.member.controller;

import com.jyj.toyProject.api.member.dto.MemberBuyerDto;
import com.jyj.toyProject.api.member.dto.MemberDto;
import com.jyj.toyProject.api.member.dto.MemberOrganizerDto;
import com.jyj.toyProject.api.member.dto.MemberSellerDto;
import com.jyj.toyProject.api.member.entity.Member;
import com.jyj.toyProject.api.member.enums.Type;
import com.jyj.toyProject.api.member.exception.MemberNotFoundException;
import com.jyj.toyProject.api.member.repository.interfaces.MemberRepository;
import com.jyj.toyProject.api.member.repository.interfaces.MemberRepositoryCoustom;
import com.jyj.toyProject.api.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;
    private final MemberRepositoryCoustom memberRepositoryCoustom;


    @GetMapping("/member/Buyer")
    public List<MemberBuyerDto> memberBuyerList(String type) {


        List<MemberBuyerDto> member = memberRepositoryCoustom.findMemberBuyer(Type.valueOf("Buyer"));

        return member;

    }

    @GetMapping("/member/Seller")
    public List<MemberSellerDto> memberSellerList(String type) {


        List<MemberSellerDto> member = memberRepositoryCoustom.findMemberSeller(Type.valueOf("Seller"));

        return member;

    }

    @GetMapping("/member/Organizer")
    public List<MemberOrganizerDto> memberOrganizerList(@PathVariable("type") String type) {


        List<MemberOrganizerDto> member = memberRepositoryCoustom.findMemberOrganizer(Type.valueOf("Organizer"));

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
    public ResponseEntity<Void> update(@RequestBody MemberDto memberDto){

        Optional<Member> member = memberRepository.findById(memberDto.getSeq());

        if (!member.isPresent()) {
            throw new MemberNotFoundException("해당 멤버가 존재하지 않습니다.");
        }

        memberService.updateMember(memberDto.getSeq(), memberDto.getName());

        return ResponseEntity.ok().build();

    }

}
