package com.triple.lmsservice.course.service;

import com.triple.lmsservice.course.dto.CourseDto;
import com.triple.lmsservice.course.model.CourseInput;
import com.triple.lmsservice.course.model.CourseParam;

import java.util.List;

public interface CourseService {

    /**
     * 강좌 등록
     */
    boolean add( CourseInput parameter);

    /**
     * 강좌 목록
     */
    List<CourseDto> list(CourseParam parameter);

    /**
     * 강좌 상세정보
     */
    CourseDto getById(long id);
}
