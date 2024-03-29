package com.triple.lmsservice.main.controller;

import com.triple.lmsservice.component.MailComponents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final MailComponents mailComponents;

    @RequestMapping("/")
    public String index() {
/*
        String email = "leyn5353@gmail.com";
        String subject = "안녕하세요 임은영 입니다.";
        String text = "<p>안녕하세요.</p>반갑습니다.<p>";

        mailComponents.sendMail(email, subject, text);
*/
        return "index";
    }

    @RequestMapping("/error/denied")
    public String errorDenied() {

        return "error/denied";
    }


}

