package com.triple.lmsservice.member.controller;

import com.triple.lmsservice.member.entity.Member;
import com.triple.lmsservice.member.model.MemberInput;
import com.triple.lmsservice.member.model.ResetPasswordInput;
import com.triple.lmsservice.member.repository.MemberRepository;

import com.triple.lmsservice.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @RequestMapping("/member/login")
    public String login() {

        return "member/login";
    }

    @GetMapping("/member/find/password")
    public String findPassword() {
        return "member/find/password";
    }

    @PostMapping("/member/find/password")
    public String findPasswordSubmit(Model model, ResetPasswordInput parameter) {

        boolean result = false;
        try {
            result = memberService.sendResetPassword(parameter);
        } catch (Exception e){
        }
        model.addAttribute("result", result);

        return "member/find_password_result";
    }

    @GetMapping  ("/member/register")
    public String register() {

        return "member/register";
    }

    @PostMapping  ("/member/register")
    public String registerSubmit(Model model, HttpServletRequest request, MemberInput parameter) {

        boolean result = memberService.register(parameter);
        model.addAttribute("result", result);

        return "member/register_complete";
    }

    @GetMapping("/member/email-auth")
    public String emailAuth(Model model, HttpServletRequest request) {

        String uuid = request.getParameter("id");
        System.out.println(uuid);

        boolean result = memberService.emailAuth(uuid);
        model.addAttribute("result", result);


        return "member/email_auth";
    }

    @GetMapping("/member/info")
    public String memberInfo() {
        return "member/info";
    }

    @GetMapping("/member/reset/password")
    public String resetPassword(Model model, HttpServletRequest request) {

        String uuid = request.getParameter("id");

        boolean result = memberService.checkResetPassword(uuid);

        model.addAttribute("result", result);


        return "member/reset_password";
    }

    @PostMapping("/member/reset/password")
    public String resetPasswordSubmit(Model model, ResetPasswordInput parameter) {

        boolean result = false;
        try {
            result = memberService.resetPassword(parameter.getId(), parameter.getPassword());
        }catch (Exception e) {
        }
        model.addAttribute("result", result);

        return "member/reset_password_result";

    }
}
