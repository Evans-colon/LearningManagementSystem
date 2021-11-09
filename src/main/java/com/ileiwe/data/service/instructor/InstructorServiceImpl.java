package com.ileiwe.data.service.instructor;

import com.ileiwe.data.dto.CourseDto;
import com.ileiwe.data.dto.InstructorPartyDto;
import com.ileiwe.data.model.*;
import com.ileiwe.data.repository.CourseRepository;
import com.ileiwe.data.repository.InstructorRepository;
import com.ileiwe.data.repository.LearningPartyRepository;
import com.ileiwe.data.service.event.OnRegistrationCompleteEvent;
import com.ileiwe.data.service.exception.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstructorServiceImpl implements  InstructorService {

    @Autowired
    InstructorRepository instructorRepository;


    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    CourseRepository courseRepository;


    LearningPartyRepository learningPartyRepository;


    @Override
    public Instructor save(InstructorPartyDto instructorPartyDto)throws UserAlreadyExistException {

        if (instructorPartyDto == null) {
            throw new IllegalArgumentException("Instructor cannot be null");
        }


        if(learningPartyRepository.findByEmail(instructorPartyDto.getEmail()) == null){


        LearningParty learningParty = new LearningParty(instructorPartyDto.getEmail()
                ,passwordEncoder.encode(instructorPartyDto.getPassword()), new Authority(Role.ROLE_INSTRUCTOR));

        Instructor instructor = Instructor.builder()
                .lastname(instructorPartyDto.getLastname())
                .firstname(instructorPartyDto.getFirstname())
                .learningParty(learningParty).build();

        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(learningParty));

        return instructorRepository.save(instructor);


    }else{
            throw new UserAlreadyExistException("user with email " + instructorPartyDto.getEmail() + "already exist");
        }
    }





    @Override
    public Course createCourse(CourseDto courseDto) {
        Optional<Course> courseDtoOptional = Optional.ofNullable(courseRepository.findCourseByTitle(courseDto.getTitle()));
        if (courseDtoOptional.isPresent()) {
            throw new IllegalArgumentException("course exist");
        }
        Course course = Course.builder()
                .title(courseDto.getTitle())
                .description(courseDto.getDescription())
                .duration(courseDto.getDuration())
                .language(courseDto.getLanguage()).build();



        return courseRepository.save(course);

    }

    public Course viewCoursesByTitle(String title) {
        return courseRepository.findCourseByTitle(title);
    }

    public void deleteCourse(Long courseId){
        boolean exists = courseRepository.existsById(courseId);
        if(!exists){
            throw new IllegalArgumentException("course with id" + courseId + "does not exist");
        }
        if(courseId != null )
        courseRepository.deleteById(courseId);
    }

//    public void updateCourses(Long courseId, CourseDto courseDto) {
//        courseDto = instructorRepository.findById(courseId);
//    }
}
