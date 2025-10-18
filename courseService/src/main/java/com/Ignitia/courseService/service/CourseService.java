package com.Ignitia.courseService.service;

import com.Ignitia.courseService.entity.Course;
import com.Ignitia.courseService.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public Course registerCourse(Course course){
        return courseRepository.save(course);
    }

    public Course getCourse(long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }

    public Course updateCourse(Course course) {
        Course existingCourse = courseRepository.findById(course.getId())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + course.getId()));

        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());

        return courseRepository.save(existingCourse);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
