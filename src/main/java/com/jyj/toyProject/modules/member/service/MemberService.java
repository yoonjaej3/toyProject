package com.jyj.toyProject.modules.member.service;

import com.jyj.toyProject.modules.member.dto.MemberDto;
import com.jyj.toyProject.modules.member.entity.Member;
import com.jyj.toyProject.modules.member.repository.interfaces.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     *  사용자 등록
     */
    @Transactional
    public Long registerMember(Member member) {

        Optional.ofNullable(member.getEmail()).orElseThrow(() -> new IllegalStateException("이메일은 필수 입력 값입니다."));

        return memberRepository.save(member).getId();
    }

    /**
     *  사용자 중복 체크
     */
    public boolean validateDuplicateMember(Member member) {

        List<Member> memberList = memberRepository.findAllByEmail(member.getId());

        return memberList.isEmpty();

    }


    public List<Member> findMembers() {

        return memberRepository.findAll();
    }
}
