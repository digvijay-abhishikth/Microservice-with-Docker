package com.Ignitia.studentService.controller;

import com.Ignitia.studentService.entity.Student;
import com.Ignitia.studentService.repository.StudentRepository;
import com.Ignitia.studentService.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public Student addStudent(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable(name = "id") Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Student Service!";
    }
}
