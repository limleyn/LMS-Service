package com.triple.lmsservice.member.controller;

import com.triple.lmsservice.member.entity.Member;
import com.triple.lmsservice.member.model.MemberInput;
import com.triple.lmsservice.member.repository.MemberRepository;
import com.triple.lmsservice.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;




    @GetMapping  ("/member/register")
    public String register() {

        System.out.println("reguest get!");

        return "member/register";
    }

    //request WEB -> SERVER
    //response SERVER -> WEB
    @PostMapping  ("/member/register")
    public String registerSubmit(HttpServletRequest request, HttpServletResponse response
        , MemberInput parameter) {

        boolean result = memberService.register(parameter);

        return "member/register_complete";
    }
}
