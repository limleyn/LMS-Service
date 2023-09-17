package com.triple.lmsservice.member.controller;

import com.triple.lmsservice.member.entity.Member;
import com.triple.lmsservice.member.model.MemberInput;
import com.triple.lmsservice.member.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Controller
public class MemberController {

    private MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping  ("/member/register")
    public String register() {

        System.out.println("reguest get!");

        return "member/register";
    }

    //request WEB -> SERVER
    //response SERVER -> WEB
    @PostMapping  ("/member/register")
    public String registerSubmit(HttpServletRequest request, HttpServletResponse response
        , MemberInput parameter
    ) {

        System.out.println(parameter.toString());

        Member member = new Member();
        member.setUserId(parameter.getUserId());
        member.setUserName(parameter.getUserName());
        member.setPassWord(parameter.getPassword());
        member.setPhoneNumber(parameter.getPhoneNumber());
        member.setRegDt(LocalDateTime.now());

        memberRepository.save(member);

        return "member/register_complete";
    }
}
