package com.jyj.toyProject.api.member.service;

import com.jyj.toyProject.api.member.entity.Member;
import com.jyj.toyProject.api.member.repository.interfaces.MemberRepository;
import com.jyj.toyProject.api.member.repository.interfaces.MemberRepositoryCoustom;
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

    private final MemberRepositoryCoustom memberRepositoryCustom;

    /**
     *  사용자 등록
     */
    @Transactional
    public Long registerMember(Member member) {

        Optional.ofNullable(member.getEmail()).orElseThrow(() -> new IllegalStateException("이메일은 필수 입력 값입니다."));

        return memberRepository.save(member).getSeq();
    }

    /**
     *  사용자 중복 체크
     */
    public boolean validateDuplicateMember(Member member) {

        Member findMember = memberRepository.getById(member.getSeq());

//        if (findMember == null) {
//            return false; // 해당 멤버의 정보가 데이터베이스에 존재하지 않으면 false를 반환
//        } else {
//            return true; // 해당 멤버의 정보가 데이터베이스에 이미 존재하면 true를 반환
//        }

        Optional<Member> optionalMember = memberRepository.findById(member.getSeq());

        return optionalMember.isPresent();

    }

    /**
     *  사용자 조회
     */
    public List<Member> findMembers() {

        return memberRepository.findAll();
    }

    /**
     *  사용자 삭제
     */
    public void deleteMember(Long memberId){

        Member member = memberRepository.getById(memberId);

        memberRepository.delete(member);

    }

    /**
     *  사용자 수정
     */
    @Transactional
    public void updateMember(Long id, String name){

        Member member = memberRepository.getById(id);

        member.setName(name);

    }

}
