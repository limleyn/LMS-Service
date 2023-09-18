package com.triple.lmsservice.member.service;

import com.triple.lmsservice.member.entity.Member;
import com.triple.lmsservice.member.model.MemberInput;
import com.triple.lmsservice.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{


    private final MemberRepository memberRepository;
    @Override
    public boolean register(MemberInput parameter) {

        Member member = new Member();
        member.setUserId(parameter.getUserId());
        member.setUserName(parameter.getUserName());
        member.setPassWord(parameter.getPassword());
        member.setPhoneNumber(parameter.getPhoneNumber());
        member.setRegDt(LocalDateTime.now());

        memberRepository.save(member);
        return false;
    }
}
