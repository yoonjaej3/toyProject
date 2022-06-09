package com.jyj.toyProject.modules.member.repository.interfaces;

import com.jyj.toyProject.modules.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
}
