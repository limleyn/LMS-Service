package com.triple.lmsservice.course.service.impl;

import com.triple.lmsservice.course.dto.CourseDto;
import com.triple.lmsservice.course.entity.Course;
import com.triple.lmsservice.course.mapper.CourseMapper;
import com.triple.lmsservice.course.model.CourseInput;
import com.triple.lmsservice.course.model.CourseParam;
import com.triple.lmsservice.course.repository.CourseRepository;
import com.triple.lmsservice.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    private LocalDate getLocalDate(String value) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            return LocalDate.parse(value, formatter);
        } catch (Exception e) {

        }
        return null;
    }



    @Override
    public boolean add(CourseInput parameter) {

        LocalDate saleEndDt = getLocalDate(parameter.getSaleEndDtText());

        Course course = Course.builder()
                .categoryId(parameter.getCategoryId())
                .subject(parameter.getSubject())
                .keyword(parameter.getKeyword())
                .summary(parameter.getSummary())
                .contents(parameter.getContents())
                .price(parameter.getPrice())
                .salePrice(parameter.getSalePrice())
                //종료일 문자열
                .regDt(LocalDateTime.now())
                .build();
        courseRepository.save(course);

        return true;
    }

    @Override
    public boolean set(CourseInput parameter) {

        LocalDate saleEndDt = getLocalDate(parameter.getSaleEndDtText());

        Optional<Course> optionalCourse = courseRepository.findById(parameter.getId());
        if (!optionalCourse.isPresent()) {
            //수정할 데이터가 없음
            return false;
        }

        Course course = optionalCourse.get();
        course.setCategoryId(parameter.getCategoryId());
        course.setSubject(parameter.getSubject());
        course.setKeyword(parameter.getKeyword());
        course.setSummary(parameter.getSummary());
        course.setContents(parameter.getContents());
        course.setPrice(parameter.getPrice());
        course.setSalePrice(parameter.getSalePrice());
        course.setSaleEndDt(saleEndDt);
        course.setUdtDt(LocalDateTime.now());
        courseRepository.save(course);

        return true;
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

    @Override
    public boolean del(String idList) {

        if (idList != null && idList.length() > 0) {
            String[] ids = idList.split(",");
            for(String x : ids) {
                long id = 0L;
                try {
                    id = Long.parseLong(x);
                } catch (Exception e) {
                }

                if (id > 0) {
                    courseRepository.deleteById(id);
                }
            }
        }
        return true;
    }

    @Override
    public List<CourseDto> frontList(CourseParam parameter) {

        List<Course> courseList = courseRepository.findAll();

        return CourseDto.of(courseList);
    }
}
