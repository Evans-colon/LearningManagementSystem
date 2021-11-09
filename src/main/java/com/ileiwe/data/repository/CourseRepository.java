package com.ileiwe.data.repository;

import com.ileiwe.data.dto.CourseDto;
import com.ileiwe.data.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CourseRepository extends
        JpaRepository<Course, Long> {


    Course findCourseByTitle(String Title);
}
