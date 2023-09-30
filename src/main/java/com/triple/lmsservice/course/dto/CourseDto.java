package com.triple.lmsservice.course.dto;

import com.triple.lmsservice.course.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CourseDto {

    Long id;
    String imagePath;
    String keyword;
    String subject;
    String summary;
    String contents;
    long price;
    long salePrice;
    LocalDateTime saleEndDt;
    LocalDateTime regDt; //등록일(추가날짜)
    LocalDateTime udtDt; //수정일(수정날짜)

    //추가컬럼
    long totalCount;
    long seq;

    public static CourseDto of(Course course) {

        return CourseDto.builder()
                .id(course.getId())
                .imagePath(course.getImagePath())
                .keyword(course.getKeyword())
                .subject(course.getSubject())
                .summary(course.getSummary())
                .contents(course.getContents())
                .price(course.getPrice())
                .salePrice(course.getSalePrice())
                .saleEndDt(course.getSaleEndDt())
                .regDt(course.getRegDt())
                .udtDt(course.getUdtDt())
                .build();

    }

}
