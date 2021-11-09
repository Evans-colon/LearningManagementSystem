package com.ileiwe.controller;

import com.ileiwe.data.dto.CourseDto;
import com.ileiwe.data.dto.InstructorPartyDto;
import com.ileiwe.data.model.Course;
import com.ileiwe.data.service.exception.UserAlreadyExistException;
import com.ileiwe.data.service.instructor.InstructorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class RegistrationController {

    @Autowired
    private InstructorServiceImpl instructorService;


    @PostMapping("/instructor")
    public ResponseEntity<?> registerAsInstructor(@RequestBody InstructorPartyDto instructorPartyDto) throws UserAlreadyExistException {
        return ResponseEntity.ok()
                .body(instructorService.save(instructorPartyDto));
    }

    @PostMapping(path = "/instructor/course")
    public void createCourse(@RequestBody CourseDto courseDto){
        instructorService.createCourse(courseDto);
    }

    @GetMapping("/instructor/course{title}")
    public Course viewCourses(@PathVariable("title") String title){
        return instructorService.viewCoursesByTitle(title);

    }

    @DeleteMapping(path = "{courseId}")
    public void deleteCourse(@PathVariable("courseId") Long courseId){
        instructorService.deleteCourse(courseId);
    }

//    @PutMapping(path = "/instructor/{courseId}")
//    public void updateCourses(
//            @PathVariable("courseId") Long courseId,
//            @RequestParam(required = false) CourseDto courseDto(){
//
//        instructorService.updateCourses(courseId, courseDto);
//    }


}
