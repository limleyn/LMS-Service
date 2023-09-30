package com.triple.lmsservice.course.mapper;

import com.triple.lmsservice.course.dto.CourseDto;
import com.triple.lmsservice.course.model.CourseParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {

    long selectListCount(CourseParam parameter);
    List<CourseDto> selectList(CourseParam parameter);
}
