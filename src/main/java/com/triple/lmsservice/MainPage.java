package com.triple.lmsservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainPage {

    @RequestMapping("/")
    public String index() {

        return "Index Page";
    }

    @RequestMapping("/hello")
    public String hello() {

        String msg =  "hello \r\n LMS-Service website!";

        return msg;
    }
}
