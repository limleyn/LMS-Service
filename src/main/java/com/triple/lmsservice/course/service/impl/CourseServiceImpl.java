package com.triple.lmsservice.course.service.impl;

import com.triple.lmsservice.admin.dto.MemberDto;
import com.triple.lmsservice.course.dto.CourseDto;
import com.triple.lmsservice.course.entity.Course;
import com.triple.lmsservice.course.mapper.CourseMapper;
import com.triple.lmsservice.course.model.CourseInput;
import com.triple.lmsservice.course.model.CourseParam;
import com.triple.lmsservice.course.repository.CourseRepository;
import com.triple.lmsservice.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public boolean add(CourseInput parameter) {

        Course course = Course.builder()
                .subject(parameter.getSubject())
                .regDt(LocalDateTime.now())
                .build();
        courseRepository.save(course);
        return false;
    }

    @Override
    public List<CourseDto> list(CourseParam parameter) {

        long totalCount =courseMapper.selectListCount(parameter);

        List<CourseDto> list = courseMapper.selectList(parameter);
        if (!CollectionUtils.isEmpty(list)) {
            int i = 0;
            for(CourseDto x : list) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart()-i);
                i++;
            }
        }

        return list;

    }

    @Override
    public CourseDto getById(long id) {

        return courseRepository.findById(id).map(CourseDto::of).orElse(null);
    }
}
