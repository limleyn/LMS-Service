package com.triple.lmsservice.course.repository;

import com.triple.lmsservice.course.entity.Course;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.time.LocalDateTime;

public interface CourseRepository extends JpaRepository<Course, Long> {


}
