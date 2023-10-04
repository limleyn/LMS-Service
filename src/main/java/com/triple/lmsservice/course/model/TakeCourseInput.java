package com.triple.lmsservice.course.model;

import com.triple.lmsservice.admin.model.CommonParam;
import lombok.Data;

@Data
public class TakeCourseInput extends CommonParam {

    long courseId;
    String userId;

}
