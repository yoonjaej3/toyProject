package com.jyj.toyProject.api.member.repository.interfaces;

import com.jyj.toyProject.api.member.dto.MemberBuyerDto;
import com.jyj.toyProject.api.member.dto.MemberOrganizerDto;
import com.jyj.toyProject.api.member.dto.MemberSellerDto;
import com.jyj.toyProject.api.member.entity.Member;
import com.jyj.toyProject.api.member.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long>{

}
