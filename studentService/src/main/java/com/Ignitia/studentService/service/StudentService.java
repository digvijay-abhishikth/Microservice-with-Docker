package com.Ignitia.studentService.service;

import com.Ignitia.studentService.entity.Student;
import com.Ignitia.studentService.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student registerStudent(Student student){
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id){
        return this.studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
