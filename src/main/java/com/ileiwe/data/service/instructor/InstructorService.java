package com.ileiwe.data.service.instructor;

import com.ileiwe.data.dto.CourseDto;
import com.ileiwe.data.dto.InstructorPartyDto;
import com.ileiwe.data.model.Course;
import com.ileiwe.data.model.Instructor;
import com.ileiwe.data.service.exception.UserAlreadyExistException;

public interface InstructorService {
    Instructor save(InstructorPartyDto instructor) throws UserAlreadyExistException;
    Course createCourse(CourseDto courseDto);
    Course viewCoursesByTitle(String title);
    void deleteCourse(Long courseId);
}
