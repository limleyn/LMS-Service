package com.triple.lmsservice.member.repository;

import com.triple.lmsservice.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
