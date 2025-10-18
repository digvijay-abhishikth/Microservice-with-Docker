package com.Ignitia.courseService.controller;

import com.Ignitia.courseService.entity.Course;
import com.Ignitia.courseService.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/allcourses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/getCourse/{cId}")
    public Course getCourse(@PathVariable(name = "cId") Long courseId) {
        return courseService.getCourse(courseId);
    }

    @PostMapping("/register")
    public Course addCourse(@RequestBody Course course) {
        return courseService.registerCourse(course);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Course Service!";
    }
}
