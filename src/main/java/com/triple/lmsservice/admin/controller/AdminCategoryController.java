package com.triple.lmsservice.admin.controller;

import com.triple.lmsservice.admin.dto.CategoryDto;
import com.triple.lmsservice.admin.dto.MemberDto;
import com.triple.lmsservice.admin.model.CategoryInput;
import com.triple.lmsservice.admin.model.MemberInput;
import com.triple.lmsservice.admin.model.MemberParam;
import com.triple.lmsservice.admin.sevice.CategoryService;
import com.triple.lmsservice.member.service.MemberService;
import com.triple.lmsservice.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminCategoryController {

    private final CategoryService categoryService;

    @GetMapping("/admin/category/list.do")
    public String list(Model model, MemberParam parameter) {

        List<CategoryDto> list = categoryService.list();
        model.addAttribute("list", list);

        return "admin/category/list";

    }

    @PostMapping("/admin/category/add.do")
    public String add(Model model, CategoryInput parameter) {

        boolean result = categoryService.add(parameter.getCategoryName());

        return "redirect:/admin/category/list.do";
    }

}
