package com.triple.lmsservice.course.model;

import com.triple.lmsservice.admin.model.CommonParam;
import lombok.Data;

@Data
public class CourseParam extends CommonParam {

    long id;//course.id
    long categoryId;

}
