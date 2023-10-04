package com.triple.lmsservice.course.controller;

import com.triple.lmsservice.admin.sevice.CategoryService;
import com.triple.lmsservice.common.model.ResponseResult;
import com.triple.lmsservice.common.model.ResponseResultHeader;
import com.triple.lmsservice.course.model.ServiceResult;
import com.triple.lmsservice.course.model.TakeCourseInput;
import com.triple.lmsservice.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.xml.ws.Response;
import java.security.Principal;

@RequiredArgsConstructor
@Controller
public class ApiCourseController extends BaseController {

    private final CourseService courseService;
    private final CategoryService categoryService;

    @PostMapping("/api/course/req.api")
    public ResponseEntity<?> courseReq(Model model
            , @RequestBody TakeCourseInput parameter
            , Principal principal) {

        parameter.setUserId(principal.getName());

        ServiceResult result = courseService.req(parameter);
        if(!result.isResult()) {

            ResponseResult responseResult = new ResponseResult(false, result.getMessage());
            return ResponseEntity.ok().body(result.getMessage());
        }

        ResponseResult responseResult = new ResponseResult(true);
        return ResponseEntity.ok().body(parameter);
    }


}
